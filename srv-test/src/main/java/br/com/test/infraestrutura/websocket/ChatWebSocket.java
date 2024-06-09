package br.com.test.infraestrutura.websocket;

import br.com.test.domain.model.ChatMessageModel;
import io.quarkus.websockets.next.*;
import jakarta.inject.Inject;

//Acessar em http://localhost:8080
@WebSocket(path = "/chat/{username}")
public class ChatWebSocket {

    @Inject
    WebSocketConnection connection;

    @OnOpen(broadcast = true)
    public ChatMessageModel onOpen() {
        return new ChatMessageModel(ChatMessageModel.MessageType.USER_JOINED, connection.pathParam("username"), null);
    }

    @OnClose
    public void onClose() {
        ChatMessageModel departure = new ChatMessageModel(ChatMessageModel.MessageType.USER_LEFT, connection.pathParam("username"), null);
        connection.broadcast().sendTextAndAwait(departure);
    }

    @OnTextMessage(broadcast = true)
    public ChatMessageModel onMessage(ChatMessageModel message) {
        return message;
    }

}
