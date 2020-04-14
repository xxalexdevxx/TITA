package alex.bll.issues;
import java.time.LocalDate;

public class Issue {
    private String issueSummary;
    private String assignedOwner;
    private String issueStatus;
    private LocalDate issueCreatedDate;
    private Integer estimatedEffort;
    private String estimatedCompletionDate;
    
    public Issue() {
        issueSummary = "";
        assignedOwner = "";
        issueStatus = "";
        issueCreatedDate = LocalDate.now();
        estimatedEffort = 0;
        estimatedCompletionDate = "";
    }
   
    public Issue(String issueSummary, String assignedOwner, String issueStatus, LocalDate issueCreatedDate, Integer estimatedEffort, String estimatedCompletionDate) {
           this.issueSummary = issueSummary;      
           this.assignedOwner = assignedOwner;
           this.issueStatus = issueStatus;
           this.issueCreatedDate = issueCreatedDate;
           this.estimatedEffort = estimatedEffort;
           this.estimatedCompletionDate = estimatedCompletionDate;
    }      
    
    public String getIssueSummary() {
        return issueSummary;
    }

    public void setIssueSummary(String issueSummary) {
        this.issueSummary = issueSummary;
    }

    public String getAssignedOwner() {
        return assignedOwner;
    }

    public void setAssignedOwner(String assignedOwner) {
        this.assignedOwner = assignedOwner;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public LocalDate getIssueCreatedDate() {
        return issueCreatedDate;
    }

    public void setIssueCreatedDate(LocalDate issueCreatedDate) {
        this.issueCreatedDate = issueCreatedDate;
    }
    
    public int getEstimatedEffort() {
        return estimatedEffort;
    }

    public void setEstimatedEffort(Integer estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }

    public String getEstimatedCompletionDate() {
        return estimatedCompletionDate;
    }

    public void setEstimatedCompletionDate(String estimatedCompletionDate) {
        this.estimatedCompletionDate = estimatedCompletionDate;
    }
}
