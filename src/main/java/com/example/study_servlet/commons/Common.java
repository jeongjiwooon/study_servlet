package com.example.study_servlet.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Common {
    // 1-1 ※ UUID 특정 키를 생성한다는 말.

    public Statement getStatement(){
        String url = "jdbc:mysql://192.168.0.42:3306/db_cars";
        String user = "yojulab";
        String password = "!yojulab*";

        Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
// DATE로 ID생성 . 
    public String getGeneratorID(){
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyyhh:mm:ss");  
        String strDate = formatter.format(date);
        return strDate;
    }

        public String generateUUID() {
         return UUID.randomUUID().toString();

    }
}