package com.example.study_servlet.controlls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlet.daos.PollsDao;

@WebServlet(urlPatterns = "/poll/SurveyServlet")
public class PollSurveyServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            // String contents = "Yoju Lab !";
            String contents = request.getParameter("company");

            PollsDao pollsDao = new PollsDao();
            ArrayList surveyList = pollsDao.SelectWithSearch(contents);
            int third = 3;
            for (int i = 0; i < surveyList.size(); i = i + third)
            {
                HashMap survey = (HashMap) surveyList.get(i);
                String questions = (String) survey.get("questions");
                System.out.println(questions);
                int num = 1;
                for (int c = 0; c < third; c++)
                {
                    HashMap survey2 = (HashMap) surveyList.get(c);
                    String choice = (String) survey2.get("choice");
                    System.out.print("(" + num + ")" + choice + " ");
                    num++;
                }
                System.out.println();
            }
            request.setAttribute("contents", contents);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/surveys/survey.jsp");
            requestDispatcher.forward(request, response);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
