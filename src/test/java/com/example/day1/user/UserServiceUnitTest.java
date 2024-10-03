package com.example.day1.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("UserServcie Unit Test Success")
    void get(){
        // Arrange
        MyUser myUser = new MyUser();
        myUser.setId(1L);
        myUser.setFirstName("FName");
        when(userRepository.findById(1L)).thenReturn(Optional.of(myUser));

        UserService service = new UserService(userRepository);
        //Act
        UserResponse result = service.get(1);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("FName", result.getFname());
    }


}