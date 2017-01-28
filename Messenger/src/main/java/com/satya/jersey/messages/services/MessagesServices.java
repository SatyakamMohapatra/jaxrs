package com.satya.jersey.messages.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.satya.jersey.messages.dao.DatabaseClass;
import com.satya.jersey.messages.model.MessagesModel;

public class MessagesServices {
	
	private Map<Long, MessagesModel> messages=DatabaseClass.getMessages();
	
	public MessagesServices() {
		messages.put(1L,new MessagesModel(1L, "Hello World!", "satya"));
		messages.put(2L,new MessagesModel(2L, "Hello Jersey!", "satya"));
	}
	
	public List<MessagesModel> getAllMessages(){
		return new ArrayList<MessagesModel>(messages.values());
	}
	
	public MessagesModel getMessages(Long MessageID){
		return messages.get(MessageID);
	}
	
	public MessagesModel addMessages(MessagesModel messagesModel){
		messagesModel.setMessageID((long) (messages.size()+1));
		messagesModel.setMessageTime(new Date().toString());
		messages.put(messagesModel.getMessageID(), messagesModel);
		return messagesModel;
	}
	
	public MessagesModel updateMessages(MessagesModel messagesModel){
		if(messagesModel.getMessageID()<=0){
			return null;
		}
		messagesModel=messages.put(messagesModel.getMessageID(), messagesModel);
		return messagesModel;	
	}
	public MessagesModel deleteMessages(long messagesID){
		return messages.remove(messagesID);
	}
}
