package dao;

import bean.TrafficVolume;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrafficVolumeDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    public boolean getTrafficVolume(TrafficVolume trafficVolume){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql1 = "select * from trafficVolume where tollBooshNo=? and laneNo=? and carType=?";
            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1, trafficVolume.getTollBooshNo());
            pstmt.setString(2, trafficVolume.getLaneNo());
            pstmt.setString(3, trafficVolume.getCarType());
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                trafficVolume.setNumbersOfPass(rs.getInt("numbersOfPass"));
                flag = true;
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

    public boolean updataTrafficVoulme(TrafficVolume trafficVolume){
        boolean flag = false;
        dbConn = new DatabaseConn();
        if(getTrafficVolume(trafficVolume)) {   //表中是否已有，如果有就更新，没有就新建
            try {
                conn = dbConn.getConnection();
                String sql = "UPDATE trafficVolume SET numbersOfPass=? where tollBooshNo=? and laneNo=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,trafficVolume.getNumbersOfPass()+1);
                pstmt.setString(2,trafficVolume.getTollBooshNo());
                pstmt.setString(3,trafficVolume.getLaneNo());
                pstmt.setString(4,trafficVolume.getCarType());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    flag = true;
                }
                if (pstmt != null)
                    pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conn != null)
                    DatabaseConn.closeConn(conn);
            }
        }else {
            try {
                conn = dbConn.getConnection();
                String sql = "insert into trafficVolume(tollBooshNo,laneNo,carType,numbersOfPass) values(?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,trafficVolume.getTollBooshNo());
                pstmt.setString(2,trafficVolume.getLaneNo());
                pstmt.setString(3,trafficVolume.getCarType());
                pstmt.setInt(4,1);
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    flag = true;
                }
                if (pstmt != null)
                    pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conn != null)
                    DatabaseConn.closeConn(conn);
            }
        }
        return flag;
    }
}
