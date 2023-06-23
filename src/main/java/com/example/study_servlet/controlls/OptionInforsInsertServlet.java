package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.example.study_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsInsertServlet")
public class OptionInforsInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Insert를 하기위한 java문.
            // Insert를 할 method를 만들기.
            // 1) OPTION_NAME을 받는 method
            // 2) OPTION_NAME을 받을 때 int로 return???????

            String option_infor_id = request.getParameter("optionName");
            OptionInforsDao optionInforsDao = new OptionInforsDao();
            int count = optionInforsDao.Insert(option_infor_id);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            String contents = "Insert count: " + count; // mySQL의 Insert query 실행문
           
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}