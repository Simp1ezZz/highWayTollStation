package dao;

import bean.RechargeLog;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RechargeLogDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    public boolean insertRechargeLog(RechargeLog rechargeLog){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "insert into rechargeLog(time,cardNo,tollCollectorNo,rechargeAmount) values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rechargeLog.getTime());
            pstmt.setString(2, rechargeLog.getCardNo());
            pstmt.setString(3, rechargeLog.getTollCollectorNo());
            pstmt.setFloat(4, rechargeLog.getRechargeAmount());
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
