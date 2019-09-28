package dao;

import bean.AdminInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    public AdminDao() {

    }
    //用户注册
    public AdminInfo userLogin(String userName, String passWord) {
        AdminInfo User = null;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from admin where userName=? and passWord=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, passWord);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                User = new AdminInfo();
                User.setUserName(rs.getString("userName"));
                User.setPassWord(rs.getString("passWord"));
                User.setTollCollectorNo(rs.getString("tollCollectorNo"));
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
        return User;
    }
    //用户是否存在
    public boolean getUser(String userName) {
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select userName from admin where userName=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
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
    //管理员表中添加
    public boolean insertAdmin(AdminInfo newAdmin) {
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "insert into Admin(tollCollectorNo,userName,passWord) values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newAdmin.getTollCollectorNo());
            pstmt.setString(2, newAdmin.getUserName());
            pstmt.setString(3, newAdmin.getPassWord());
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
}