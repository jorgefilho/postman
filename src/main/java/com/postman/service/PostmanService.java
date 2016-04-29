package com.postman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postman.factory.ProcessorFactory;
import com.postman.model.StoreMessage;
import com.postman.service.message.enums.MessageType;

@Service
public class PostmanService {
	
	@Autowired
	private ProcessorFactory processorFactory;
	
	public void process(final MessageType type, final StoreMessage storeMessage)  {
		processorFactory.process(type, storeMessage);
	}
}