package dao;

import bean.FeeRateInfo;
import bean.LaneInfo;
import bean.TotalFee;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FeeDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    //根据roadNo和carType获取费率信息
    public boolean setFee(String roadNo, String carType,FeeRateInfo fee){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from feeRateInfo where roadNo=? and carType=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, roadNo);
            pstmt.setString(2,carType);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                flag = true;
                fee.setRoadNo(rs.getString("roadNo"));
                fee.setCarType(rs.getString("carType"));
                fee.setFee(rs.getFloat("fee"));
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

    //总费用计入账目
    public boolean accountEntry(TotalFee totalFee){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "insert into totalFee(time,collectorNo,cardNo,carType,tollBooshNo,laneNo,fee) values(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, totalFee.getTime());
            pstmt.setString(2, totalFee.getCollectorNo());
            pstmt.setString(3, totalFee.getCardNo());
            pstmt.setString(4, totalFee.getCarType());
            pstmt.setString(5, totalFee.getTollBooshNo());
            pstmt.setString(6, totalFee.getLaneNo());
            pstmt.setFloat (7, totalFee.getFee());
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
        return flag;
    }

    //查找所有totalFee内容
    public ArrayList<TotalFee> getTotalFee(){
        dbConn = new DatabaseConn();
        ArrayList<TotalFee> feeArrayList = new ArrayList<>();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from totalFee";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                TotalFee totalFee = new TotalFee();
                totalFee.setTime(rs.getString("time"));
                totalFee.setTollBooshNo(rs.getString("tollBooshNo"));
                totalFee.setLaneNo(rs.getString("laneNo"));
                totalFee.setCardNo(rs.getString("cardNo"));
                totalFee.setCarType(rs.getString("carType"));
                totalFee.setFee(rs.getFloat("fee"));
                totalFee.setCollectorNo(rs.getString("collectorNo"));
                feeArrayList.add(totalFee);
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
        return feeArrayList;
    }

    //根据日前查找totalFee内容
    public ArrayList<TotalFee> getTotalFeeInDay(String date) {
        dbConn = new DatabaseConn();
        ArrayList<TotalFee> feeArrayList = new ArrayList<>();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from totalFee where left(time,?)=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,10);
            pstmt.setString(2, date);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TotalFee totalFee = new TotalFee();
                totalFee.setTime(rs.getString("time"));
                totalFee.setTollBooshNo(rs.getString("tollBooshNo"));
                totalFee.setLaneNo(rs.getString("laneNo"));
                totalFee.setCardNo(rs.getString("cardNo"));
                totalFee.setCarType(rs.getString("carType"));
                totalFee.setFee(rs.getFloat("fee"));
                totalFee.setCollectorNo(rs.getString("collectorNo"));
                feeArrayList.add(totalFee);
            }
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                DatabaseConn.closeConn(conn);
        }
        return feeArrayList;
    }
}
