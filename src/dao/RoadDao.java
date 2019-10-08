package dao;

import bean.RoadInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoadDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    //通过起始站点和终止站点获取路段信息
    public boolean setRoad(String startSiteNo, String endSiteNo, RoadInfo road){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from roadInfo where startTollBooshNo=? and endTollBooshNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, startSiteNo);
            pstmt.setString(2, endSiteNo);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                flag = true;
                road.setStartTollBooshNo(rs.getString("startTollBooshNo"));
                road.setEndTollBooshNo(rs.getString("endTollBooshNo"));
                road.setRoadMileage(rs.getFloat("roadMileage"));
                road.setRoadNo(rs.getString("roadNo"));
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
