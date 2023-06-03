package servlet;


import DB.Dbconnection;
import DB.users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/sign")
public class Sign_in extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        users user=(users)request.getSession().getAttribute("currentuser");
        request.setAttribute("user",user);
        if(user==null) {
            request.getRequestDispatcher("/Html/login.jsp").forward(request, response);
        }else{
            response.sendRedirect("/log");
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        users user= null;
        try {
            user = Dbconnection.check_user(email,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(user.getEmail()!=null){
            HttpSession session=request.getSession();
            session.setAttribute("currentuser",user);
            response.sendRedirect("/");
        }else {
            response.sendRedirect("/sign?error");
        }
    }


}