package com.example.board.domain.user.service;

import com.example.board.domain.user.domain.TokenProvider;
import com.example.board.domain.user.domain.entity.User;
import com.example.board.domain.user.domain.repository.UserRepository;
import com.example.board.domain.user.dto.SignInRequest;
import com.example.board.domain.user.dto.SignInResponse;
import com.example.board.domain.user.dto.SignUpRequest;
import com.example.board.domain.user.exeptions.InvalidLoginInfoException;
import com.example.board.domain.user.exeptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenProvider tokenProvider;

    @Override
    @Transactional
    public void signUp(SignUpRequest signUpRequest) {
        Optional<User> user = userRepository.findById(signUpRequest.getUsername());

        if (user.isPresent()) {
            throw new UserAlreadyExistsException();
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

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.findById(signInRequest.getUsername())
                .orElseThrow(InvalidLoginInfoException::new); // 로그인 실패

        if (!user.isCorrectPassword(signInRequest.getPassword())) {
            throw new InvalidLoginInfoException();
        }

        String token = tokenProvider.generateToken(signInRequest.getUsername());
        return new SignInResponse(token);
    }
}
