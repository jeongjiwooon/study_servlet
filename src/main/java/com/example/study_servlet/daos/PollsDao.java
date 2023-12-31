package com.example.study_servlet.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlet.commons.Common;

public class PollsDao
{
    public ArrayList SelectWithSearch(String search)
    {
        ArrayList InforList = new ArrayList<>();
        try
        {
            Common common = new Common();
            Statement statement = common.getStatement(); // Editor in Workbanch
            String query = "SELECT T_QC.questions_id, T_QC.choice_id, T_Q.questions, T_C.choice\n" + //
                    "FROM question_choice as T_QC\n" + //
                    "inner join questions as T_Q\n" + //
                    "on T_QC.questions_id = T_Q.questions_id\n" + //
                    "inner join choice as T_C\n" + //
                    "on T_QC.choice_id = T_C.choice_id\n" + //
                    "order by T_QC.questions_id, T_QC.choice_id;";
            ResultSet resultSet = statement.executeQuery(query);

            HashMap InforRecord = new HashMap<>();
            while (resultSet.next())
            {
                InforRecord = new HashMap<>();
                InforRecord.put("questions_id", resultSet.getString("questions_id"));
                InforRecord.put("choice_id", resultSet.getString("choice_id"));
                InforRecord.put("questions", resultSet.getString("questions"));
                InforRecord.put("choice", resultSet.getString("choice"));

                InforList.add(InforRecord);
            }
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return InforList;
    }

    public int Insert(HashMap<String, Object> map){
        int count = 0;
        try {
            Common common = new Common();
            Statement statement = common.getStatement(); // Editor in Workbanch
            String query = "insert into statistics\n" + //
                    "(statistics_id, respondents_id, questions_id, choice_id)\n" + //
                    "values\n";

                int loops = 1;
                String userId = "R1";
                for (String key : map.keySet())
                {
                    String uuid = common.generateUUID();
                    if (loops > 1)
                    {
                        query = query + ", ";
                    }
                    query = query + "('" + uuid + "', '" +userId + "', '" + key + "', '" + map.get(key) + "')\n";
                    // System.out.println(key + " " + map.get(key));
                    loops = loops + 1;
                }
            query = query + ";";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
