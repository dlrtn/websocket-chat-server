package com.dlrtn.websocket.chat.business.user.model.payload;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class WithdrawUserRequest {

    @NotBlank
    private String password;

}
