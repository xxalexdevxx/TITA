/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alex.bll.issues;
import java.time.LocalDate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import alex.bll.issues.Issue;
import alex.bll.issues.IssueServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */

public class IssueServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String issueSummary = request.getParameter("issueSummary");
        String assignedOwner = request.getParameter("assignedOwner");
        String issueStatus = request.getParameter("issueStatus");
        LocalDate issueCreatedDate = LocalDate.now();
        Integer estimatedEffort = Integer.parseInt(request.getParameter("estimatedEffort"));
        String estimatedCompletionDate = request.getParameter("estimatedCompletionDate");
        String formMessage = "";
        String url = "";
        Issue issue = new Issue(issueSummary, assignedOwner, issueStatus, issueCreatedDate, estimatedEffort, estimatedCompletionDate);
       
        
        if ( issueSummary.isEmpty() || assignedOwner.isEmpty() || issueStatus.isEmpty() || estimatedCompletionDate.isEmpty() ) {
           formMessage = "Please fill out all fields";
           url = "/new_issue.jsp";
       }
        else {
           formMessage = "";
           url = "/dashboard.jsp";
           HttpSession session = request.getSession();
           session.setAttribute("issue", issue);
       }     
       request.setAttribute("formMessage", formMessage);
       request.setAttribute("issue", issue);
       getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doPost(request, response);
    }
}
