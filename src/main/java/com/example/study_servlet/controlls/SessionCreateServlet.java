package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// /session/CreateServlet?username=yojulab&password=1234
@WebServlet(urlPatterns = "/session/CreateServlet")
public class SessionCreateServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            // get params from query
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // display
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<div>Create Session Servlets</div>");
            // login 
            HttpSession httpSession = request.getSession(false);
            String usernameSession = (String) httpSession.getAttribute("username");
            if (httpSession != null && usernameSession != null) // JSESSION 있음. - 로그인 되었다는 표시
            {
                printWriter.println("<div>username: " + usernameSession + "</div>");
                // String passwordSession = (String) httpSession.getAttribute("password");
                // printWriter.println("<div>password: " + passwordSession + "</div>");
            }
            
            else // 없음
            {

                if("yojulab".equals(username) && "1234".equals(password))
                {
                    httpSession = request.getSession();
                    httpSession.setAttribute("username", username);
                    httpSession.setAttribute("password", password);
                    printWriter.println("<div>" + username + ", " + password + "</div>");
                }
                
                else
                {
                    printWriter.println("<div>Faild</div>");
                }
            }
            printWriter.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
