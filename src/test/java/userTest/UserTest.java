/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RODRIGO
 */
package userTest;

import com.socialmedia.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
     @Test
    void testFollow() {
        User alice = new User("Alice");
        User bob = new User("Bob");

        assertTrue(alice.follow(bob));
        assertFalse(alice.follow(bob)); // Bob ya está siendo seguido por Alice
    }

    @Test
    void testPostMessage() {
        User alice = new User("Alice");
        alice.postMessage("Hello World");

        assertEquals(1, alice.getPosts().size());
        assertEquals("Hello World", alice.getPosts().get(0).getContent());
    }
}
