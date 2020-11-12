package com.example.board.domain.user.service;

import com.example.board.domain.user.domain.entity.User;
import com.example.board.domain.user.domain.repository.UserRepository;
import com.example.board.domain.user.domain.value.PrivateInfo;
import com.example.board.domain.user.dto.SignInRequest;
import com.example.board.domain.user.dto.SignInResponse;
import com.example.board.domain.user.dto.SignUpRequest;
import com.example.board.domain.user.exeptions.InvalidLoginInfoException;
import com.example.board.domain.user.exeptions.UserAlreadyExistsException;
import com.example.board.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider tokenProvider;

    @Override
    @Transactional
    public void signUp(SignUpRequest signUpRequest) {
        validateDuplicateUser(signUpRequest.getUsername());

        PrivateInfo privateInfo = PrivateInfo.builder()
                .age(signUpRequest.getAge())
                .name(signUpRequest.getName())
                .build();

        userRepository.save(
                User.builder()
                .username(signUpRequest.getUsername())
                .password(signUpRequest.getPassword())
                .privateInfo(privateInfo)
                .build()
        );
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.findByUsername(signInRequest.getUsername())
                .orElseThrow(InvalidLoginInfoException::new);

        if (!user.isCorrectPassword(signInRequest.getPassword())) {
            throw new InvalidLoginInfoException();
        }

        String token = tokenProvider.generateToken(signInRequest.getUsername());
        return new SignInResponse(token);
    }

    private void validateDuplicateUser(String username) {
        userRepository.findByUsername(username)
                .ifPresent(user -> {
                    throw new UserAlreadyExistsException();
                });
    }
}
