package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(urlPatterns = "/ConnectDBServlet")
public class ConnectDBServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            

            // 클라이언트에 html 화면 제공
            String contents = " <!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>bootstrap_tables</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                    + //
                    "   \r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <th>COMPANY_ID</th>\r\n" + //
                    "                    <th>COMPANY</th>\r\n" + //
                    "                 \r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n";

            // - query Edit
            Common common =new Common();
            Statement statement = common.getStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println();
                contents = contents + " <tr>\r\n" + //
                        "                    <td>" + resultSet.getString("COMPANY_ID") + "</td>\r\n" + //
                        "                    <td>" + resultSet.getString("COMPANY") + "</td>\r\n" + //
                        "                 \r\n" + //
                        "                </tr>\r\n";
            }

            contents = contents + "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "\r\n" + //
                    "</html>";
            // 클라이언트에 html 화면 제공
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = resp.getWriter();

            printWriter.println(contents);
            printWriter.close();

            // SELECT COUNT(*) AS CNT FROM factorys;
            query = "SELECT COUNT(*) AS CNT FROM factorys ";
            resultSet = statement.executeQuery(query);
            int totalCount = 0;

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("CNT"));
                totalCount = resultSet.getInt("CNT");
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
