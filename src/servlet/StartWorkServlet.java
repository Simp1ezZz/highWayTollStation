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

@WebServlet("/StartWorkServlet")
public class StartWorkServlet extends HttpServlet {
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
        WorkLogDao logD = new WorkLogDao();
        TollCollectorInfo tollCollector = new TollCollectorInfo();
        TollCollectorDao tollCollectorD = new TollCollectorDao();
        tollCollectorD.getTollCollector(tollCollectorNo,tollCollector);
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        WorkLog log = new WorkLog();
        log.setTollCollectorNo(tollCollector.getTollCollectorNo());
        log.setTollBooshNo(tollCollector.getTollBoothNo());
        log.setStartWorkTime(df.format(day));
        logD.startWork(log);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
