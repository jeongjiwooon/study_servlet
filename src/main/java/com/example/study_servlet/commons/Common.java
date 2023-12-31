package com.example.study_servlet.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Common {
    public String Common() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public Statement getStatement() {
        String url = "jdbc:mysql://192.168.0.40:3306/db_survey";
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

    public String getGeneratorID() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyyhh:mm:ss");
        String strDate = formatter.format(date);
        return strDate;
    }

    public String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}