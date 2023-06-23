package com.example.study_servlet.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.example.study_servlet.commons.Common;

public class OptionInforsDao
{
    public int DeleteWithUniqueID(String unique_id)
    {
        int count = 0;
        try
        {
            Common common = new Common();
            Statement statement = common.getStatement();
            String query = "delete from option_infors\n" + //
                    "where option_infor_id = '" + unique_id + "';";
            count = statement.executeUpdate(query);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return count;
    }

            public int InsertWithUniqueID(String frontgear)
            {
                int count = 0; // return 값을 넣기 위해 try catch문 밖에 변수 생성
                try
                {
                    Common common = new Common(); // 랜덤 UUID를 생성하기 위해 Common 호출
                    Statement statement = common.getStatement(); // Common에 SQL 구문을 처리하기 위해 statement 명령어 사용
                    String uuid = common.generateUUID(); // 랜덤 UUID를 담는 변수 생성 (generateUUID: 랜덤 ID 생성 메서드)
                    frontgear = "전진기어"; // Quest: 전진기어 생성이므로 변수에 전진기어 값 입력
                    String query = "insert into option_infors\n" + //
                            "(option_infor_id, option_name)\n" + //
                            "values\n" + //
                            "('" + uuid +" ', '" + frontgear + "');"; // query문 작성: insert option_infor_id에 uuid(랜덤아이디), option_name에 frontgear(전진기어) 입력
                    count = statement.executeUpdate(query); // count에 query 명령어 횟수 입력
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                return count;
            }

    public int UpdateWithUniqueID(String unqiue_id, String name)
    {
        int count = 0;
        try
        {
            Common common = new Common();
            Statement statement = common.getStatement();
            name = "회전기어"; // Quest 회전기어, OI001의 값 Update로 변환
            unqiue_id = "OI001";
            String query = "update option_infors\n" + // DB의 Update문
                    "set option_name = '" + name + "'\n" + //
                    "where option_infor_id = '" + unqiue_id + "'";
            count = statement.executeUpdate(query); // 위와 동일
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public ArrayList SelectWithSearch(String search)
    {
        ArrayList optionInforList = new ArrayList<>();
        try
        {
            if (search == null)
            {
                search = "";
            }
            Common common = new Common();
            Statement statement = common.getStatement();
            String query = "select *\n" + //
                    "from option_infors\n" + //
                    "where option_name like '" + search + "%';";

            ResultSet resultSet = statement.executeQuery(query);

            HashMap optionInforRecord = new HashMap<>();

            while (resultSet.next())
            {
                optionInforRecord = new HashMap<>();
                optionInforRecord.put("option_infor_id", resultSet.getString("option_infor_id"));
                optionInforRecord.put("option_name", resultSet.getString("option_name"));

                optionInforList.add(optionInforRecord);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return optionInforList;
    }
}
