package com.satya.jersey.messages;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.satya.jersey.messages.model.CommentModel;
import com.satya.jersey.messages.services.CommentsServices;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResources {
	
	CommentsServices comments = new CommentsServices();
	
	@GET
	public List<CommentModel> getAllComments(@PathParam("messagesID") Long messagesID){
		return comments.getAllComments(messagesID);
	}
	
	@GET
	@Path("/{commentID}")
	public CommentModel getComment(@PathParam("messagesID") Long messagesID,
			                       @PathParam("commentID") Long commentID){	
		return comments.getSingleComment(messagesID, commentID);
	}
	
	@POST
	public CommentModel addComment(@PathParam("messagesID") Long messagesID,CommentModel comment){
		return comments.AddComment(messagesID, comment);
	}
	@PUT
	@Path("/{commentID}")
	public CommentModel updateComment(@PathParam("messagesID") Long messagesID,
									  @PathParam("commentID") Long commentID,CommentModel comment){
		comment.setCommentID(commentID);
		return comments.updateComments(messagesID, comment);
	}
	public CommentModel deleteComment(@PathParam("messagesID") Long messagesID,
									  @PathParam("commentID") Long commentID) {
	    return comments.deleteComments(messagesID, commentID);		
	}
}
