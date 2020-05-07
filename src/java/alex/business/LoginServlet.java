package alex.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import alex.bll.authentication.User;
import alex.data.UserDB;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String url;

        User actualUser = UserDB.findByUserName(userName);

        if (actualUser == null) {
//           url = "/new_customer.jsp";
            url = "/login_failure.jsp";
        } else if (actualUser.getUserName().equals(userName) && (actualUser.getPassword().equals(password))) {
            HttpSession session = request.getSession();
            url = "/dashboard.jsp";
            session.setAttribute("userLoggedIn", actualUser);
        } else {
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
