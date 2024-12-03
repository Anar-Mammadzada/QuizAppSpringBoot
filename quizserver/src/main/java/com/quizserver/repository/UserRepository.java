package com.quizserver.repository;

import com.quizserver.entity.User;
import com.quizserver.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByRole(UserRole role);

    User findFirstByEmail(String email);
}
