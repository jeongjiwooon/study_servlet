package com.example.study_servlet.controlls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlet.commons.Common;

@WebServlet(urlPatterns = "/carInforsServlet")
public class CarInforsServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String url = "jdbc:mysql://192.168.0.40:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println("DB연결 성공\n");

            // - query Edit
            Statement statement = connection.createStatement();
            String query = "select * from car_infors";
            ResultSet resultSet = statement.executeQuery(query);
            Common common = new Common();
            String uuid = common.generateUUID();
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("car_name") + resultSet.getString("year") + resultSet.getString("car_infor_id") + resultSet.getString("company_id"));
            }
            //SELECT COUNT(*) AS CNT FROM factorys;
            query = "insert into car_infors\n" + //
                    "(car_name, year, " + "car_infor_id" + ", company_id)\n" + //
                    "values ('jeongjiwoon', '1998', '" + uuid + "', 'C001');";

            int count = statement.executeUpdate(query);

            query = "select * from car_infors";

            resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {
                System.out.println(resultSet.getString("car_name") + resultSet.getString("year") + resultSet.getString("car_infor_id") + resultSet.getString("company_id"));
            }
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
