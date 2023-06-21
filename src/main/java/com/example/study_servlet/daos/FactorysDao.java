package com.example.study_servlet.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlet.commons.Common;

public class FactorysDao
{
    public ArrayList selectAll()
    {
        ArrayList arrayList = new ArrayList();
        try
        {
        Common commons = new Common();
        Statement statement = commons.getStatement();
        String query = "SELECT * FROM factorys";
        ResultSet resultSet = statement.executeQuery(query);
        HashMap hashMap = new HashMap();
        while (resultSet.next())
        {
            hashMap = new HashMap<>();
            hashMap.put("company_id", resultSet.getString("COMPANY_ID"));
            hashMap.put("COMPANY", resultSet.getString("COMPANY"));
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