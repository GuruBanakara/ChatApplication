package com.gb.messagingwebsocket.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.gb.messagingwebsocket.model.MessageModel;
import com.gb.messagingwebsocket.model.MessageModel.MessageType;

@Component
public class WebSocketEventListener {

	@Autowired
	private SimpMessageSendingOperations operations;

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

		String username = (String) accessor.getSessionAttributes().get("username");
		if (username != null) {
			MessageModel model = new MessageModel();
			model.setType(MessageType.LEAVE);
			model.setSender(username);

			operations.convertAndSend("/topic", model);
		}
	}
}
