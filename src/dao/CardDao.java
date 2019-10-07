package dao;

import bean.CardInfo;
import utils.DatabaseConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CardDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private DatabaseConn dbConn;

    //通过卡号获取行车卡信息
    public boolean getCardInfo(CardInfo card, String cardNo){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select * from cardInfo where cardNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cardNo);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                flag = true;
                card.setCardNo(rs.getString("cardNo"));
                card.setNumberPlate(rs.getString("numberPlate"));
                card.setCardType(rs.getString("cardType"));
                card.setCarType(rs.getString("carType"));
                card.setDrivingRecordNo(rs.getString("drivingRecordNo"));
                card.setBalance(rs.getFloat("balance"));
                card.setUsedFee(rs.getFloat("usedFee"));
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
