/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.repository;
import com.socialmedia.model.User;
import com.socialmedia.exceptions.UserNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author RODRIGO
 */
public class UserRepository {
    private final Map<String, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) throws UserNotFoundException {
        if (!users.containsKey(username)) {
            throw new UserNotFoundException("No se encontró ningún usuario @" + username);
        }
        return users.get(username);
    }
}
