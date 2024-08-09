/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.socialmedia;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.service.SocialMediaService;
import com.socialmedia.ui.ConsoleInterface;
/**
 *
 * @author RODRIGO
 */
public class Main {

    public static void main(String[] args) throws UserNotFoundException {
        ConsoleInterface console = new ConsoleInterface();
        console.start();       
    }
}

