package dao;

import bean.TrafficInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrafficDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    //通过cardNo获取traffic信息并存入traffic
    public boolean setTraffic(String cardNo, TrafficInfo traffic){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from trafficInfo where cardNo=? and endTollBooshNo is null";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cardNo);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                flag = true;
                traffic.setCardNo(rs.getString("cardNo"));
                traffic.setStartTollBooshNo(rs.getString("startTollBooshNo"));
                traffic.setStartLaneNo(rs.getString("startLaneNo"));
                traffic.setStartTime(rs.getString("startTime"));
                traffic.setEndTollBooshNo(rs.getString("endTollBooshNo"));
                traffic.setEndLaneNo(rs.getString("endLaneNo"));
                traffic.setEndTime(rs.getString("endTime"));
                traffic.setMileage(rs.getFloat("mileage"));
                traffic.setTotalFee(rs.getFloat("totalFee"));
            }
            if(rs!=null) {
                rs.close();
            }
            if(pstmt!=null) {
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
