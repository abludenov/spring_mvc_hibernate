package jm.spring_mvc_hibernate.service;

import jm.spring_mvc_hibernate.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(int id);

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);


}
