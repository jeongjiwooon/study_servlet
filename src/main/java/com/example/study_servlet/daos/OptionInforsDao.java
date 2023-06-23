<<<<<<< HEAD
package com.example.study_servlet.daos;
=======
package com.example.study_servlets.daos;
>>>>>>> 6b2d51295e1ce4c724a5b06de883f570fa6c2dc3

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

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
                int count = 0;
                try
                {
                    Common common = new Common();
                    Statement statement = common.getStatement();
                    String uuid = common.generateUUID();
                    String query = "insert into option_infors\n" + //
                            "(option_infor_id, option_name)\n" + //
                            "values\n" + //
                            "('" + uuid +" ', '" + frontgear + "');";
                    count = statement.executeUpdate(query);
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
            String query = "update option_infors\n" + //
                    "set option_name = '" + name + "'\n" + //
                    "where option_infor_id = '" + unqiue_id + "'";
            count = statement.executeUpdate(query);
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
