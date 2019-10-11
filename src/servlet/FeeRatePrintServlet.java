package servlet;

import bean.FeeRateInfo;
import bean.RoadInfo;
import com.mysql.cj.xdevapi.JsonArray;
import dao.FeeRateDao;
import dao.RoadDao;
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

@WebServlet("/FeeRatePrintServlet")
public class FeeRatePrintServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONArray jsonArray = new JSONArray();
        ArrayList<FeeRateInfo> arrayList = new ArrayList();
        String roadNo = request.getParameter("roadNo");
        FeeRateDao feeRateDao = new FeeRateDao();
        feeRateDao.getFeeRate(roadNo,arrayList);
        for(int i =0;i<arrayList.size();i++)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("roadNo_feeRate",arrayList.get(i).getRoadNo());
            jsonObject.put("carType_feeRate",arrayList.get(i).getCarType());
            jsonObject.put("feeRate_feeRate",Float.toString(arrayList.get(i).getFee()));
            jsonArray.put(jsonObject);
        }
        out.print(jsonArray.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
