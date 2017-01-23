package com.satya.jersey.messages.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessagesModel {
	
	private Long MessageID;
	private String MessageBody;
	private String MessageAuthor;
	private String MessageTime;
	
	public MessagesModel() {
		// TODO Auto-generated constructor stub
	}
	
	public MessagesModel(Long messageID, String messageBody, String messageAuthor, String messageTime) {
		super();
		MessageID = messageID;
		MessageBody = messageBody;
		MessageAuthor = messageAuthor;
		MessageTime = messageTime;
	}
	public Long getMessageID() {
		return MessageID;
	}
	public void setMessageID(Long messageID) {
		MessageID = messageID;
	}
	public String getMessageBody() {
		return MessageBody;
	}
	public void setMessageBody(String messageBody) {
		MessageBody = messageBody;
	}
	public String getMessageAuthor() {
		return MessageAuthor;
	}
	public void setMessageAuthor(String messageAuthor) {
		MessageAuthor = messageAuthor;
	}
	public String getMessageTime() {
		return MessageTime;
	}
	public void setMessageTime(String messageTime) {
		MessageTime = messageTime;
	}
	
	
}
