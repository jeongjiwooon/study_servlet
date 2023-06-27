package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlet.commons.Common;
import com.example.study_servlet.daos.OptionInforsDao;

@WebServlet (urlPatterns = "/optionInforsJSPServlet")
public class OptionInforsJSPServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String search = request.getParameter("search");
           
            OptionInforsDao optionInforsDao = new OptionInforsDao();
            ArrayList optionInforList = new ArrayList<>();
            optionInforList = optionInforsDao.SelectWithSearch(search);
            
            request.setAttribute("search" , search);
            request.setAttribute("optionInforList" , optionInforList);

            response.setContentType("text/html;charset=UTF 8");     
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cars/option_infors.jsp");
            requestDispatcher.forward(request, response);

            for (int i = 0; i < optionInforList.size(); i++)
            {
                HashMap optionInforRecord = new HashMap<>();
                optionInforRecord = (HashMap) optionInforList.get(i);
                // contents = contents + "                    <tr>\r\n" + //
                //         "                        <td>" + optionInforRecord.get("option_infor_id") + "</td>\r\n" + //
                //         "                        <td>" + optionInforRecord.get("option_name") + "</td>\r\n" + //
                //         "                    </tr>\r\n";
            }
           
            response.setContentType("text/html;charset=UTF-8");
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}