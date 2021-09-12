package jm.spring_mvc_hibernate.service;

import jm.spring_mvc_hibernate.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(int id);

    public void saveUser(User user);

    void deleteUser(int id);
}
