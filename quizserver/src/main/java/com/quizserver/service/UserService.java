package com.quizserver.service;

import com.quizserver.entity.User;

public interface UserService {

    User createUser(User user);

    Boolean hasUserWithEmail(String email);

}
