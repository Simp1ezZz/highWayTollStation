package servlet;

import bean.LaneInfo;
import bean.TollBooshInfo;
import bean.TollCollectorInfo;
import bean.TotalFee;
import dao.FeeDao;
import dao.LaneDao;
import dao.TollBooshDao;
import dao.TollCollectorDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/ShowAccountFlowServlet")
public class ShowAccountFlowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String date = request.getParameter("date2");
        String tollBooshNo = request.getParameter("tollBooshNo2");
        String tollCollectorNo = request.getParameter("tollCollectorNo2");
        String carType = request.getParameter("carType2");
//        System.out.println(date+';'+tollBooshNo+';'+tollCollectorNo+';'+carType);
        TollBooshInfo tollBooshInfo = new TollBooshInfo();
        TollBooshDao tollBooshDao = new TollBooshDao();
        LaneInfo laneInfo = new LaneInfo();
        LaneDao laneDao = new LaneDao();
        TollCollectorInfo tollCollectorInfo = new TollCollectorInfo();
        TollCollectorDao tollCollectorDao = new TollCollectorDao();
        FeeDao feeDao = new FeeDao();
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        ArrayList<TotalFee> totalFeeArrayList = new ArrayList<>();
        List<Map<String,Object>> mapList1= new ArrayList<>();
        Map<String,Object> tmap1= new HashMap<>();
        int total=0;
        total = feeDao.getTotalFeeInSelect(date,tollBooshNo,tollCollectorNo,carType,totalFeeArrayList);
        float totalFee = 0;
        for(int i =0;i < totalFeeArrayList.size();i++)
        {
            JSONObject fee = new JSONObject();

            tollBooshDao.setTollBoosh(totalFeeArrayList.get(i).getTollBooshNo(),tollBooshInfo);
            laneDao.setLane(totalFeeArrayList.get(i).getLaneNo(),laneInfo);
            tollCollectorDao.getTollCollector(totalFeeArrayList.get(i).getCollectorNo(),tollCollectorInfo);
//            float totalFeeF = totalFeeArrayList.get(i).getFee();
//            System.out.println(totalFeeF);
//            DecimalFormat   fnum  =   new  DecimalFormat("##0.00");
//            String   dd=fnum.format(totalFeeF);
            String feeS = Float.toString(totalFeeArrayList.get(i).getFee());
            fee.put("tollBooshName2",tollBooshInfo.getTollBooshName());
            fee.put("tollBooshNo2",totalFeeArrayList.get(i).getTollBooshNo());
            fee.put("laneName2",laneInfo.getLaneName());
            fee.put("tollCollectorName2",tollCollectorInfo.getName());
            fee.put("tollCollectorNo2",totalFeeArrayList.get(i).getCollectorNo());
            fee.put("time2",totalFeeArrayList.get(i).getTime());
            fee.put("cardNo2",totalFeeArrayList.get(i).getCardNo());
            fee.put("carType2",totalFeeArrayList.get(i).getCarType());
            fee.put("fee2",feeS);
            array.put(fee);
            totalFee+=totalFeeArrayList.get(i).getFee();
        };
        String totalFeeS= Float.toString(totalFee);
        jsonObject.put("rows",array);
        tmap1.put("fee2",totalFeeS);
        tmap1.put("carType2","总收费额度：");
        mapList1.add(tmap1);
        jsonObject.put("footer",mapList1);
        jsonObject.put("total",total);
        PrintWriter pw;
        try {
            pw = response.getWriter();
            pw.print(jsonObject.toString());
//            pw.print(array.toString());
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
