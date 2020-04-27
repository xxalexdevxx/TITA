package alex.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
//import javax.persistence.NoResultException;
import alex.bll.issues.Issue;
import java.util.List;

public class IssueDB {

    public static void insertIssue(Issue issue) {
        EntityManager entityManager = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(issue);
        transaction.commit();
        entityManager.close();

//        try {
//            entityManager.persist(issue);
//            transaction.commit();
//        } catch (Exception exception) {
//            transaction.rollback();
//            System.out.println(exception);
//        } finally {
//            entityManager.close();
//        }          
    }

    // this will not work because we moved "assignedUser"
    public static List<Issue> selectIssues(String assignedUser) {

        EntityManager entityManager = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String queryString = "SELECT i FROM Issue i WHERE i.assignedUser = :assignedUser";
        TypedQuery<Issue> query = entityManager.createQuery(queryString, Issue.class);
        query.setParameter("assignedUser", assignedUser);
        transaction.begin();

        List<Issue> issues;
        issues = query.getResultList();
        transaction.commit();
        entityManager.close();
        return issues;

//        try {
//            issues = query.getResultList();
//            
//        } finally {
//            entityManager.close();
//        }
//        return issues;
    }

    // this needs to take the issue id 
    public static void deleteIssue(Issue issueId) {
        EntityManager entityManager = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        entityManager.remove(issueId);
        entityManager.remove(entityManager.merge(issueId));
        transaction.commit();
        entityManager.close();

//        try {
//            entityManager.remove(issueId);
//            transaction.commit();
//        } catch (Exception exception) {
//            transaction.rollback();
//            System.out.println(exception);
//        } finally {
//            entityManager.close();
//        }          
    }
}
