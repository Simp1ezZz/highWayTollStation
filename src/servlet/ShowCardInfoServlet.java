package servlet;

import bean.CardInfo;
import dao.CardDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ShowCardInfoServlet")
public class ShowCardInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String cardNo = request.getParameter("cardNo");
        CardInfo cardInfo = new CardInfo();
        CardDao cardDao = new CardDao();
        cardDao.getCardInfo(cardInfo,cardNo);
        System.out.println(cardInfo.getBalance());
        String balance = Float.toString(cardInfo.getBalance());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("numberPlate",cardInfo.getNumberPlate());
        jsonObject.put("balance",balance);
        out.print(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
