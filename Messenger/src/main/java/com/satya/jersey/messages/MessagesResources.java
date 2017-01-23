package com.satya.jersey.messages;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.satya.jersey.messages.model.MessagesModel;
import com.satya.jersey.messages.services.MessagesServices;

@Path("/messages")
public class MessagesResources {

	private MessagesServices services;
	
    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<MessagesModel> getXMLMesages() {
    	services = new MessagesServices();
        return services.getAllMessages();
    }
}
