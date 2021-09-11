package jm.spring_mvc_hibernate.service;

import jm.spring_mvc_hibernate.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
