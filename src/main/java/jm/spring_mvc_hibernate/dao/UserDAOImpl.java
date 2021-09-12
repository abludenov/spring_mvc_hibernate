package jm.spring_mvc_hibernate.dao;


import jm.spring_mvc_hibernate.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("DELETE from User " + "where id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    @Override
//    public List<User> getAllUsers() {
//        return entityManager.createQuery("from User", User.class).getResultList();
//    }
//
//    @Override
//    public void saveUser(User user) {
//        entityManager.persist(user);
//    }
//
//    @Override
//    public User getUser(int id) {
//        TypedQuery<User> query = entityManager.createQuery("select user from User user where user.id = :id", User.class);
//        query.setParameter("id", id);
//        return query.getResultList().stream().findAny().orElse(null);
//    }
//
//    @Override
//    public void deleteUser(int id) {
//        entityManager.getTransaction().begin();
//        User user = entityManager.find(User.class, id);
//        entityManager.remove(user);
//        entityManager.getTransaction().commit();
//    }
}
