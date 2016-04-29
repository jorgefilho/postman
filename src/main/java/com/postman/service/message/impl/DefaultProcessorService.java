package com.postman.service.message.impl;

import org.springframework.stereotype.Service;

import com.postman.model.StoreMessage;
import com.postman.service.message.MessageProcessorService;
import com.postman.service.message.enums.MessageType;

@Service
public class DefaultProcessorService implements MessageProcessorService {
	@Override
	public void doProcessing(MessageType messageType, StoreMessage storeMessage) {
		// TODO Auto-generated method stub
		
	}
}