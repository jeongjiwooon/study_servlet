package com.example.study_servlet.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlet.commons.Common;

public class CarInforsDao {
    
     public ArrayList<HashMap<String, String>> selectAll() {
        ArrayList<HashMap<String, String>> resultList = new ArrayList<>();
        try {
            Common common = new Common();
            Statement statement = common.getStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query);

            HashMap<String, String> hashMap;

            while (resultSet.next()) {
                hashMap = new HashMap<>();
                hashMap.put("COMPANY_ID", resultSet.getString("COMPANY_ID"));
                hashMap.put("COMPANY", resultSet.getString("COMPANY"));
                resultList.add(hashMap);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return resultList;
    }
}

