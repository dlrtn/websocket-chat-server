package com.dlrtn.websocket.chat.business.chat.model.payload;

import com.dlrtn.websocket.chat.business.chat.model.domain.ChatRoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Builder
@Getter
public class CreateChatRoomRequest {

    @NotBlank
    private final String name;

    @NotBlank
    private final ChatRoomType chatRoomType;

    @NotBlank
    private final String chatRoomPassword;

}
