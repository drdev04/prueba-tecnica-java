/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.model;
import java.time.LocalTime;

/**
 *
 * @author RODRIGO
 */
public class Post {
      private final String content;
    private final LocalTime time;

    public Post(String content) {
        this.content = content;
        this.time = LocalTime.now();
    }

    public String getContent() {
        return content;
    }

    public LocalTime getTime() {
        return time;
    }
}
