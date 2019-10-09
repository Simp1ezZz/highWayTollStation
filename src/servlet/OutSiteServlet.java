package servlet;

import bean.*;
import dao.*;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/OutSiteServlet")
public class OutSiteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        String cardNo = request.getParameter("cardNo");
        String endTollBooshNo = request.getParameter("tollBooshNo");
        String endTime = request.getParameter("endTime");
        String laneNo = request.getParameter("laneNo");
        String tollCollectorNo = null;
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if ("tollCollectorNo".equals(cookie.getName()))
                tollCollectorNo = cookie.getValue();
        }
        //行车卡信息获取
        CardInfo card = new CardInfo();
        CardDao cardDao = new CardDao();
        cardDao.getCardInfo(card, cardNo);
        //出入站信息获取
        TrafficInfo traffic = new TrafficInfo();
        TrafficDao trafficDao = new TrafficDao();
        trafficDao.setTraffic(card.getCardNo(), traffic);
        traffic.setEndTollBooshNo(endTollBooshNo);
        traffic.setEndTime(endTime);
        traffic.setEndLaneNo(laneNo);
        //路段信息获取
        RoadInfo road = new RoadInfo();
        RoadDao roadDao = new RoadDao();
        roadDao.setRoad(traffic.getStartTollBooshNo(), traffic.getEndTollBooshNo(), road);
        traffic.setMileage(road.getRoadMileage());
        //费率信息获取
        FeeRateInfo feeRateInfo = new FeeRateInfo();
        FeeDao feeDao = new FeeDao();
        feeDao.setFee(road.getRoadNo(), card.getCarType(), feeRateInfo);
        //通行费用计算
        float fee = (float) (Math.round(feeRateInfo.getFee() * road.getRoadMileage() * 100)) / 100;
        traffic.setTotalFee(fee);
        //行车卡扣费
        if (card.getBalance() >= traffic.getTotalFee()) {
            card.setBalance(card.getBalance() - traffic.getTotalFee());
            card.setUsedFee(card.getUsedFee() + traffic.getTotalFee());
            cardDao.changeFee(card);
            //计入流水
            TotalFee totalFee = new TotalFee();
            totalFee.setCardNo(card.getCardNo());
            totalFee.setTime(traffic.getEndTime());
            totalFee.setCollectorNo(tollCollectorNo);
            totalFee.setCardNo(traffic.getCardNo());
            totalFee.setCarType(card.getCarType());
            totalFee.setTollBooshNo(traffic.getEndTollBooshNo());
            totalFee.setLaneNo(traffic.getEndLaneNo());
            totalFee.setFee(traffic.getTotalFee());
            if (!feeDao.accountEntry(totalFee)) {
                jsonObject.put("msg", "出站失败！");
                out.print(jsonObject.toString());
                return;
            }
        } else {
            jsonObject.put("msg", "余额不足！");
            out.print(jsonObject.toString());
            return;
        }
        //出站处理
        InOutSiteDao inOutSiteDao = new InOutSiteDao();
        if (inOutSiteDao.outSite(traffic)) {
            TrafficVolume trafficVolume = new TrafficVolume();
            TrafficVolumeDao trafficVolumeDao = new TrafficVolumeDao();
            trafficVolume.setTollBooshNo(traffic.getEndTollBooshNo());
            trafficVolume.setLaneNo(traffic.getEndLaneNo());
            trafficVolume.setCarType(card.getCarType());
            trafficVolumeDao.getTrafficVolume(trafficVolume);
            if (trafficVolumeDao.updataTrafficVoulme(trafficVolume)) {
                jsonObject.put("msg", "出站扣费成功！");
                out.print(jsonObject.toString());
            } else {
                jsonObject.put("msg", "出站失败！");
                out.print(jsonObject.toString());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
