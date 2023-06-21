package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlet.commons.Common;
import com.example.study_servlet.daos.CarInforsDao;
import com.example.study_servlet.daos.FactorysDao;

@WebServlet(urlPatterns = "/connectDBServlet")
public class ConnectDBServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            // 클라이언트에 html 화면 제공!
            String contents = "<html lang=\"en\">\r\n" +
                    "<head>\r\n" +
                    "    <meta charset=\"UTF-8\">\r\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" +
                    "    <title>Document</title>\r\n" +
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" +
                    "</head>\r\n" +
                    "<body>\r\n" +
                    "    <div class=\"container\">\r\n" +
                    "        <table class=\"table table-bordered table-hover\">\r\n" +
                    "            <thead>\r\n" +
                    "                <tr>\r\n" +
                    "                    <th>CarName</th>\r\n" +
                    "                    <th>Year</th>\r\n" +
                    "                    <th>CarInforID</th>\r\n" +
                    "                    <th>CompanyID</th>\r\n" +
                    "                </tr>\r\n" +
                    "            </thead>\r\n";

            // FactorysDao factorysDao = new FactorysDao();
            // ArrayList factoryList = new ArrayList();
            // factoryList = factorysDao.selectAll();
            // for (int i = 0; i < factoryList.size(); i++)
            // {
            //     HashMap hashMap = new HashMap();
            //     hashMap = (HashMap) factoryList.get(i);
            //     contents = contents + "<tr>\r\n" +
            //             "<td>" + hashMap.get("company_id") + "</td>\r\n" +
            //             "<td>" + hashMap.get("COMPANY") + "</td>\r\n" +
            //             "</tr>\r\n";
            // }
            CarInforsDao carInforsDao = new CarInforsDao();
            ArrayList carInforList = new ArrayList();
            carInforList = carInforsDao.selectAll();
            for (int i = 0; i < carInforList.size(); i++)
            {
                HashMap hashMap = new HashMap();
                hashMap = (HashMap) carInforList.get(i);
                contents = contents + "<tr>\r\n" +
                        "<td>" + hashMap.get("car_name") + "</td>\r\n" +
                        "<td>" + hashMap.get("year") + "</td>\r\n" +
                        "<td>" + hashMap.get("car_infor_id") + "</td>\r\n" +
                        "<td>" + hashMap.get("company_id") + "</td>\r\n" +
                        "</tr>\r\n";
            }

            contents = contents + "<tbody>\r\n" +
                    "</tbody>\r\n" +
                    "</table>\r\n" +
                    "</div>\r\n" +
                    "</body>\r\n" +
                    "</html>";

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();

            // SELECT COUNT(*) AS CNT FROM factorys;
            // query = "SELECT COUNT(*) AS CNT FROM factorys ";

            // resultSet = statement.executeQuery(query);
            // int totalCount = 0;

            // while (resultSet.next())
            // {
            //     System.out.println(resultSet.getInt("CNT"));
            //     totalCount = resultSet.getInt("CNT");
            // }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}