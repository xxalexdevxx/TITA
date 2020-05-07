package alex.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import alex.data.UserDB;
import alex.bll.authentication.User;
import java.security.NoSuchAlgorithmException;
import alex.business.PasswordUtil;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long userId = new Long("0");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String zipcode = request.getParameter("zipcode");
        String url = "";
        String formMessage = "";

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || userName.isEmpty() || password.isEmpty() || zipcode.isEmpty()) {
            formMessage = "Please fill out all fields";
            url = "/new_customer.jsp";
        } else {
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
// SALT AND HASH CODE-------------------------------------------------------
// Long userId = new Long("0");
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String email = request.getParameter("email");
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String zipcode = request.getParameter("zipcode");
//        String url = "";
//        String formMessage = "";
//
//        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || userName.isEmpty() || password.isEmpty() || zipcode.isEmpty()) {
//            formMessage = "Please fill out all fields";
//            url = "/new_customer.jsp";
//        } else {
//            
//            // book hash and salt password
//            String salt = "";
//            String saltedAndHashedPassword;
//            try {
////                hashedPassword = PasswordUtil.hashPassword(password);
//                salt = PasswordUtil.getSalt();
//                saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);
//
//            } catch (NoSuchAlgorithmException ex) {
////                hashedPassword = ex.getMessage();
//                saltedAndHashedPassword = ex.getMessage();
//            }
//            
//            User user = new User(userId, firstName, lastName, email, userName, salt, saltedAndHashedPassword, zipcode);
//            formMessage = "";
//            url = "/success.jsp";
//            HttpSession session = request.getSession();
//            session.setAttribute("userLoggedIn", user);
//            UserDB.insert(user);
//
//            request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);
//            request.setAttribute("salt", salt);
//            
//            //testing, take out
//            System.out.println(saltedAndHashedPassword);
//            System.out.println(salt);
