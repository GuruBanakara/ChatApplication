package com.gb.messagingwebsocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.gb.messagingwebsocket.model.MessageModel;

@Controller
public class ChatController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public MessageModel sendMessage(@Payload MessageModel model) {
		return model;

	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public MessageModel addUser(@Payload MessageModel model, SimpMessageHeaderAccessor accessor) {
		accessor.getSessionAttributes().put("username", model.getSender());
		return model;

	}
}
