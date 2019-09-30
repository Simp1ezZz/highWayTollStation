package servlet;

import bean.AdminInfo;
import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        AdminDao adminD = new AdminDao();
        AdminInfo admin = adminD.userLogin(userName,passWord);
        if(admin!=null)
        {
            Cookie cookie = new Cookie("tollCollectorNo",admin.getTollCollectorNo());
            response.addCookie(cookie);
            request.getSession().setAttribute("user",admin.getUserName());
            response.sendRedirect("index.jsp");
        }else
        {
            request.setAttribute("msg","账号或密码错误，请重新输入！");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}