package com.postman.consumer.helper;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.postman.model.StoreMessage;

@Component
public class StoreMessageHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(StoreMessageHelper.class);
	
	public StoreMessage toBean(Message message) {
		StoreMessage jsonMessage = null;
		try {
			if (message instanceof TextMessage) {
				final String textMessage = ((TextMessage) message).getText();
				LOGGER.info("NSI-PMAN - Store Message: "+ textMessage);
				
				jsonMessage = new Gson().fromJson(textMessage, StoreMessage.class);
			} else {
				LOGGER.error("NSI-PMAN-001 - Unexpected message type on ATG queue of success/error. JMSType: {}", message.getJMSType());
			}
		} catch (JsonSyntaxException e) {
			LOGGER.error("NSI-PMAN-002 - Store Message is with wrong json format. Cause: {}", e.getMessage());
		} catch (JMSException e) {
			LOGGER.error("NSI-PMAN-003 - Store Message is with wrong javax.jms.TextMessage type. Cause: {}", e.getMessage());
		}
		return jsonMessage;
	}
}