package com.example.board.domain.user.infra;

import com.example.board.domain.user.domain.entity.User;
import com.example.board.domain.user.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
