package br.com.test.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessageModel {
    private MessageType type;
    private String from;
    private String message;

    public enum MessageType {USER_JOINED, USER_LEFT, CHAT_MESSAGE}
}
