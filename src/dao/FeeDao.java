package dao;

import bean.FeeRateInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
