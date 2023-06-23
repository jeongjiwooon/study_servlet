package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Cookies/GetAndDeleteServlet")
public class CookiesGetAndDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //coolies에 대한것. 
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie :cookies){ // 특정이름 뽑아내기. 
                String name = cookie.getName(); //name 도 string 값 
                String value = cookie.getValue(); // value 는 string 값 

            }

            // display에 대한 것.
            PrintWriter printWriter = response.getWriter();
            String content = "<div>CookiesGetAndDeleteServlet</div>";
            printWriter.println(content);
            printWriter.close();
       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
