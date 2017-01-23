package com.satya.jersey.messages.services;

import java.util.ArrayList;
import java.util.List;

import com.satya.jersey.messages.model.MessagesModel;

public class MessagesServices {
	
	public List<MessagesModel> getAllMessages(){
		MessagesModel msg1  = new MessagesModel(1L, "Hello World!", "satya", "26/aug/2016");
		MessagesModel msg2  = new MessagesModel(1L, "Hello Jersey!", "satya", "22/jan/2017");
		List<MessagesModel> list = new ArrayList<MessagesModel>();
		list.add(msg1);
		list.add(msg2);
		return list;
	}
}
