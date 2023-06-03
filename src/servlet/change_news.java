package servlet;

import DB.Dbconnection;
import DB.users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/change")
public class change_news extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        users user=(users)req.getSession().getAttribute("currentuser");
        req.setAttribute("user",user);
        if(user!=null&&user.getRole_id()==1) {
            int id = Integer.parseInt(req.getParameter("id"));
            String title =req.getParameter("title");
            String content=req.getParameter("content");
            System.out.println(title);
            System.out.println(content);
            try {
                Dbconnection.change_news(id,title,content);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        resp.sendRedirect("/");

    }

}
