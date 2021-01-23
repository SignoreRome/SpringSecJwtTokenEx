package com.lolka.Springsecurityexample.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.lolka.Springsecurityexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
