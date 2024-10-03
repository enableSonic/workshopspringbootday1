package com.example.day1.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Found User Id = 1")
    public void case01(){
        MyUser myUser = new MyUser();
        myUser.setId(1L);
        myUser.setFirstName("FName");
        myUser.setLastName("LName");
        myUser.setAge(10);
        userRepository.saveAndFlush(myUser);

        // Act
        Optional<MyUser> result = userRepository.findById(1L);

        //Assert
        assertEquals(1, result.get().getId());
        assertEquals("FName", result.get().getFirstName());
    }
}