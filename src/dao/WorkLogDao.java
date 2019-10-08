package dao;

import bean.WorkLog;
import utils.DatabaseConn;

import java.sql.*;
import java.util.*;

public class WorkLogDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;


    //查询工作日志并封装成ArrayList
    public ArrayList<WorkLog> listAll(String tollCollectorNo) throws SQLException{
        ArrayList<WorkLog> list = new ArrayList<WorkLog>();
        dbConn = new DatabaseConn();
        try {
            String sql = "select * from worklog where tollCollectorNo=?";
            conn=dbConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,tollCollectorNo);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                WorkLog log = new WorkLog();
                log.setTollCollectorNo(rs.getString("tollCollectorNo"));
                log.setTollBooshNo(rs.getString("tollBooshNo"));
                log.setStartWorkTime(rs.getString("startWorkTime"));
                log.setFinishWorkTime(rs.getString("finishWorkTime"));
                list.add(log);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (conn != null)
                DatabaseConn.closeConn(conn);
        }
        return list;
    }
    //查询是否正在工作（即点击过打卡上班后是否点击打卡下班）
    public boolean onWork(String tollCollectorNo){
        boolean flag = true;
        dbConn = new DatabaseConn();
        WorkLog log = new WorkLog();
        try {
            conn = dbConn.getConnection();
            String sql = " select * from worklog where tollCollectorNo=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,tollCollectorNo);
            rs = pstmt.executeQuery();
            //执行完while后最终log里存放的是最后一个查询到的数据
            while (rs.next()) {
                log.setTollCollectorNo(rs.getString("tollCollectorNo"));
                log.setStartWorkTime(rs.getString("startWorkTime"));
                log.setFinishWorkTime(rs.getString("finishWorkTime"));
            }
            if(log.getFinishWorkTime()!=null)
                flag=false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (conn != null)
                DatabaseConn.closeConn(conn);
        }
        return flag;
    }
    //上班打卡
    public boolean startWork(WorkLog log){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "insert into worklog(tollCollectorNo,tollBooshNo,startWorkTime) values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, log.getTollCollectorNo());
            pstmt.setString(2, log.getTollBooshNo());
            pstmt.setString(3, log.getStartWorkTime());
            int i = pstmt.executeUpdate();
            if (i > 0)
                flag = true;
            if (pstmt != null)
                pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn!=null)
                DatabaseConn.closeConn(conn);
        }

        return flag;
    }

    //下班打卡
    public boolean finishWork(WorkLog log){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "UPDATE worklog SET finishWorkTime=? where tollCollectorNo=? and tollBooshNo=? and startWorkTime=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, log.getFinishWorkTime());
            pstmt.setString(2, log.getTollCollectorNo());
            pstmt.setString(3, log.getTollBooshNo());
            pstmt.setString(4,log.getStartWorkTime());
            int i = pstmt.executeUpdate();
            if (i > 0)
                flag = true;
            if (pstmt != null)
                pstmt.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (conn!=null)
                DatabaseConn.closeConn(conn);
        }
        return flag;
    }

}
