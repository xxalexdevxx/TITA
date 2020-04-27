package alex.bll.issues;

import alex.bll.authentication.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import alex.bll.issues.Issue;
import javax.servlet.http.HttpSession;
import alex.data.IssueDB;
import java.util.Date;
import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import alex.bll.issues.Issue;
import javax.servlet.http.HttpSession;
import alex.data.IssueDB;
import alex.data.UserDB;
import java.util.Date;
import java.lang.Long;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IssueServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "";
        String formMessage = "";
        String action = request.getParameter("action");

        if (action.equals("create")) {
            Long issueId = new Long(0);
            String issueSummary = request.getParameter("issueSummary");
            String issueStatus = request.getParameter("issueStatus");
            Date issueCreatedDate = new Date();
            Integer estimatedEffort = Integer.parseInt(request.getParameter("estimatedEffort"));
            String estimatedCompletionDate = request.getParameter("estimatedCompletionDate");

            if (issueSummary.isEmpty() || issueStatus.isEmpty() || estimatedCompletionDate.isEmpty()) {
                formMessage = "Please fill out all fields";
                url = "/new_issue.jsp";
            } else {
                Issue issue = new Issue(issueId, issueSummary, issueStatus, issueCreatedDate, estimatedEffort, estimatedCompletionDate);
                formMessage = "";
                url = "/dashboard.jsp";

                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("userLoggedIn"); // so this is adding the issue to the user logged in rather than adding the issue to a user assigned in the new issue form?

                user.addIssue(issue);
                UserDB.update(user);
                session.setAttribute("userName", user);
            }
        } else if (action.equals("delete")) {
            
            HttpSession session = request.getSession();
            String issueId = request.getParameter("issueId"); // getting as a string here, but it is changed to long below.
            User user = (User) session.getAttribute("userName");
            user.removeIssue(Long.parseLong(issueId)); // something goes wrong here
            UserDB.update(user);
            session.setAttribute("userName", user);
        }

        request.setAttribute("formMessage", formMessage);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}


