/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alex.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

       String firstName = request.getParameter("firstName");
       String lastName = request.getParameter("lastName");
       String email = request.getParameter("email");
       String userName = request.getParameter("userName");
       String password = request.getParameter("password");
       String url;
       String formMessage;
       
       if ( firstName.isEmpty()|| lastName.isEmpty() || email.isEmpty() || userName.isEmpty() || password.isEmpty()) {
           formMessage = "Please fill out all fields";
           url = "/new_customer.jsp";
       }
       else {
           formMessage = "";
           url = "/success.html";
       }
       request.setAttribute("formMessage", formMessage);
       getServletContext().getRequestDispatcher(url).forward(request, response);
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        doPost(request, response);
    }
}
