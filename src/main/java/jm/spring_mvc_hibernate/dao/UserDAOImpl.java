package jm.spring_mvc_hibernate.dao;

import jm.spring_mvc_hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


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
        Query<User> query = session.createQuery("DELETE FROM User " + "where id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
