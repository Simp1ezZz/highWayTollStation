package servlet;

import bean.CardInfo;
import bean.LaneInfo;
import bean.TollBooshInfo;
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

@WebServlet("/ShowSiteInfoServlet")
public class ShowSiteInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String tollCollectorNo = null;
        Cookie[] cookies = request.getCookies();
        Cookie cookie =null;
        for (int i=0;i<cookies.length;i++) {
            cookie = cookies[i];
            if("tollCollectorNo".equals(cookie.getName()))
                tollCollectorNo = cookie.getValue();
        }
        //获取IC卡信息
        String cardNo = request.getParameter("cardNo");
        if(cardNo!=null){
            CardInfo card = new CardInfo();
            CardDao cardD = new CardDao();
            cardD.getCardInfo(card,cardNo);
            if(card!=null) {
                JSONObject JsonData = new JSONObject();
                JsonData.put("carType", card.getCarType());
                JsonData.put("numberPlate", card.getNumberPlate());
                out.print(JsonData.toString());
                return;
            }
        }
        //获取收费员所属收费站名称以及车道名称
        LaneInfo lane = new LaneInfo();
        TollBooshInfo tollBoosh = new TollBooshInfo();
        TollCollectorDao collectorD = new TollCollectorDao();
        collectorD.getTollBooshAndLane(tollCollectorNo,lane,tollBoosh);
        if(lane!=null&&tollBoosh!=null) {
            JSONObject JsonInfo = new JSONObject();
            JsonInfo.put("laneName", lane.getLaneName());
            JsonInfo.put("tollBooshName", tollBoosh.getTollBooshName());
            JsonInfo.put("tollBooshNo",tollBoosh.getTollBooshNo());
            JsonInfo.put("laneNo",lane.getLaneNo());
            out.print(JsonInfo.toString());
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
