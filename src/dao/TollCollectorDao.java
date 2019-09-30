package dao;

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
    public boolean getTollCollector(String tollCollectorNo, TollCollectorInfo collector) {
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from tollCollectorinfo where tollCollectorNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tollCollectorNo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
                collector.setTollCollectorNo(rs.getString("tollCollectorNo"));
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
        return flag;
    }
}
