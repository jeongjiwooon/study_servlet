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

@WebServlet(urlPatterns = "/connectDBServlet")
public class ConnectDBServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String url = "jdbc:mysql://192.168.0.42:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println("DB연결 성공\n");

            // - query Edit
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("COMPANY_ID") + resultSet.getString("COMPANY"));
            }
            //SELECT COUNT(*) AS CNT FROM factorys;
            query = "SELECT COUNT(*) AS CNT FROM factorys ";

            resultSet = statement.executeQuery(query);
            int totalCount = 0 ; 

            while (resultSet.next())
            {
                System.out.println( resultSet.getInt("CNT"));
                totalCount = resultSet.getInt("CNT");
            }
            // INSERT INTO factorys 
            // (COMPANY_ID , COMPANY)
            // VALUE
            // ('CAR-01' , 'AUDI'); 
            String companyId = "CAR-01"; 
            String company = "AUDI";
            query = "INSERT INTO factorys " + 
                    "(COMPANY_ID , COMPANY) " + 
                    " VALUE " + 
                    "('" + companyId + "', '" + company + "')"; 
            int count =  statement.executeUpdate(query);
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}