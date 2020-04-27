package alex.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
//import javax.persistence.TypedQuery;
//import javax.persistence.NoResultException;
import alex.bll.authentication.User;
import javax.persistence.TypedQuery;

public class UserDB {

    public static void insert(User user) {
        EntityManager entityManager = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            System.out.println(exception);
        } finally {
            entityManager.close();
        }
    }

    public static User findByUserName(String userName) {
        EntityManager entityManager = DBUtil.getEntityManagerFactory().createEntityManager();
        String queryString = "SELECT u FROM User u WHERE u.userName = :userName";
        TypedQuery<User> q = entityManager.createQuery(queryString, User.class);
        q.setParameter("userName", userName);

        User user = q.getSingleResult();
        entityManager.close();
        return user;
    }

// prof code
    public static User update(User user) {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }
    
    
    
    
    
    //    public static void update(User user) {
//        EntityManager entityManager = DBUtil.getEntityManagerFactory().createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        try {
//            entityManager.merge(user);
//            transaction.commit();
//        } catch (Exception exception) {
//            transaction.rollback();
//            System.out.println(exception);
//        } finally {
//            entityManager.close();
//        }
//    }
}
