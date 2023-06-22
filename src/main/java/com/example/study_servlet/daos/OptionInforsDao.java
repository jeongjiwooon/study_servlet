package com.example.study_servlet.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlet.commons.Common;

public class OptionInforsDao {
    public ArrayList SelectWithSearch(String search) {
    ArrayList optionInforList = new ArrayList<>(); 
        try {
            Common commons = new Common();
            Statement statement = commons.getStatement(); // Editor in Workbench
            String query = "SELECT *\n" + //
                    "FROM option_infors; ";
            ResultSet resultSet = statement.executeQuery(query);
           
            HashMap optionInforRecord = new HashMap <>(); 
            while (resultSet.next()) {
                optionInforRecord = new HashMap <>(); 
                optionInforRecord.put("OPTION_INFOR_ID",resultSet.getString ("OPTION_INFOR_ID"));
                optionInforRecord.put("OPTION_NAME",resultSet.getString ("OPTION_NAME"));
                optionInforList.add(optionInforRecord); 

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optionInforList;
    }

}
