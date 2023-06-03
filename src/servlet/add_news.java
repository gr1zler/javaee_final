package servlet;

import DB.Dbconnection;
import DB.news;
import DB.news_categories;
import DB.users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/add-news")
public class add_news extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        users user=(users)request.getSession().getAttribute("currentuser");
        request.setAttribute("user",user);
        if(user!=null&&user.getRole_id()==1) {
        ArrayList<news_categories> categories= Dbconnection.getnews_categories();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/Html/add-news.jsp").forward(request,response);
        }else if(user!=null){
            response.sendRedirect("/");
        }else{
            response.sendRedirect("/sign");
        }
    }
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String category_id=request.getParameter("category");
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        news news =new news();
        news.setContent(content);
        news.setTitle(title);
        news_categories categories =new news_categories();
        categories.setId(Integer.parseInt(category_id));
        news.setCategory(categories);
        try {
            Dbconnection.add_news(news);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/");
    }
}
