package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.OptioninforsDao;

@WebServlet(urlPatterns = "/optionInforsDeleteServlet")
public class OptionInforsDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Delete를 하기위한 java문.
            // Delete를 할 method를 만들기.
            // 1) unique_id받는 method
            // 2) unique_id를 받을때 int로 return???????

            String unique_id = request.getParameter("unique_id");
            OptioninforsDao optionInforsDao = new OptioninforsDao();
           int count =  optionInforsDao.DeleteWithUniqueID(unique_id);
           
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            String contents = "Delete count: " + count;//mySQL의 Delete query실행문
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}