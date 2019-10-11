package servlet;

import dao.FeeRateDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ChangeFeeRateServlet")
public class ChangeFeeRateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        String roadNo = request.getParameter("roadNo");
        String feeS = request.getParameter("feeRate");
        float fee = Float.parseFloat(feeS);
        FeeRateDao feeRateDao = new FeeRateDao();
        if(feeRateDao.changeFeeRate(roadNo,fee)){
            jsonObject.put("msg","修改成功！");
            out.print(jsonObject.toString());
        }else {
            jsonObject.put("msg","修改失败");
            out.print(jsonObject.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
