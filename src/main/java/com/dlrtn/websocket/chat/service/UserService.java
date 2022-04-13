package com.dlrtn.websocket.chat.service;

import com.dlrtn.websocket.chat.mapper.UserMapper;
import com.dlrtn.websocket.chat.model.domain.User;
import com.dlrtn.websocket.chat.model.domain.dto.SignInRequest;
import com.dlrtn.websocket.chat.model.domain.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    @Transactional
    public void signUp(SignUpRequest request) {
        userMapper.save(joinUser(request));
    }

    public User signIn(SignInRequest request) {
        return userMapper.login(findUser(request));
    }

    public User findUser(SignInRequest request) {
        return User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .build();
    }

    public User joinUser(SignUpRequest request) {
        LocalDateTime now = LocalDateTime.now();

        return User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .realName(request.getRealName())
                .authRole(request.getAuthRole())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }

}
