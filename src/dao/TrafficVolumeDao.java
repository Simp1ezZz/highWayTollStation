package dao;

import bean.TotalFee;
import bean.TrafficInfo;
import bean.TrafficVolume;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    //更新表信息
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

    //获取所有符合条件的trafficInfo
    public int getTrafficInfoInSelect(String time, String tollBooshNo,String carType, ArrayList<TrafficInfo> trafficInfoArrayList){
        int total = 0;
        boolean haveTime = !time.equals("null");
        boolean haveTollBooshNo = !tollBooshNo.equals("null");
        boolean haveCarType = !carType.equals("null");
        System.out.println(haveTime+" "+haveTollBooshNo+" "+haveCarType);
        dbConn = new DatabaseConn();
        try{
            conn = dbConn.getConnection();
            if(haveTime&&haveTollBooshNo&&haveCarType){
                String sql="select * from trafficInfo where left(startTime,?)=? and startTollBooshNo=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, time);
                pstmt.setString(3,tollBooshNo);
                pstmt.setString(4,carType);
                rs = pstmt.executeQuery();
            }else if(haveTime&&haveTollBooshNo){
                String sql="select * from trafficInfo where left(startTime,?)=? and startTollBooshNo=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, time);
                pstmt.setString(3,tollBooshNo);
                rs = pstmt.executeQuery();
            }else if(haveTime&&haveCarType){
                String sql="select * from trafficInfo where left(startTime,?)=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, time);
                pstmt.setString(3,carType);
                rs = pstmt.executeQuery();
            }else if(haveTollBooshNo&&haveCarType){
                String sql="select * from trafficInfo where startTollBooshNo=? and carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,tollBooshNo);
                pstmt.setString(2,carType);
                rs = pstmt.executeQuery();
            }else if(haveTime){
                String sql="select * from trafficInfo where left(startTime,?)=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, 10);
                pstmt.setString(2, time);
                rs = pstmt.executeQuery();
            }else if(haveTollBooshNo){
                String sql="select * from trafficInfo where startTollBooshNo=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,tollBooshNo);
                rs = pstmt.executeQuery();
            }else if(haveCarType){
                String sql="select * from trafficInfo where carType=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,carType);
                rs = pstmt.executeQuery();
            }else {
                String sql="select * from trafficInfo";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
            }
            while (rs.next()) {
                TrafficInfo trafficInfo = new TrafficInfo();
                trafficInfo.setCardNo(rs.getString("cardNo"));
                trafficInfo.setCarType(rs.getString("carType"));
                trafficInfo.setStartTollBooshNo(rs.getString("startTollBooshNo"));
                trafficInfo.setStartLaneNo(rs.getString("startLaneNo"));
                trafficInfo.setStartTime(rs.getString("startTime"));
                trafficInfo.setEndTollBooshNo(rs.getString("endTollBooshNo"));
                trafficInfo.setEndLaneNo(rs.getString("endLaneNo"));
                trafficInfo.setEndTime(rs.getString("endTime"));
                trafficInfo.setMileage(rs.getFloat("mileage"));
                trafficInfo.setTotalFee(rs.getFloat("totalFee"));
                trafficInfoArrayList.add(trafficInfo);
                total++;
            }
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                DatabaseConn.closeConn(conn);
        }

        return total;
    }
}
