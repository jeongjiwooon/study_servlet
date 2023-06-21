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

@WebServlet(urlPatterns = "/CarInforsServlet")
public class CarInforsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // - MySQL workbench 실행 : JDBCs
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.40:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            Common commons = new Common();
            String statPK = commons.generateUUID();

            // - query Edit
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM  db_cars.car_infors;\n" + //
                    "";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("CAR_NAME") + "," + resultSet.getString("YEAR") + ","
                        + resultSet.getString("CAR_INFOR_ID") + "," + resultSet.getString("COMPANY_ID"));
            }
            // SELECT * FROM factorys;
            query = "insert into car_infors\n" + //
                    "(CAR_NAME,YEAR,CAR_INFOR_ID,COMPANY_ID)\n" + //
                    "values\n" + //
                    "('벤츠', '2001', '" + statPK + "', 'C004'); ";

            int count = statement.executeUpdate(query);
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM db_cars.car_infors");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("CAR_NAME") + "," + resultSet2.getString("YEAR") + ","
                        + resultSet2.getString("CAR_INFOR_ID") + "," + resultSet2.getString("COMPANY_ID"));
            }
            // INSERT INTO factorys
            // (COMPANY_ID , COMPANY)
            // VALUE
            // ('CAR-01' , 'AUDI');
            // String companyId = "CAR- 01"; //companyId 변수설정
            // String company = "AUDI"; //company 변수설정
            // query = "INSERT INTO factorys " + // 스페이스 찍어줌.
            // "(COMPANY_ID , COMPANY) " + //COMPANY_ID , COMPANY 를 위에 변수로 설정
            // " VALUE " +
            // "('"+companyId+"', '"+company+"') "; //쿼리안에 ' " +변수로 넣어준 상태에서 진행.

            // int count = statement.executeUpdate(query);
            System.out.println();

        } catch (Exception e) { // 에러발생시 캐치함.
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
