package alex.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import alex.data.UserDB;
import alex.bll.authentication.User;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       
       Long userId =  new Long("0"); 
       String firstName = request.getParameter("firstName");
       String lastName = request.getParameter("lastName");
       String email = request.getParameter("email");
       String userName = request.getParameter("userName");
       String password = request.getParameter("password");
       String zipcode = request.getParameter("zipcode");
       String url = "";
       String formMessage = "";
     
       if ( firstName.isEmpty()|| lastName.isEmpty() || email.isEmpty() || userName.isEmpty() || password.isEmpty() || zipcode.isEmpty()) {
           formMessage = "Please fill out all fields";
           url = "/new_customer.jsp";
       }
       else {
           User user = new User(userId, firstName, lastName, email, userName, password, zipcode);
           formMessage = "";
           url = "/success.jsp";
           HttpSession session = request.getSession();
           session.setAttribute("userLoggedIn", user);
//           request.setAttribute("user", user);
           UserDB.insert(user);
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
