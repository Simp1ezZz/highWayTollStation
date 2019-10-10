package servlet;

import bean.CardInfo;
import bean.TrafficInfo;
import com.mysql.cj.xdevapi.JsonArray;
import dao.CardDao;
import dao.InOutSiteDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InSiteServlet")
public class InSiteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String cardNo = request.getParameter("cardNo");
        String startTollBooshNo = request.getParameter("tollBooshNo");
        String startTime = request.getParameter("startTime");
        String startLaneNo = request.getParameter("laneNo");
        InOutSiteDao inOutSiteDao = new InOutSiteDao();
        JSONObject json = new JSONObject();
        TrafficInfo traffic = new TrafficInfo();
        CardInfo cardInfo = new CardInfo();
        CardDao cardDao = new CardDao();
        cardDao.getCardInfo(cardInfo,cardNo);
        traffic.setCardNo(cardNo);
        traffic.setStartTollBooshNo(startTollBooshNo);
        traffic.setStartLaneNo(startLaneNo);
        traffic.setStartTime(startTime);
        traffic.setCarType(cardInfo.getCarType());
        if(inOutSiteDao.inSite(traffic)){
            json.put("msg","提交成功!");
            out.print(json.toString());
        }else{
            json.put("msg","请勿重复提交！  请检查IC卡号是否正确！");
            out.print(json.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
