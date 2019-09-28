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


    //查询工作日志
    public ArrayList<WorkLog> listAll(String tollCollectorNo) throws SQLException{
        ArrayList<WorkLog> list = new ArrayList<WorkLog>();
        dbConn = new DatabaseConn();
        try {
            String sql = "select * from worklog where tollCollectorNo=?";
            conn=dbConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,tollCollectorNo);
            rs = pstmt.executeQuery();
            WorkLog log = new WorkLog();
            while (rs.next())
            {
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

    //上班打卡
    public boolean startWork(WorkLog log){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            String sql = "insert into worklog(tollCollectorNo,tollBooshNo,startWorkTime,) values(?,?,?)";
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
        boolean onWork = false;
        dbConn = new DatabaseConn();
        try {
            String sql1 = "select * from worklog where tollCollectorNo=? and tollBooshNo=? and startWorkTime=?";
            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1,log.getTollCollectorNo());
            pstmt.setString(2,log.getTollBooshNo());
            pstmt.setString(3,log.getStartWorkTime());
            rs = pstmt.executeQuery();
            if (rs.next())
                onWork = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if (!onWork)
            {
                /*  上班未打卡处理     */
            }else
            {
                String sql2 = "insert into worklog(tollCollectorNo,tollBooshNo,finishWorkTime,) values(?,?,?)";
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, log.getTollCollectorNo());
                pstmt.setString(2, log.getTollBooshNo());
                pstmt.setString(3, log.getFinishWorkTime());
                int i = pstmt.executeUpdate();
                if (i > 0)
                    flag = true;
                if (pstmt != null)
                    pstmt.close();
            }
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
