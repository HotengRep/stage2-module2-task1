package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("lastName");

        User user = new User(firstName,secondName);

        Warehouse.getInstance().addUser(user);

        request.setAttribute("user",user);

        redirectAdd(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        redirectAdd(request,response);
    }


    private void redirectAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/add.jsp");
        dispatcher.forward(request,response);
    }
}
