package com.satya.jersey.messages;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.satya.jersey.messages.model.MessagesModel;
import com.satya.jersey.messages.services.MessagesServices;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessagesResources {

	MessagesServices services =new MessagesServices();
	
    @GET
    public List<MessagesModel> getXMLMesages() {
        return services.getAllMessages();
    }
    
    @GET
    @Path("/{messagesID}")
    public MessagesModel getMessageByID(@PathParam("messagesID") Long messagesID){
    	System.out.println("recived id is "+messagesID);
		return services.getMessages(messagesID);
    }
    
    @POST
    public MessagesModel addMessage(MessagesModel messagesModel){
    	return services.addMessages(messagesModel);
    }
    
    @PUT
    @Path("/{messagesID}")
    public MessagesModel updateMessages(@PathParam("messagesID") Long messagesID,MessagesModel messagesModel){
    	messagesModel.setMessageID(messagesID);
    	messagesModel.setMessageTime(new Date().toString());
    	return services.updateMessages(messagesModel);
    }
    
    @DELETE
    @Path("/{messagesID}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteMessages(@PathParam("messagesID") Long messagesID){
    	MessagesModel messagesModel = services.deleteMessages(messagesID);
    	if(messagesModel != null ){
    		return "Id "+messagesID+" Found and deleted sucessfully";
    	}else{
    		return "Id "+messagesID+" Not Found";
    	}	
    }
    
}
