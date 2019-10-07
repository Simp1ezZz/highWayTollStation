package dao;

import bean.LaneInfo;
import bean.TollBooshInfo;
import bean.TollCollectorInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TollCollectorDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    public TollCollectorDao(){

    }
    //收费员是否在系统
    public boolean getTollCollectorNo(String tollCollectorNo) {
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select tollCollectorNo from tollCollectorinfo where tollCollectorNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tollCollectorNo);
            rs = pstmt.executeQuery();
            if (rs.next())
                flag = true;
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                DatabaseConn.closeConn(conn);
        }
        return flag;
    }

    //查询收费员信息
    public TollCollectorInfo getTollCollector(String tollCollectorNo) {
        TollCollectorInfo collector = new TollCollectorInfo();
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from tollCollectorinfo where tollCollectorNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tollCollectorNo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                collector.setTollCollectorNo(rs.getString("tollCollectorNo"));
                collector.setLaneNo(rs.getString("laneNo"));
                collector.setTollBoothNo(rs.getString("tollBoothNo"));
                collector.setName(rs.getString("name"));
                collector.setSex(rs.getString("sex"));
                collector.setDepartment(rs.getString("department"));
                collector.setEmail(rs.getString("email"));
                collector.setPosition(rs.getString("position"));
                collector.setEntryTime(rs.getString("entryTime"));
                collector.setHomeAddress(rs.getString("homeAddress"));
                collector.setPhoneNo(rs.getString("phoneNo"));
            }
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                DatabaseConn.closeConn(conn);
        }
        return collector;
    }

    //查询收费员所在收费站名称及所属车道
    public boolean getTollBooshAndLane(String tollCollectorNo, LaneInfo lane, TollBooshInfo tollBoosh){
        boolean flag= false;
        lane = new LaneInfo();
        tollBoosh = new TollBooshInfo();
        conn = dbConn.getConnection();
        TollCollectorInfo collector = getTollCollector(tollCollectorNo);
        String tollBooshNo = collector.getTollBoothNo();
        String laneNo = collector.getLaneNo();
        try{
            String sql1="select * from tollBooshInfo where tollBooshNo=?";
            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1, tollBooshNo);
            rs = pstmt.executeQuery();
            if(rs.next()){
                tollBoosh.setTollBooshNo(rs.getString("tollBooshNo"));
                tollBoosh.setTollBooshName(rs.getString("tollBooshName"));
                tollBoosh.setNumbersOfLane(rs.getInt("numbersOfLane"));
                tollBoosh.setTotalTrafficTime(rs.getFloat("totalTrafficTime"));
                tollBoosh.setTotalTrafficVolume(rs.getInt("totalTrafficVolume"));
            }
            String sql2="select * from laneInfo where laneNo=?";
            pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1,laneNo);
            rs = pstmt.executeQuery();
            if(rs.next()){
                lane.setLaneNo(rs.getString("laneNo"));
                lane.setLaneName(rs.getString("laneName"));
                lane.setPrincipal(rs.getString("principal"));
                lane.setTrafficVolume(rs.getInt("trafficVolume"));
                lane.setTrafficTime(rs.getFloat("trafficTime"));
                lane.setTollBooshNo(rs.getString("tollBooshNo"));
            }
            if(lane!=null&&tollBoosh!=null)
                flag = true;
            if(rs!=null){
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)
                DatabaseConn.closeConn(conn);
        }
        return flag;
    }

}
