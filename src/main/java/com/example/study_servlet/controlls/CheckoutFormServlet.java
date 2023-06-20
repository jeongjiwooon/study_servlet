package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CheckoutFormServlet")
public class CheckoutFormServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        try {
           
            PrintWriter printWriter = response.getWriter();
            String contents = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Document</title>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "    <h2>Billing address</h2>\n" +
                    "    <div>\n" +
                    "        <form action=\"../index.html\">\n" +
                    "\n" +
                    "            First name &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Last name\n" +
                    "            <div></div>\n" +
                    "            <input type=\"text\" placeholder=\"텍스트를 입력하세요\">\n" +
                    "            <input type=\"text\" placeholder=\"텍스트를 입력하세요\">\n" +
                    "\n" +
                    "\n" +
                    "            <br>\n" +
                    "            <br>\n" +
                    "\n" +
                    "            Username\n" +
                    "            <div></div>\n" +
                    "            <input type=\"text\" placeholder=\"@ Username\" size=\"45\">\n" +
                    "\n" +
                    "\n" +
                    "            <br>\n" +
                    "            <br>\n" +
                    "            Email(Optional)\n" +
                    "            <div></div>\n" +
                    "            <input type=\"text\" placeholder=\"you@example.com\" size=\"45\">\n" +
                    "\n" +
                    "\n" +
                    "            <br>\n" +
                    "            <br>\n" +
                    "            Address\n" +
                    "            <div></div>\n" +
                    "            <input type=\"text\" placeholder=\"1234 Main St\" size=\"45\">\n" +
                    "\n" +
                    "            <br>\n" +
                    "            <br>\n" +
                    "\n" +
                    "            Address 2(Optional)\n" +
                    "            <div></div>\n" +
                    "            <input type=\"text\" placeholder=\"Apartment or suite\" size=\"45\">\n" +
                    "\n" +
                    "            <br>\n" +
                    "            <br>\n" +
                    "\n" +
                    "            <label for=\"countries\">Country</label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\n" +
                    "            <label for=\"state\">State</label>&nbsp; &nbsp; &nbsp; &nbsp;\n" +
                    "            <label for=\"zip\">Zip</label>\n" +
                    "            <div>\n" +
                    "\n" +
                    "                <tr>\n" +
                    "                    <td>\n" +
                    "                        <select name=\"countries\" id=\"countries\">\n" +
                    "                            <option value=\" choose ..\" selected>choose... </option>\n" +
                    "\n" +
                    "                            <!-- Add additional country options below -->\n" +
                    "                            <option value=\"USA\">USA</option>\n" +
                    "                            <option value=\"Canada\">Canada</option>\n" +
                    "                            <option value=\"UK\">UK</option>\n" +
                    "                        </select>\n" +
                    "                    </td>\n" +
                    "                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\n" +
                    "                    <td>\n" +
                    "                        <select name=\"state\" id=\"state\">\n" +
                    "                            <option value=\" choose ..\" selected>choose... </option>\n" +
                    "\n" +
                    "                            <!-- Add additional country options below -->\n" +
                    "                            <option value=\"New York\">New York</option>\n" +
                    "                            <option value=\"Toronto\">Toronto</option>\n" +
                    "                            <option value=\"London\">London</option>\n" +
                    "                        </select>\n" +
                    "                    </td>\n" +
                    "                    <input type=\"text\" placeholder=\"\" size=\"10\">\n" +
                    "                    <br>\n" +
                    "                    <br>\n" +
                    "                    <button type=\"submit\">submit</button>\n" +
                    "                </tr>\n" +
                    "\n" +
                    "        </form>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>";

            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }
}