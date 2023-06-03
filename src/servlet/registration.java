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

@WebServlet(value = "/registr")

public class registration extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        users user=(users)request.getSession().getAttribute("currentuser");
        request.setAttribute("user",user);
        if(user==null) {
            request.getRequestDispatcher("/Html/registration.jsp").forward(request, response);
        }else{
            response.sendRedirect("/log");
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(name.length()>0&&password.length()>0&&email.length()>0){
            users user =new users();
            user.setFull_name(name);
            user.setPassword(password);
            user.setEmail(email);
            System.out.println(name);
            System.out.println(email);
            System.out.println(password);

            try {
                Dbconnection.add_user(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("/sign");
        }else {
            response.sendRedirect("/registr?error");
        }
    }


}