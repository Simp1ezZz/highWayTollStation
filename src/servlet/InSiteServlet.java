package servlet;

import com.mysql.cj.xdevapi.JsonArray;
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
        String inSiteTollBooshNo = request.getParameter("tollBooshNo");
        String inSiteTime = request.getParameter("inSiteTime");
        InOutSiteDao inOutSiteDao = new InOutSiteDao();
        JSONObject json = new JSONObject();
        if(inOutSiteDao.inSite(cardNo,inSiteTollBooshNo,inSiteTime)){
            json.put("msg","提交成功!");
            out.print(json.toString());
        }else{
            json.put("msg","提交失败!请勿重复提交!");
            out.print(json.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
