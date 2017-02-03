package com.satya.jersey.messages.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class MessagesModel {
	
	private Long MessageID;
	private String MessageBody;
	private String MessageAuthor;
	private Date MessageTime;
	@XmlTransient
	private Map<Long, CommentModel> comments = new HashMap<Long, CommentModel>();
	
	public MessagesModel() {
		// TODO Auto-generated constructor stub
	}
	
	public MessagesModel(Long messageID, String messageBody, String messageAuthor) {
		super();
		MessageID = messageID;
		MessageBody = messageBody;
		MessageAuthor = messageAuthor;
		MessageTime = new Date();
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

	public Date getMessageTime() {
		return MessageTime;
	}

	public void setMessageTime(Date messageTime) {
		MessageTime = messageTime;
	}
	@XmlTransient
	public Map<Long, CommentModel> getComments() {
		return comments;
	}

	public void setComments(Map<Long, CommentModel> comments) {
		this.comments = comments;
	}

	
	
}
