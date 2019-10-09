package servlet;

import bean.TollCollectorInfo;
import bean.WorkLog;
import dao.TollCollectorDao;
import dao.WorkLogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/FinishWorkServlet")
public class FinishWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前登陆的收费员
        String tollCollectorNo = null;
        Cookie[] cookies = request.getCookies();
        Cookie cookie =null;
        for (int i=0;i<cookies.length;i++) {
            cookie = cookies[i];
            if("tollCollectorNo".equals(cookie.getName()))
                tollCollectorNo = cookie.getValue();
        }
        //获取ajax传来的startWorkTime
        String startWorkTime=request.getParameter("startWorkTime");
        TollCollectorInfo tollCollector = new TollCollectorInfo();
        TollCollectorDao tollCollectorD = new TollCollectorDao();
        tollCollectorD.getTollCollector(tollCollectorNo,tollCollector);
        //当前系统时间
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        WorkLog log = new WorkLog();
        log.setTollCollectorNo(tollCollector.getTollCollectorNo());
        log.setTollBooshNo(tollCollector.getTollBoothNo());
        log.setStartWorkTime(startWorkTime);
        log.setFinishWorkTime(df.format(day));
        WorkLogDao logD = new WorkLogDao();
        logD.finishWork(log);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
