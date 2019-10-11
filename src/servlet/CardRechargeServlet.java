package servlet;

import bean.CardInfo;
import bean.RechargeLog;
import dao.CardDao;
import dao.RechargeLogDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CardRechargeServlet")
public class CardRechargeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        String cardNo = request.getParameter("cardNo");
        String rechargeAmountS = request.getParameter("rechargeAmount");
        float rechargeAmount = Float.parseFloat(rechargeAmountS);
        String tollCollectorNo=null;
        Cookie[] cookies = request.getCookies();
        Cookie cookie =null;
        for (int i=0;i<cookies.length;i++) {
            cookie = cookies[i];
            if("tollCollectorNo".equals(cookie.getName()))
                tollCollectorNo = cookie.getValue();
        }
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(day);

        CardInfo cardInfo = new CardInfo();
        CardDao cardDao = new CardDao();
        cardDao.getCardInfo(cardInfo,cardNo);
        float balance = cardInfo.getBalance();
        float nowBalance = balance+rechargeAmount;
        cardInfo.setBalance(nowBalance);
        RechargeLog rechargeLog = new RechargeLog();
        RechargeLogDao rechargeLogDao = new RechargeLogDao();
        rechargeLog.setCardNo(cardInfo.getCardNo());
        rechargeLog.setTime(time);
        rechargeLog.setTollCollectorNo(tollCollectorNo);
        rechargeLog.setRechargeAmount(rechargeAmount);
        boolean result = cardDao.recharge(cardInfo);
        if(result){
            if(rechargeLogDao.insertRechargeLog(rechargeLog)) {
                jsonObject.put("msg", "充值成功！");
                out.print(jsonObject.toString());
            }else {
                cardInfo.setBalance(nowBalance-rechargeAmount);
                cardDao.recharge(cardInfo);
                jsonObject.put("msg", "日志写入失败！充值金额已重置！");
                out.print(jsonObject.toString());
            }
        }else {
            jsonObject.put("msg","充值失败！");
            out.print(jsonObject.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
