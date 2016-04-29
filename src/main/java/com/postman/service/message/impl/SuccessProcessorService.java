
package com.postman.service.message.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.postman.model.StoreMessage;
import com.postman.service.message.MessageProcessorService;
import com.postman.service.message.enums.MessageType;

@Service
public class SuccessProcessorService implements MessageProcessorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SuccessProcessorService.class);

	@Override
	public void doProcessing(final MessageType messageType, final StoreMessage storeMessage) {
		LOGGER.info(storeMessage.toString());
	}
}