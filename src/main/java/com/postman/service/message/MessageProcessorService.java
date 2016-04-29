package com.postman.service.message;

import com.postman.model.StoreMessage;
import com.postman.service.message.enums.MessageType;

public interface MessageProcessorService {
	void doProcessing(MessageType messageType, StoreMessage storeMessage);
}