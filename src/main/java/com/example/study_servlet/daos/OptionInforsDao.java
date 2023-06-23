package com.example.study_servlet.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.example.study_servlet.commons.Common;

public class OptionInforsDao {
    // INSERT 메소드 만들기
    public int OptionInforsInsertServlet(String name) {
        int count = 0;
        try {
            Common commons = new Common();
            String uuid = commons.generateUUID();
            Statement statement = commons.getStatement();
            String query = "INSERT INTO option_infors\n" + //
                    "(OPTION_INFOR_ID, OPTION_NAME)\n" + //
                    "VALUES\n" + //
                    "('" + uuid + "', '" + name + "');";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    // UPDATE 메소드 만들기
    public int OptionInforsUpdateServlet(String name) {
        int count = 0;
        try {
            Common commons = new Common();
            Statement statement = commons.getStatement();
            String query = "UPDATE option_infors\n" + //
                    "SET OPTION_NAME = '" + name + "'" + //
                    "WHERE OPTION_INFOR_ID = 'OI001';";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    // DELETE 메소드 만들기
    public int DeleteWithUniqueID(String unique_id) {
        int count = 0;
        try {
            Common commons = new Common(); // commons 클래스를 인스턴스화
            Statement statement = commons.getStatement();
            String query = "DELETE FROM option_infors\n" + //
                    "WHERE OPTION_INFOR_ID = '" + unique_id + "';";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public ArrayList SelectWithSearch(String search) {
        ArrayList optionInforList = new ArrayList<>();
        try {
            if (search == null) {
                search = "";
            }
            Common commons = new Common(); // commons 클래스를 인스턴스화
            Statement statement = commons.getStatement(); // Editor in workbanch , statement에 getStatement를 담아줌
            String query = "SELECT *\n" + //
                    "FROM option_infors\n" + //
                    "WHERE OPTION_NAME like '"+search+"%';";
            statement.executeQuery(query);  // editor창에서 query문 실행
            ResultSet resultSet = statement.executeQuery(query);// 실행시키면 resultSet으로 떨어짐. 그걸 resultSet에 받음 // 결과값이 resultset으로 떨어짐

            HashMap optionInforRecord = new HashMap<>();//하나의 레코드 
            while(resultSet.next())  {
                optionInforRecord = new HashMap<>();
                optionInforRecord.put("OPTION_INFOR_ID", resultSet.getString("OPTION_INFOR_ID"));
                optionInforRecord.put("OPTION_NAME", resultSet.getString("OPTION_NAME"));

                optionInforList.add(optionInforRecord);


                    } // 넣은 것과 반대 순서로 뽑아내 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optionInforList;
    }

    public int Insert(String option_infor_id) {
        return 0;
    }
}