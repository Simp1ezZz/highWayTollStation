package servlet;

import bean.LaneInfo;
import bean.TollBooshInfo;
import bean.TotalFee;
import bean.TrafficInfo;
import dao.LaneDao;
import dao.TollBooshDao;
import dao.TrafficVolumeDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/ShowTrafficVolumeServlet")
public class ShowTrafficVolumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String date = request.getParameter("date1");
        String tollBooshNo = request.getParameter("tollBooshNo1");
        String carType = request.getParameter("carType1");
        System.out.println(date+';'+tollBooshNo+';'+carType);
        TrafficVolumeDao trafficVolumeDao = new TrafficVolumeDao();
        TollBooshInfo tollBooshInfo = new TollBooshInfo();
        TollBooshDao tollBooshDao = new TollBooshDao();
        LaneInfo laneInfo = new LaneInfo();
        LaneDao laneDao = new LaneDao();
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        ArrayList<TrafficInfo> trafficInfoArrayList = new ArrayList<>();
        List<Map<String,Object>> mapList1= new ArrayList<>();
        Map<String,Object> tmap1= new HashMap<>();
        int total=0;
        total = trafficVolumeDao.getTrafficInfoInSelect(date,tollBooshNo,carType,trafficInfoArrayList);
        int totalVolume = 0;
        for(int i =0;i < trafficInfoArrayList.size();i++)
        {
            JSONObject traffic = new JSONObject();

            tollBooshDao.setTollBoosh(trafficInfoArrayList.get(i).getStartTollBooshNo(),tollBooshInfo);
            laneDao.setLane(trafficInfoArrayList.get(i).getStartLaneNo(),laneInfo);
            traffic.put("tollBooshNo1",trafficInfoArrayList.get(i).getStartTollBooshNo());
            traffic.put("tollBooshName1",tollBooshInfo.getTollBooshName());
            traffic.put("time1",trafficInfoArrayList.get(i).getStartTime());
            traffic.put("laneName1",laneInfo.getLaneName());
            traffic.put("cardNo1",trafficInfoArrayList.get(i).getCardNo());
            traffic.put("carType1",trafficInfoArrayList.get(i).getCarType());
            totalVolume+=1;
            array.put(traffic);
        };
        jsonObject.put("rows",array);
        tmap1.put("carType1",totalVolume);
        tmap1.put("cardNo1","总通行数量：");
        mapList1.add(tmap1);
        jsonObject.put("footer",mapList1);
        jsonObject.put("total",total);
        PrintWriter pw;
        try {
            pw = response.getWriter();
            pw.print(jsonObject.toString());
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
