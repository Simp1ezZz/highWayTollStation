package dao;

import bean.TollBooshInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TollBooshDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    //通过站点编号获取收费站信息
    public boolean setTollBoosh(String tollBooshNo, TollBooshInfo tollBooshInfo){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from tollBooshInfo where tollBooshNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tollBooshNo);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                flag = true;
                tollBooshInfo.setTollBooshNo(rs.getString("tollBooshNo"));
                tollBooshInfo.setTollBooshName(rs.getString("tollBooshName"));
                tollBooshInfo.setNumbersOfLane(rs.getInt("numbersOfLane"));
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
