package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/checkoutresponseservlet")
public class CheckoutResponseServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String secondaddress = request.getParameter("secondaddress");
        String zip = request.getParameter("zip");
        String cardname = request.getParameter("cardname");
        int cardnumber = 0;
        String expiration = request.getParameter("expiration");
        int cvv = 0;

        PrintWriter printWriter = response.getWriter();
        String contents = "<html lang=\"en\">\r\n" + //
                "<head>\r\n" + //
                "    <meta charset=\"UTF-8\">\r\n" + //
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
                "    <title>Check out</title>\r\n" + //
                "</head>\r\n" + //
                "<body>\r\n" + //
                "    <div class=\"container-fluid text-center my-5\">\r\n" + //
                "        <div><img src=\"https://getbootstrap.com/docs/5.3/assets/brand/bootstrap-logo.svg\" alt=\"\" height=\"80px\" width=\"100px\"></div>\r\n" + //
                "        <div class=\"my-3\"><h2>Checkout form</h2></div>\r\n" + //
                "        <div>Below is an example form built entirely with Bootstrap\u2019s form controls. Each required form group has a</div>\r\n" + //
                "        <div>validation state that can be triggered by attempting to submit the form without completing it.</div>\r\n" + //
                "    </div>\r\n" + //
                "    <div class=\"container\">\r\n" + //
                "        <form action=\"http://192.168.0.40:8080/checkoutresponseservlet\">\r\n" + //
                "        <div class=\"row\">\r\n" + //
                "            <h4>Billing address</h4>\r\n" + //
                "            <div class=\"col-4\">\r\n" + //
                "                <label class=\"form-label\" for=\"firstname\">FirstName</label>\r\n" + //
                "                <input class=\"form-control\" type=\"text\" id=\"firstname\" name=\""+firstname+"\">\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-4\">\r\n" + //
                "                <label class=\"form-label\" for=\"lastname\">LastName</label>\r\n" + //
                "                <input class=\"form-control\" type=\"text\" id=\"lastname\" name=\""+lastname+"\">\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-8\">\r\n" + //
                "                <label class=\"form-label\" for=\"username\">Username</label>\r\n" + //
                "                <input class=\"form-control\" type=\"text\" placeholder=\"Username\" id=\"username\" name=\""+username+"\">\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-8\">\r\n" + //
                "                <label class=\"form-label\" for=\"email\">Email (Optional)</label>\r\n" + //
                "                <input class=\"form-control\" type=\"email\" placeholder=\"you@example.com\" id=\"email\" name=\""+email+"\">\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-8\">\r\n" + //
                "                <label class=\"form-label\" for=\"address\">Address</label>\r\n" + //
                "                <input class=\"form-control\" type=\"text\" placeholder=\"1234 Main st\" id=\"address\" name=\""+address+"\">\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-8\">\r\n" + //
                "                <label class=\"form-label\" for=\"secondaddress\">Address 2 (Optional)</label>\r\n" + //
                "                <input class=\"form-control\" type=\"text\" placeholder=\"Apartmentor suite\" id=\"secondaddress\" name=\""+secondaddress+"\">\r\n" + //
                "            </div>\r\n" + //
                "        </div>\r\n" + //
                "        <div class=\"row\">\r\n" + //
                "            <div class=\"col-3\">\r\n" + //
                "                <label class=\"form-label\" for=\"\">Country</label>\r\n" + //
                "                <select class=\"form-select\" name=\"country\" id=\"\">\r\n" + //
                "                    <option value=\"\">Choose...</option>\r\n" + //
                "                    <option value=\"unitedstates\">United States</option>\r\n" + //
                "                </select>\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-3\">\r\n" + //
                "                <label class=\"form-label\" for=\"\">State</label>\r\n" + //
                "                <select class=\"form-select\" name=\"state\" id=\"\">\r\n" + //
                "                    <option value=\"\">Choose...</option>\r\n" + //
                "                    <option value=\"california\">California</option>\r\n" + //
                "                </select>\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-2\">\r\n" + //
                "                <label class=\"form-label\" for=\"zip\">Zip</label>\r\n" + //
                "                <input class=\"form-control\" type=\"text\" id=\"zip\" name=\""+zip+"\">\r\n" + //
                "            </div>\r\n" + //
                "        </div>\r\n" + //
                "        <hr>\r\n" + //
                "        <div>\r\n" + //
                "            <input type=\"checkbox\" name=\"mycheck\" id=\"idcheck\">\r\n" + //
                "            <label for=\"idcheck\">Shipping address is the same as my billing address</label>\r\n" + //
                "        </div>\r\n" + //
                "        <div>\r\n" + //
                "            <input type=\"checkbox\" name=\"mycheck\" id=\"idcheck\">\r\n" + //
                "            <label for=\"idcheck\">Save this information for next time</label>\r\n" + //
                "        </div>\r\n" + //
                "        <hr>\r\n" + //
                "        <div>\r\n" + //
                "            <input type=\"radio\" name=\"payment\" id=\"credit card\" value=\"credit card\" class=\"form-check-input\" checked>\r\n" + //
                "            <label for=\"credit card\" class=\"form-check-label\">Credit card</label>\r\n" + //
                "        </div>\r\n" + //
                "        <div>\r\n" + //
                "            <input type=\"radio\" name=\"payment\" id=\"debit card\" value=\"debit card\" class=\"form-check-input\">\r\n" + //
                "            <label for=\"debit card\" class=\"form-check-label\">Debit card</label>\r\n" + //
                "        </div>\r\n" + //
                "        <div>\r\n" + //
                "            <input type=\"radio\" name=\"payment\" id=\"paypal\" value=\"paypal\" class=\"form-check-input\">\r\n" + //
                "            <label for=\"paypal\" class=\"form-check-label\">PayPal</label>\r\n" + //
                "        </div>\r\n" + //
                "        <div class=\"row\">\r\n" + //
                "            <div class=\"col-4\">\r\n" + //
                "                <label class=\"form-label\" for=\"cardname\">Name on card</label>\r\n" + //
                "                <input class=\"form-control\" type=\"text\" id=\"cardname\" name=\""+cardname+"\">\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-4\">\r\n" + //
                "                <label class=\"form-label\" for=\"cardnumber\">Credit card number</label>\r\n" + //
                "                <input class=\"form-control\" type=\"number\" id=\"cardnumber\" name=\""+cardnumber+"\">\r\n" + //
                "            </div>\r\n" + //
                "            <div>\r\n" + //
                "                Full name as displayed on card\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-2\">\r\n" + //
                "                <label class=\"form-label\" for=\"expiration\">Expiration</label>\r\n" + //
                "                <input class=\"form-control\" type=\"text\" id=\"expiration\" name=\""+expiration+"\">\r\n" + //
                "            </div>\r\n" + //
                "            <div class=\"col-2\">\r\n" + //
                "                <label class=\"form-label\" for=\"cvv\">CVV</label>\r\n" + //
                "                <input class=\"form-control\" type=\"password\" id=\"cvv\" name=\""+cvv+"\">\r\n" + //
                "            </div>\r\n" + //
                "        </div>\r\n" + //
                "        <hr>\r\n" + //
                "        <div>\r\n" + //
                "            <button class=\"w-100 btn btn-primary\">Continue to checkout</button>\r\n" + //
                "        </div>\r\n" + //
                "    </form>\r\n" + //
                "    </div>\r\n" + //
                "</body>\r\n" + //
                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js\"></script>\r\n" + //
                "</html>";

        printWriter.println(contents);
        printWriter.close();
    }
}
