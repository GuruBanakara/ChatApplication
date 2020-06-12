package com.gb.messagingwebsocket.model;

public class MessageModel {

	public enum MessageType {

		JOIN, CHAT, LEAVE
	}

	private MessageType type;
	private String sender;
	private String content;

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
