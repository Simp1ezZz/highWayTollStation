package dao;

import bean.TrafficInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InOutSiteDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    //车辆入站
    public boolean inSite(String cardNo,String inSiteTollBooshNo,String inSiteTime){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try{
            conn = dbConn.getConnection();
            String sql = "insert into trafficInfo(cardNo,inSiteTollBooshNo,inSiteTime) values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cardNo);
            pstmt.setString(2, inSiteTollBooshNo);
            pstmt.setString(3, inSiteTime);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                flag = true;
            }
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

    //车辆出站
}
