package com.example.study_servlet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// @WebFilter(urlPatterns = "/*")
public class SessionFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException
    {
        try
        {
            System.out.println(request.getRemoteHost());
            System.out.println(request.getRemoteAddr());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloWorldServlet"); // 클라이언트로부터 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는 역할
            requestDispatcher.forward(request, response);
            chain.doFilter(request, response);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
