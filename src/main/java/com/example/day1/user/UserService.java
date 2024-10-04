package com.example.day1.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse get(int id) {

        Optional<MyUser> result = userRepository.findById((long)id);
        if(result.isEmpty()){
            throw  new UserNotFouneException(new StringBuilder().append("User id not found =").append(id).toString());
        }

        UserResponse userResponse = new UserResponse();
        userResponse.setId(id);
        userResponse.setFname(result.get().getFirstName());
        userResponse.setLname(result.get().getLastName());
        return  userResponse;
    }

    @Transactional
    public UserResponse createNewUser(CreateUserRequest createUserRequest) {
        MyUser myUser = new MyUser();
        myUser.setFirstName(createUserRequest.getFname());
        myUser.setLastName(createUserRequest.getLname());
        myUser.setAge(createUserRequest.getAge());

        List<MyUser> myUserDB = userRepository.findByFirstName(myUser.getFirstName());
        if(!myUserDB.isEmpty()){
            throw new FirstNameDuplicateException("Firstname was duplicate");
        }
        myUser = userRepository.saveAndFlush(myUser);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(Math.toIntExact(myUser.getId()));
        userResponse.setFname(myUser.getFirstName());
        userResponse.setLname(myUser.getLastName());

        return userResponse;
    }
}
