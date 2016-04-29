
package com.postman.service.message.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postman.model.StoreMessage;
import com.postman.producer.EventProducer;
import com.postman.service.message.MessageProcessorService;
import com.postman.service.message.enums.MessageType;

@Service
public class ErrorProcessorService implements MessageProcessorService {
	
	@Autowired
	private EventProducer eventProducer;

	@Override
	public void doProcessing(final MessageType messageType, final StoreMessage storeMessage) {
		eventProducer.sendMessage(Arrays.asList(storeMessage.toString()));
	}
}