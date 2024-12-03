package com.quizserver.service;

import com.quizserver.entity.User;
import com.quizserver.enums.UserRole;
import com.quizserver.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void createAdminUser(){
        User optionalUser = userRepository.findByRole(UserRole.ADMIN);
        if(optionalUser == null){
            User user = new User();
            user.setName("admin");
            user.setEmail("admin@gmail.com");
            user.setRole(UserRole.ADMIN);
            user.setPassword("admin");

            userRepository.save(user);
        }
    }

    public Boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email) != null;
    }
}