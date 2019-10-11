package dao;

import bean.FeeRateInfo;
import bean.WorkLog;
import net.sf.json.JSONObject;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FeeRateDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    //获取费率信息打包成ArrayList
    public void getFeeRate(String roadNo,ArrayList<FeeRateInfo> arrayList){
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            if (roadNo == null) {
                String sql = "select * from feeRateInfo";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
            } else {
                String sql = "select * from feeRateInfo where roadNo = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, roadNo);
                rs = pstmt.executeQuery();
            }
            while (rs.next()) {
                FeeRateInfo feeRateInfo = new FeeRateInfo();
                JSONObject jsonObject = new JSONObject();
                feeRateInfo.setRoadNo(rs.getString("roadNo"));
                feeRateInfo.setCarType(rs.getString("roadNo"));
                feeRateInfo.setFee(rs.getFloat("fee"));
                arrayList.add(feeRateInfo);
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
    }

    //修改费率
    public boolean changeFeeRate(String roadNo,float fee){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "UPDATE feeRateInfo SET fee=? where roadNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setFloat(1,fee);
            pstmt.setString(2,roadNo);
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
