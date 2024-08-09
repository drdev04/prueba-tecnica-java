/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialmediaserviceTest;

import com.socialmedia.model.User;
import com.socialmedia.repository.UserRepository;
import com.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.service.SocialMediaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RODRIGO
 */
class SocialMediaServiceTest {    
    
    private SocialMediaService service;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() throws UserNotFoundException {
        userRepository = Mockito.mock(UserRepository.class);
        service = new SocialMediaService(userRepository);

        User alfonso = new User("Alfonso");
        User ivan = new User("Ivan");
        User alicia = new User("Alicia");

        Mockito.when(userRepository.getUser("Alfonso")).thenReturn(alfonso);
        Mockito.when(userRepository.getUser("Ivan")).thenReturn(ivan);
        Mockito.when(userRepository.getUser("Alicia")).thenReturn(alicia);
    }

    @Test
    void testPostMessage() throws UserNotFoundException {
        service.postMessage("Alfonso", "Hello World");
        // Verifica que el mensaje se haya publicado correctamente
    }

    @Test
    void testFollowUser() throws UserNotFoundException {
        service.followUser("Alicia", "Ivan");
        // Verifica que Alicia esté siguiendo a Ivan
    }

    @Test
    void testViewDashboard() throws UserNotFoundException {
        service.viewDashboard("Alicia");
        // Verifica que el dashboard de Alicia se muestre correctamente
    }
}
