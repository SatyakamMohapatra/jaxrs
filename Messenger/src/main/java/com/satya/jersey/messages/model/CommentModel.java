package com.satya.jersey.messages.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CommentModel {
	private Long   commentID;
	private String commentBody;
	private Date commentTime;
	private String commentAuthor;
	
	public CommentModel() {
	}
	
	public CommentModel(Long commentID, String commentBody, String commentAuthor) {
		super();
		this.commentID = commentID;
		this.commentBody = commentBody;
		this.commentTime = new Date();
		this.commentAuthor = commentAuthor;
	}



	public Long getCommentID() {
		return commentID;
	}
	public void setCommentID(Long commentID) {
		this.commentID = commentID;
	}
	public String getCommentBody() {
		return commentBody;
	}
	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentAuthor() {
		return commentAuthor;
	}
	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
	
	
}
