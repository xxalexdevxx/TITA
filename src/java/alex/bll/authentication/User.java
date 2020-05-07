package alex.bll.authentication;

import alex.bll.issues.Issue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import alex.data.IssueDB;
import alex.data.UserDB;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
//    private String salt;
    private String zipcode;

    @OneToMany
    private List<Issue> issues;
    
    public User() {
        userId = new Long(0);
        firstName = "";
        lastName = "";
        email = "";
        userName = "";
        password = "";
//        salt = "";
        zipcode = "";
        issues = new ArrayList<Issue>();
    }

//        public User(Long userId, String firstName, String lastName, String email, String userName, String salt, String password, String zipcode) {
    public User(Long userId, String firstName, String lastName, String email, String userName, String password, String zipcode) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
//        this.salt = salt;
        this.zipcode = zipcode;
        this.issues = new ArrayList<Issue>();

    }

    public void addIssue(Issue issue) {
        this.issues.add(issue);
    }

    public void removeIssue(Long issueId) {

        for (Issue issue : this.issues) {
            if (Objects.equals(issue.getIssueId(), issueId)) {        
                this.issues.remove(issue);
                break; 
            }
        }
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(ArrayList<Issue> issues) {
        this.issues = issues;
    }
    
    // added for assignment 4
    public List<User> getUsers(){
        return UserDB.selectUsers();
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getSalt() {
//        return salt;
//    }
//
//    public void setSalt(String salt) {
//        this.salt = salt;
//    }
    

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
