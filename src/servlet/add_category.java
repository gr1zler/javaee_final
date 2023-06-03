package servlet;

import DB.Dbconnection;
import DB.users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DB.news_categories;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(value = "/add-category")
public class add_category extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        users user=(users)request.getSession().getAttribute("currentuser");
        request.setAttribute("user",user);
        if(user!=null&&user.getRole_id()==1) {
            ArrayList<news_categories> categories = Dbconnection.getnews_categories();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/Html/add-category.jsp").forward(request, response);
        }else if(user!=null){
            response.sendRedirect("/");
        }else{
            response.sendRedirect("/sign");
        }
    }
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        news_categories categories=new news_categories();
        categories.setName(name);

        try {
            Dbconnection.add_category(categories);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/");
    }
}
