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
                card.setCarType(rs.getString("carType"));
                card.setCardIssueTollBooshNo(rs.getString("cardIssueTollBooshNo"));
                card.setCardIssueTollCollectorNo(rs.getString("cardIssueTollCollectorNo"));
                card.setBalance(rs.getFloat("balance"));
                card.setUsedFee(rs.getFloat("usedFee"));
                card.setPhone(rs.getString("phone"));
                card.setName(rs.getString("name"));
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

    //更新行车卡费用信息
    public boolean changeFee(CardInfo cardInfo){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "UPDATE cardInfo SET balance=?,usedFee=?where cardNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setFloat(1, cardInfo.getBalance());
            pstmt.setFloat(2, cardInfo.getUsedFee());
            pstmt.setString(3, cardInfo.getCardNo());
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

    //行车卡充值
    public boolean recharge(CardInfo cardInfo){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "UPDATE cardInfo SET balance=? where cardNo=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setFloat(1, cardInfo.getBalance());
            pstmt.setString(2, cardInfo.getCardNo());
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

    //新建行车卡
    public boolean createCard(CardInfo cardInfo){
        boolean flag = false;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "insert into cardInfo(cardNo,carType,numberPlate,cardIssueTollBooshNo,cardIssueTollCollectorNo,phone,name,balance,usedFee,time) values(?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cardInfo.getCardNo());
            pstmt.setString(2, cardInfo.getCarType());
            pstmt.setString(3, cardInfo.getNumberPlate());
            pstmt.setString(4, cardInfo.getCardIssueTollBooshNo());
            pstmt.setString(5, cardInfo.getCardIssueTollCollectorNo());
            pstmt.setString(6, cardInfo.getPhone());
            pstmt.setString(7, cardInfo.getName());
            pstmt.setFloat(8, cardInfo.getBalance());
            pstmt.setFloat(9,cardInfo.getUsedFee());
            pstmt.setString(10,cardInfo.getTime());
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

    //获取新建的卡号
    public String getInsertCardNo(){
        String cardNo = null;
        dbConn = new DatabaseConn();
        try {
            conn = dbConn.getConnection();
            String sql = "select cardNo from cardinfo where uid=(select MAX(uid) from cardinfo)";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                cardNo = rs.getString("cardNo");
                int cardNo_Int = Integer.parseInt(cardNo);
                cardNo_Int = cardNo_Int+1;
                cardNo = Integer.toString(cardNo_Int);
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

        return cardNo;
    }
}
