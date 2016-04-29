
package com.postman.service.message.impl;

import org.springframework.stereotype.Service;

import com.postman.model.StoreMessage;
import com.postman.service.message.MessageProcessorService;
import com.postman.service.message.enums.MessageType;

@Service
public class EventProcessorService implements MessageProcessorService {

	@Override
	public void doProcessing(final MessageType messageType, final StoreMessage storeMessage) {
		// TODO: Waiting OE Team to implement this feature in BCC side
	}
}