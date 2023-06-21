package com.example.study_servlet.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlet.commons.Common;

public class CarInforsDao
{
    public ArrayList selectAll()
    {
        ArrayList arrayList = new ArrayList();
        try
        {
        Common commons = new Common();
        Statement statement = commons.getStatement();
        String query = "SELECT * FROM car_infors";
        ResultSet resultSet = statement.executeQuery(query);
        HashMap hashMap = new HashMap();
        while (resultSet.next())
        {
            hashMap = new HashMap<>();
            hashMap.put("car_name", resultSet.getString("car_name"));
            hashMap.put("year", resultSet.getString("year"));
            hashMap.put("car_infor_id", resultSet.getString("car_infor_id"));
            hashMap.put("company_id", resultSet.getString("company_id"));
            arrayList.add(hashMap);
        }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}
