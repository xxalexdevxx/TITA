
package alex.bll.issues;

import java.util.Date;
import alex.bll.authentication.User;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import java.util.*;

@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long issueId;
    private String issueSummary;
    private String issueStatus;
    @Temporal(TemporalType.DATE)
    private Date issueCreatedDate;
    private Integer estimatedEffort;
    private String estimatedCompletionDate;

//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private User assignedUser;


    public Issue() {
        issueId = new Long(0);
        issueSummary = "";
        issueStatus = "";
        issueCreatedDate = new Date();
        estimatedEffort = 0;
        estimatedCompletionDate = "";
    }
    public Issue(Long issueId, String issueSummary, String issueStatus, Date issueCreatedDate, Integer estimatedEffort, String estimatedCompletionDate) {
        this.issueId = issueId;
        this.issueSummary = issueSummary;
        this.issueStatus = issueStatus;
        this.issueCreatedDate = issueCreatedDate;
        this.estimatedEffort = estimatedEffort;
        this.estimatedCompletionDate = estimatedCompletionDate;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getIssueSummary() {
        return issueSummary;
    }

    public void setIssueSummary(String issueSummary) {
        this.issueSummary = issueSummary;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Date getIssueCreatedDate() {
        return issueCreatedDate;
    }

    public void setIssueCreatedDate(Date issueCreatedDate) {
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