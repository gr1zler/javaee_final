package servlet;

import DB.Dbconnection;
import DB.comment;
import DB.news;
import DB.users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/add-comment")
public class add_comment extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment=request.getParameter("comment");
        int news_id=Integer.parseInt(request.getParameter("news_id"));
        users user=(users)request.getSession().getAttribute("currentuser");
        request.setAttribute("user",user);
        if(user!=null){
            comment comments =new comment();
            comments.setComment(comment);
            news news =new news();
            news.setId(news_id);
            users users=new users();
            users.setId(user.getId());
            comments.setNews(news);
            comments.setUser(users);
            try {
                Dbconnection.add_comment(comments);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        response.sendRedirect("/");
    }
}
