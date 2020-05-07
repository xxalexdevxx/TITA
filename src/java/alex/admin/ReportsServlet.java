package alex.admin;

import alex.bll.authentication.User;
import alex.data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReportsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "";
        HttpSession session = request.getSession();

        List<User> users = UserDB.selectUsers();

        session.setAttribute("user", users);


        url = "/reports.jsp"; // works a bit better, but still breaks other items
        
      // url = "/admin/reports.jsp";  //works but breaks all other links unless the link is modified. where is the page??   
//       url = "reports.jsp"; 
 //      url = "admin/reports.jsp";     
//       url = "../admin/reports.jsp"; 
//       url = "../reports.jsp";
//       url = "web/admin/reports.jsp";

        getServletContext().getRequestDispatcher(url).forward(request, response);


    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
