package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CheckoutResponseServlet")
public class CheckoutResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
           
            PrintWriter printWriter = response.getWriter();
           
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <h2>Billing address</h2>\r\n" + //
                    "    <div>\r\n" + //
                    "        <form action=\"../index.html\">\r\n" + //
                    "\r\n" + //
                    "            First name &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Last name\r\n" + //
                    "            <div></div>\r\n" + //
                    "            <input type=\"text\" placeholder=\"\uD14D\uC2A4\uD2B8\uB97C \uC785\uB825\uD558\uC138\uC694\">\r\n" + //
                    "            <input type=\"text\" placeholder=\"\uD14D\uC2A4\uD2B8\uB97C \uC785\uB825\uD558\uC138\uC694\">\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "            <br>\r\n" + //
                    "            <br>\r\n" + //
                    "\r\n" + //
                    "            Username\r\n" + //
                    "            <div></div>\r\n" + //
                    "            <input type=\"text\" placeholder=\"@ Username\" size=\"45\">\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "            <br>\r\n" + //
                    "            <br>\r\n" + //
                    "            Email(Optional)\r\n" + //
                    "            <div></div>\r\n" + //
                    "            <input type=\"text\" placeholder=\"you@example.com\" size=\"45\">\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "            <br>\r\n" + //
                    "            <br>\r\n" + //
                    "            Address\r\n" + //
                    "            <div></div>\r\n" + //
                    "            <input type=\"text\" placeholder=\"1234 Main St\" size=\"45\">\r\n" + //
                    "\r\n" + //
                    "            <br>\r\n" + //
                    "            <br>\r\n" + //
                    "            Address 2(Optional)\r\n" + //
                    "            <div></div>\r\n" + //
                    "            <input type=\"text\" placeholder=\"Apartment or suite\" size=\"45\">\r\n" + //
                    "\r\n" + //
                    "            <br>\r\n" + //
                    "            <br>\r\n" + //
                    "\r\n" + //
                    "            <label for=\"countries\">Country</label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\r\n" + //
                    "            <label for=\"state\">State</label>&nbsp; &nbsp; &nbsp; &nbsp; \r\n" + //
                    "            <label for=\"zip\">Zip</label>\r\n" + //
                    "            <div>\r\n" + //
                    "\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <td>\r\n" + //
                    "                        <select name=\"countries\" id=\"countries\">\r\n" + //
                    "                            <option vlue=\" choose ..\" selected>choose... </option>\r\n" + //
                    "\r\n" + //
                    "                            <!-- Add additional country options below -->\r\n" + //
                    "                            <option value=\"USA\">USA</option>\r\n" + //
                    "                            <option value=\"Canada\">Canada</option>\r\n" + //
                    "                            <option value=\"UK\">UK</option>\r\n" + //
                    "                        </select>\r\n" + //
                    "                    </td>\r\n" + //
                    "                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; \r\n" + //
                    "                    <td>\r\n" + //
                    "                        <select name=\"state\" id=\"state\">\r\n" + //
                    "                            <option vlue=\" choose ..\" selected>choose... </option>\r\n" + //
                    "\r\n" + //
                    "                            <!-- Add additional country options below -->\r\n" + //
                    "                            <option value=\"New York\">New York</option>\r\n" + //
                    "                            <option value=\"Toronto\">Toronto</option>\r\n" + //
                    "                            <option value=\"London\">London</option>\r\n" + //
                    "                            </select>\r\n" + //
                    "                    </td>\r\n" + //
                    "                    <input type=\"text\" placeholder=\"\" size=\"10\">\r\n" + //
                    "                    <br>\r\n" + //
                    "                    <br>\r\n" + //
                    "                    <button type=\"submit\"> submit</button\">\r\n" + //
                    "                </tr>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "        \r\n" + //
                    "               \r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "        </form>\r\n" + //
                    "    </div>\r\n" + //
                    "</body>\r\n" + //
                    "\r\n" + //
                    "</html> ";
               
            printWriter.println(contents);
            printWriter.close();
            // PrintWriter printWriter = response.getWriter();
            // String contents = "";
            // printWriter.println(contents);
            // printWriter.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}