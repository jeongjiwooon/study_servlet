package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/CreateServlet")
public class CookiesCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //coolies에 대한것. 
            Cookie cookie_first = new Cookie("firstName", "yoju!");
            Cookie cookie_second = new Cookie("secondName", "Lab!");

            response.addCookie(cookie_first);
            response.addCookie(cookie_second); // 클라이언트에게 보낼 쿠키 정보 같이 실어서보냄

            // display에 대한 것.
            PrintWriter printWriter = response.getWriter();
            String content = "<div>CreateCookieServlets</div>";
            printWriter.println(content);
            printWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
