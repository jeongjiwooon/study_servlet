package com.example.study_servlet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// @WebFilter(urlPatterns = "/*")
public class SimpleFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException
    {
        try
        {
            System.out.println(request.getRemoteHost());
            System.out.println(request.getRemoteAddr());
            chain.doFilter(request, response);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
