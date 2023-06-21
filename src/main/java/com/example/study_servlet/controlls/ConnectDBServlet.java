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
// import com.example.study_servlet.daos.FactorysDao;
import com.example.study_servlet.daos.CarInforsDao;

@WebServlet(urlPatterns = "/ConnectDBServlet")
public class ConnectDBServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 클라이언트에 html 화면 제공
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = resp.getWriter();

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
            // FactorysDao factorysDao = new FactorysDao();
            CarInforsDao carinforDao = new CarInforsDao();


            // ArrayList<HashMap<String, String>> factoryList = factorysDao.selectAll();
            ArrayList<HashMap<String, String>>  CarInforList =  carinforDao.selectAll();
            for (int i = 0; i < CarInforList.size(); i = i + 1) {
                HashMap<String, String> hashMap = CarInforList.get(i);
                contents += " <tr>\r\n" + //
                        "                    <td>" + hashMap.get("COMPANY_ID") + "</td>\r\n" + //
                        "                    <td>" + hashMap.get("COMPANY") + "</td>\r\n" + //
                        "                 \r\n" + //
                        "                </tr>\r\n";
            }

            contents += "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "\r\n" + //
                    "</html>";

            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}