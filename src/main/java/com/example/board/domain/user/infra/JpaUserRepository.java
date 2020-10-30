package com.example.board.domain.user.infra;

import com.example.board.domain.user.domain.entity.User;
import com.example.board.domain.user.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findById(String username) {
        User user = entityManager.find(User.class, username);
        return Optional.ofNullable(user);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
