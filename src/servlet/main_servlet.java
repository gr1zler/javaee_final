package servlet;

import DB.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(value = "/Home.html")
public class main_servlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ArrayList<news>news= Dbconnection.getnew();
        request.setAttribute("news",news);
        Map<Long,ArrayList<comment>>comments= Dbconnection.get_news_with_comment();
        request.setAttribute("comments",comments);
        ArrayList<news_categories>categories= Dbconnection.getnews_categories();
        request.setAttribute("categories",categories);
        users user=(users)request.getSession().getAttribute("currentuser");
        request.setAttribute("user",user);
        request.getRequestDispatcher("/Html/Main.jsp").forward(request,response);
    }
}
