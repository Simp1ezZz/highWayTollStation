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

    //查找所有totalFee内容并把
    public int getTotalFee(ArrayList<TotalFee> feeArrayList){
        int total = 0;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from totalFee";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                total++;
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
        return total;
    }

    //根据日前查找totalFee内容
    public int getTotalFeeInSelect(String date,String tollBooshNo,String tollCollectorNo,String carType,ArrayList<TotalFee> feeArrayList) {
        int total = 0;
        dbConn = new DatabaseConn();
        boolean haveDate = !date.equals("null");
        boolean haveTollBooshNo = !tollBooshNo.equals("null");
        boolean haveTollCollectorNo = !tollCollectorNo.equals("null");
        boolean haveCarType = !carType.equals("null");
        try {
            conn = dbConn.getConnection();
            if(haveDate&&haveTollBooshNo&&haveTollCollectorNo&&haveCarType) {
                String sql = "select * from totalFee where left(time,?)=? and tollBooshNo=? and collectorNo=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, date);
                pstmt.setString(3,tollBooshNo);
                pstmt.setString(4,tollCollectorNo);
                pstmt.setString(5,carType);
                rs = pstmt.executeQuery();
            }else if(haveDate&&haveTollBooshNo&&haveTollCollectorNo){
                String sql = "select * from totalFee where left(time,?)=? and tollBooshNo=? and collectorNo=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, date);
                pstmt.setString(3,tollBooshNo);
                pstmt.setString(4,tollCollectorNo);
                rs = pstmt.executeQuery();
            }else if(haveDate&&haveTollBooshNo&&haveCarType){
                String sql = "select * from totalFee where left(time,?)=? and tollBooshNo=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, date);
                pstmt.setString(3,tollBooshNo);
                pstmt.setString(4,carType);
                rs = pstmt.executeQuery();
            }else if(haveDate&&haveTollCollectorNo&&haveCarType){
                String sql = "select * from totalFee where left(time,?)=? and collectorNo=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, date);
                pstmt.setString(3,tollCollectorNo);
                pstmt.setString(4,carType);
                rs = pstmt.executeQuery();
            }else if(haveTollBooshNo&&haveTollCollectorNo&&haveCarType){
                String sql = "select * from totalFee where tollBooshNo=? and collectorNo=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,tollBooshNo);
                pstmt.setString(2,tollCollectorNo);
                pstmt.setString(3,carType);
                rs = pstmt.executeQuery();
            }else if(haveDate&&haveTollBooshNo){
                String sql = "select * from totalFee where left(time,?)=? and tollBooshNo=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, date);
                pstmt.setString(3,tollBooshNo);
                rs = pstmt.executeQuery();
            }else if(haveDate&&haveTollCollectorNo){
                String sql = "select * from totalFee where left(time,?)=? and collectorNo=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, date);
                pstmt.setString(3,tollCollectorNo);
                rs = pstmt.executeQuery();
            }else if (haveDate&&haveCarType){
                String sql = "select * from totalFee where left(time,?)=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, date);
                pstmt.setString(3,carType);
                rs = pstmt.executeQuery();
            }else if(haveTollBooshNo&&haveTollCollectorNo){
                String sql = "select * from totalFee where tollBooshNo=? and collectorNo=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,tollBooshNo);
                pstmt.setString(2,tollCollectorNo);
                rs = pstmt.executeQuery();
            }else if(haveTollBooshNo&&haveCarType){
                String sql = "select * from totalFee where tollBooshNo=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,tollBooshNo);
                pstmt.setString(2,carType);
                rs = pstmt.executeQuery();
            }else if(haveTollCollectorNo&&haveCarType){
                String sql = "select * from totalFee where collectorNo=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,tollCollectorNo);
                pstmt.setString(2,carType);
                rs = pstmt.executeQuery();
            }else if(haveDate){
                String sql = "select * from totalFee where left(time,?)=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, date);
                rs = pstmt.executeQuery();
            }else if(haveTollBooshNo){
                String sql = "select * from totalFee where tollBooshNo=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,tollBooshNo);
                rs = pstmt.executeQuery();
            }else if(haveTollCollectorNo){
                String sql = "select * from totalFee where collectorNo=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,tollCollectorNo);
                rs = pstmt.executeQuery();
            }else if(haveCarType){
                String sql = "select * from totalFee where carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,carType);
                rs = pstmt.executeQuery();
            }else {
                String sql = "select * from totalFee";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
            }
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
                total++;
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
        return total;
    }
}
