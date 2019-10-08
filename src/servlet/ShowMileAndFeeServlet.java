package servlet;

import bean.*;
import dao.*;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ShowMileAndFeeServlet")
public class ShowMileAndFeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        String cardNo = request.getParameter("cardNo");
        String endTollBooshNo = request.getParameter("tollBooshNo");
        String endTime = request.getParameter("time");
        //行车卡信息获取
        CardInfo card = new CardInfo();
        CardDao cardDao = new CardDao();
        cardDao.getCardInfo(card,cardNo);
        //出入站信息获取
        TrafficInfo traffic = new TrafficInfo();
        TrafficDao trafficDao = new TrafficDao();
        trafficDao.setTraffic(card.getCardNo(),traffic);
        if(traffic.getStartTollBooshNo()==null)
            return;
        traffic.setEndTollBooshNo(endTollBooshNo);
        traffic.setEndTime(endTime);
        //路段信息获取
        RoadInfo road = new RoadInfo();
        RoadDao roadDao = new RoadDao();
        roadDao.setRoad(traffic.getStartTollBooshNo(),traffic.getEndTollBooshNo(),road);
        traffic.setMileage(road.getRoadMileage());
        //进站站名获取
        TollBooshInfo tollBooshInfo = new TollBooshInfo();
        TollBooshDao tollBooshDao = new TollBooshDao();
        tollBooshDao.setTollBoosh(traffic.getStartTollBooshNo(),tollBooshInfo);
        //进站车道名称获取
        LaneInfo laneInfo = new LaneInfo();
        LaneDao laneDao = new LaneDao();
        laneDao.setLane(traffic.getStartLaneNo(),laneInfo);
        //费率信息获取
        FeeRateInfo feeRateInfo = new FeeRateInfo();
        FeeDao feeDao = new FeeDao();
        feeDao.setFee(road.getRoadNo(),card.getCarType(),feeRateInfo);
        //通行费用计算
        float fee = (float)(Math.round(feeRateInfo.getFee()*traffic.getMileage()*100))/100;
        traffic.setTotalFee(fee);
        jsonObject.put("mile",traffic.getMileage());
        jsonObject.put("totalFee",traffic.getTotalFee());
        jsonObject.put("startTollBooshName",tollBooshInfo.getTollBooshName());
        jsonObject.put("startLaneName",laneInfo.getLaneName());
        out.print(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
