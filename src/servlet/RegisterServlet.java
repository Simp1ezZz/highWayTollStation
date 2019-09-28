package servlet;

import bean.AdminInfo;
import dao.adminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tollCollecterNo = Integer.parseInt(request.getParameter("tollCollecterNo"));
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord1");
        AdminInfo admin = new AdminInfo();
        adminDao adminD = new adminDao();
        String msg=null;
        if(adminD.getUser(userName))
        {
            msg = "用户名已存在，请直接登陆!";
        }else if(!adminD.getTollCollecterNo(tollCollecterNo))
        {
            msg = "工号错误，请检查后再试！";
        }else {
            admin.setTollCollecterNo(tollCollecterNo);
            admin.setUserName(userName);
            admin.setPassWord(passWord);
            if(adminD.insertAdmin(admin)) {
                msg = "创建成功！去登陆";
            }
        }
        if(msg!=null)
            request.setAttribute("msg",msg);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
