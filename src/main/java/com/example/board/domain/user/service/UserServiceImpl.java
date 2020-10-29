package com.example.board.domain.user.service;

import com.example.board.domain.user.domain.entity.User;
import com.example.board.domain.user.domain.repository.UserRepository;
import com.example.board.domain.user.dto.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void signUp(SignUpRequest signUpRequest) {
        User user = userRepository.findById(signUpRequest.getUsername());
        if (user != null) {
            throw new IllegalArgumentException("유저네임 중복");
            // TODO 유저네임 중복 예외
        }
        userRepository.save(
                User.builder()
                .username(signUpRequest.getUsername())
                .password(signUpRequest.getPassword())
                .age(signUpRequest.getAge())
                .name(signUpRequest.getName())
                .build()
        );
    }
}
