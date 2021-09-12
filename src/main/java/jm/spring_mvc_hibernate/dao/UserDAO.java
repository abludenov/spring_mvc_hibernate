package jm.spring_mvc_hibernate.dao;

import jm.spring_mvc_hibernate.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public User getUser(int id);

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

}
