package com.satya.jersey.messages.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MessageNotFoundExcpetionMapper implements ExceptionMapper<MessageNotFoundException> {

	@Override
	public Response toResponse(MessageNotFoundException exp) {
		ErrorMessage message = new ErrorMessage(exp.getMessage(),404,"www.google.com");
		return Response.status(Status.NOT_FOUND).entity(message).build();
	}

}
