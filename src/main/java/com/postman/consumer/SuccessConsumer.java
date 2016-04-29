package com.postman.consumer;

import static org.springframework.util.StringUtils.isEmpty;

import javax.jms.JMSException;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.postman.consumer.helper.StoreMessageHelper;
import com.postman.model.StoreMessage;
import com.postman.service.PostmanService;
import com.postman.service.message.enums.MessageType;

@Component
public class SuccessConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(SuccessConsumer.class);

	@Autowired
	private PostmanService postmanService;
	
	@Autowired
	private StoreMessageHelper storeMessageUtil;

	@JmsListener(destination = "${hornetq.queue.success}")
	public void receiveMessage(final Message message) throws JMSException  {
		LOGGER.debug(message.toString());
		
		final StoreMessage storeMessage = storeMessageUtil.toBean(message);
		
		LOGGER.debug(storeMessage.toString());
		
		if (isEmpty(storeMessage.getEntityType())){
			this.postmanService.process(MessageType.DEFAULT, storeMessage);
		}else {
			this.postmanService.process(MessageType.SUCCESS, storeMessage);
		}
	}
}