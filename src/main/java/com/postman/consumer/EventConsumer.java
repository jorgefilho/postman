package com.postman.consumer;

import javax.jms.JMSException;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(EventConsumer.class);

	@JmsListener(destination = "${hornetq.queue.event}")
	public void receiveMessage(final Message message) throws JMSException  {
		LOGGER.info(message.toString());
		// TODO : Waiting OE Team to Implement this feature
	}
}