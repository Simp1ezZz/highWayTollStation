package dao;

import bean.LaneInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LaneDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    public boolean setLane(String laneNo, LaneInfo lane){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from LaneInfo where laneNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, laneNo);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                flag = true;
                lane.setLaneNo(rs.getString("laneNo"));
                lane.setLaneName(rs.getString("laneName"));
                lane.setPrincipal(rs.getString("principal"));
                lane.setTollBooshNo(rs.getString("tollBooshNo"));
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
