package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlet")
public class HelloWorldJSPServlet extends HttpServlet
{
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 
      
        try
        {
            String contents = "jeongjiwoon !";

            request.setAttribute("contents", contents);
            // 다음 파일 호출! 
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloworldJSP.jsp");
            requestDispatcher.forward(request, response);

           
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}