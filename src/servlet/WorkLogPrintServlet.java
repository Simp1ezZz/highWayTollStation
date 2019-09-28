package servlet;

import bean.WorkLog;
import dao.WorkLogDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/WorkLogPrintServlet")
public class WorkLogPrintServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tollCollectorNo = null;
        Cookie [] cookies = request.getCookies();
        Cookie cookie =null;
        System.out.println("a");
        for (int i=0;i<cookies.length;i++) {
            cookie = cookies[i];
            if("tollCollectorNo".equals(cookie.getName()))
                tollCollectorNo = cookie.getValue();
            /*System.out.println(tollCollectorNo);
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
            System.out.println(i);*/
        }
        /*System.out.println(tollCollectorNo);*/
        JSONArray array = new JSONArray();
        JSONObject log = new JSONObject();
        WorkLogDao logD = new WorkLogDao();
        ArrayList<WorkLog> logs;
        try {
            if (tollCollectorNo!=null) {
                logs = logD.listAll(tollCollectorNo);
                for(int i =0;i<logs.size();i++)
                {
                    log.put("tollCollectorNo",logs.get(i).getTollCollectorNo());
                    log.put("tollBooshNo",logs.get(i).getTollBooshNo());
                    log.put("startWorkTime",logs.get(i).getStartWorkTime());
                    log.put("finishWorkTime",logs.get(i).getFinishWorkTime());
                    array.put(log);
                }
            }else{
                //tollCollecterNo==null则数据库中没有工作信息，什么都不显示
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter pw;
        try {
            pw = response.getWriter();
            pw.print(array.toString());
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
