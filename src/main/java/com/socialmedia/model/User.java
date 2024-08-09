/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.model;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class User {
    private final String username;
    private final List<User> following;
    private final List<Post> posts;

    public User(String username) {
        this.username = username;
        this.following = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean follow(User followee) {
        if (!following.contains(followee)) {
            following.add(followee);
            return true;
        }
        return false;
    }

    public void postMessage(String message) {
        posts.add(new Post(message));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void viewDashboard() {
        for (User user : following) {
            user.getPosts().forEach(post -> System.out.println(
                "\"" + post.getContent() + "\" @" + user.getUsername() + " @" + post.getTime()));
        }
    }
    public LocalTime getLastPostTime() {
        if (!posts.isEmpty()) {
            return posts.get(posts.size() - 1).getTime();
        }
        return null;
     }
}
