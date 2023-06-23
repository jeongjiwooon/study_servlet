package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsUpdateServlet")
public class OptionInforsUpdateServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String name = request.getParameter("name"); // doGet에 포함된 request에 name 변수 넣기
            String unqiue_id = request.getParameter("unique_id"); // doGet에 포함된 request에 unique_id 변수 넣기

            OptionInforsDao optionInforsDao = new OptionInforsDao(); // OptionInforsDao 불러오기
            int count = optionInforsDao.UpdateWithUniqueID(unqiue_id, name); // count 변수에 UpdateWithUniqueID 메서드 불러오기

            response.setContentType("text/html;charset=UTF-8"); // 한글 깨짐 방지
            PrintWriter printWriter = response.getWriter(); // 네크워크로 보내줌
            String contents = "Update count: " + count; // Update의 count 값 입력
            printWriter.println(contents); // Update의 count 값이 포함된 contents 출력 / 홈페이지에 몇개의 수정을 했는지 보여주기 위해 count로 입력
            printWriter.close(); // 종료
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
