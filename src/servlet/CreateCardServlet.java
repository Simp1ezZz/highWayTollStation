package servlet;

import bean.CardInfo;
import bean.TollCollectorInfo;
import dao.CardDao;
import dao.TollCollectorDao;
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

@WebServlet("/CreateCardServlet")
public class CreateCardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        String carType = request.getParameter("carType");
        String numberPlate = request.getParameter("numberPlate");
        String balanceS = request.getParameter("rechargeAmount");
        float balance = Float.parseFloat(balanceS);
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");

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
        TollCollectorInfo tollCollectorInfo = new TollCollectorInfo();
        TollCollectorDao tollCollectorDao = new TollCollectorDao();
        tollCollectorDao.getTollCollector(tollCollectorNo,tollCollectorInfo);

        cardInfo.setUsedFee(0);
        cardInfo.setBalance(balance);
        cardInfo.setCardIssueTollBooshNo(tollCollectorInfo.getTollBoothNo());
        cardInfo.setCardIssueTollCollectorNo(tollCollectorNo);
        cardInfo.setCardNo(cardDao.getInsertCardNo());
        cardInfo.setCarType(carType);
        cardInfo.setNumberPlate(numberPlate);
        cardInfo.setName(name);
        cardInfo.setPhone(phone);
        cardInfo.setTime(time);
        if(cardDao.createCard(cardInfo)){
            jsonObject.put("msg","办理成功！");
            out.print(jsonObject.toString());
        }else {
            jsonObject.put("msg", "办理失败！");
            out.print(jsonObject.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
