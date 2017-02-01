package com.satya.jersey.messages.exception;

import java.util.StringTokenizer;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionHandlerMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exp) {
		
		StringTokenizer tokenizer = new StringTokenizer(exp.getMessage(), " ");
		Integer errorCode = null;
		while(tokenizer.hasMoreTokens()){
			try {
			    errorCode = Integer.parseInt(tokenizer.nextToken());
			}catch (NumberFormatException e) {}	
		}
		ErrorMessage message = new ErrorMessage(exp.getMessage(),errorCode,"www.google.com");
		return Response.status(errorCode).entity(message).build();
	}

}
