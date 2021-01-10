package com.example.board.domain.auth.infra;

import com.example.board.domain.auth.domain.entity.User;
import com.example.board.domain.auth.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<User, String>, UserRepository {

    @Override
    Optional<User> findByUsername(String username);

    @Override
    User save(User user);
}
