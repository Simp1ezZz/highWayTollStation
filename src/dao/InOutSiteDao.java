package dao;

import bean.CardInfo;
import bean.TrafficInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InOutSiteDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    //车辆入站
    public boolean inSite(TrafficInfo traffic){
        boolean flag = false;
        dbConn = new DatabaseConn();
        if(isOutSite(traffic.getCardNo())) {
            try {
                conn = dbConn.getConnection();
                String sql = "insert into trafficInfo(cardNo,startTollBooshNo,startLaneNo,startTime,carType) values(?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, traffic.getCardNo());
                pstmt.setString(2, traffic.getStartTollBooshNo());
                pstmt.setString(3, traffic.getStartLaneNo());
                pstmt.setString(4, traffic.getStartTime());
                pstmt.setString(5,traffic.getCarType());
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

    //是否有入站记录
    public boolean isInSite(String cardNo){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "SELECT * FROM trafficinfo WHERE cardNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cardNo);
            rs = pstmt.executeQuery();
            if(rs.next()){
                flag = true;
            }
            if(rs!=null)
                rs.close();
            if(pstmt!=null)
                pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)
                DatabaseConn.closeConn(conn);
        }
        return flag;
    }

    //是否已经出站
    public boolean isOutSite(String cardNo){
        boolean flag = true;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "SELECT * FROM trafficinfo WHERE cardNo=? AND endTollBooshNo is NULL";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cardNo);
            rs = pstmt.executeQuery();
            if(rs.next()){
                flag = false;
            }
            if(rs!=null)
                rs.close();
            if(pstmt!=null)
                pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)
                DatabaseConn.closeConn(conn);
        }

        return flag;
    }

    //车辆出站
    public boolean outSite(TrafficInfo traffic) {
        boolean flag = false;
        dbConn = new DatabaseConn();
        if(isInSite(traffic.getCardNo())&&!isOutSite(traffic.getCardNo())) { //是否可以写入
            try {
                conn = dbConn.getConnection();
                String sql = "UPDATE trafficinfo SET endTollBooshNo=?,endLaneNo=?,endTime=?,mileage=?,totalFee=?,carType=? where cardNo=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, traffic.getEndTollBooshNo());
                pstmt.setString(2,traffic.getEndLaneNo());
                pstmt.setString(3, traffic.getEndTime());
                pstmt.setFloat(4, traffic.getMileage());
                pstmt.setFloat(5, traffic.getTotalFee());
                pstmt.setString(6,traffic.getCarType());
                pstmt.setString(7, traffic.getCardNo());
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
