package servlet;

import bean.CardInfo;
import bean.LaneInfo;
import bean.TollBooshInfo;
import dao.CardDao;
import dao.TollCollectorDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "inSiteServlet")
public class InSiteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tollCollectorNo = null;
        Cookie[] cookies = request.getCookies();
        Cookie cookie =null;
        for (int i=0;i<cookies.length;i++) {
            cookie = cookies[i];
            if("tollCollectorNo".equals(cookie.getName()))
                tollCollectorNo = cookie.getValue();
        }
        //获取收费员所属收费站名称以及车道名称
        LaneInfo lane = new LaneInfo();
        TollBooshInfo tollBoosh = new TollBooshInfo();
        TollCollectorDao collectorD = new TollCollectorDao();
        if(collectorD.getTollBooshAndLane(tollCollectorNo,lane,tollBoosh)){
            request.setAttribute("tollBooshName",tollBoosh.getTollBooshName());
            request.setAttribute("laneName",lane.getLaneName());
        }
        //获取IC卡信息
        String cardNo = request.getParameter("cardNo");
        System.out.println(cardNo);
        CardInfo card = new CardInfo();
        CardDao cardD = new CardDao();
        if(cardD.getCardInfo(card,cardNo)){
            request.setAttribute("carType",card.getCarType());
            request.setAttribute("numberPlate",card.getNumberPlate());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
