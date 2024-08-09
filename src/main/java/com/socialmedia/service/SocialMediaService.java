/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.service;

import com.socialmedia.model.User;
import com.socialmedia.repository.UserRepository;
import com.socialmedia.exceptions.UserNotFoundException;

/**
 *
 * @author RODRIGO
 */
public class SocialMediaService {
    private final UserRepository userRepository;
    
    // Constructor para pruebas
    public SocialMediaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SocialMediaService() {
        this.userRepository = new UserRepository();
        initializeUsers();
    }

    private void initializeUsers() {
        userRepository.addUser(new User("Alfonso"));
        userRepository.addUser(new User("Ivan"));
        userRepository.addUser(new User("Alicia"));
    }

    public void postMessage(String username, String message) throws UserNotFoundException {
        User user = userRepository.getUser(username);
        user.postMessage(message);
        System.out.println(username + " posted -> \"" + message + "\" @" + user.getLastPostTime());
    }

    public void followUser(String followerUsername, String followeeUsername) throws UserNotFoundException {
        User follower = userRepository.getUser(followerUsername);
        User followee = userRepository.getUser(followeeUsername);

        if (follower.follow(followee)) {
            System.out.println(followerUsername + " empezó a seguir a " + followeeUsername);
        } else {
            System.out.println(followerUsername + " ya está siguiendo a " + followeeUsername);
        }
    }

    public void viewDashboard(String username) throws UserNotFoundException {
        User user = userRepository.getUser(username);
        user.viewDashboard();
    }
}
