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

public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
   
       String userName = request.getParameter("userName");
       String password = request.getParameter("password");
       String url;
       
       if (userName.equals("sally.reid@tita.com") && password.equals("letmein") ) {
          url = "/account_activity.jsp";
       }
       else {
          url = "/login_failure.jsp";
       }
       
       getServletContext().getRequestDispatcher(url).forward(request, response); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        doPost(request, response);
    }
}
