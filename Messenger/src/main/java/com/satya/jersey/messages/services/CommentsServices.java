package com.satya.jersey.messages.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;

import com.satya.jersey.messages.dao.DatabaseClass;
import com.satya.jersey.messages.model.CommentModel;
import com.satya.jersey.messages.model.MessagesModel;

public class CommentsServices {
	
	private Map<Long, MessagesModel> messages = DatabaseClass.getMessages();
	
	public CommentsServices() {
	}
	
	public List<CommentModel> getAllComments(Long messagesID){
		Map<Long,CommentModel> comments = messages.get(messagesID).getComments();
		return new ArrayList<>(comments.values());
	}
	
	public CommentModel getSingleComment(Long messagesID,Long commentID){
		return messages.get(messagesID).getComments().get(commentID);
	}
	
	public CommentModel AddComment(Long messagesID,CommentModel commentModel){
		Map<Long, CommentModel> comments = messages.get(messagesID).getComments();
		
		commentModel.setCommentID((long) (comments.size()+1));
		commentModel.setCommentTime(new Date());
		comments.put(commentModel.getCommentID(), commentModel);
		return comments.get(commentModel.getCommentID());
	}
	
	public CommentModel updateComments(Long messagesID,CommentModel commentModel){
		if(commentModel.getCommentID()<=0) return null;
		Map<Long, CommentModel> comments = messages.get(messagesID).getComments();
		commentModel.setCommentTime(comments.get(commentModel.getCommentID()).getCommentTime());
		comments.put(commentModel.getCommentID(), commentModel);
		return comments.get(commentModel.getCommentID());
	}
	
	public CommentModel deleteComments(Long messagesID,Long commentID){
		Map<Long, CommentModel> comments = messages.get(messagesID).getComments();
		return comments.remove(commentID);
	}
	
}
