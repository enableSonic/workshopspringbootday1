package com.example.day1.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<MyUser, Long> {



    List<MyUser> findByFirstName(String fistName);

}
