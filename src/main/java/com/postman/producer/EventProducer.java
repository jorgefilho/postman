package com.postman.producer;

import java.util.List;
import java.util.Objects;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class EventProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventProducer.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${hornetq.queue.input}")
	private String queueEventDestination;
	
	public void sendMessage(List<String> events){
		if (!CollectionUtils.isEmpty(events)){
			try{
				events.stream().filter(Objects::nonNull).forEach(message->{
					jmsTemplate.send(queueEventDestination, new MessageCreator() {
				        public Message createMessage(Session session) throws JMSException {
				        	final ObjectMessage objectMessage = session.createObjectMessage();
				        	objectMessage.setObject(message);
				            return objectMessage;
				        }
				    });
				});
			}catch (Exception e) {
				LOGGER.error("Trying to publish the message in the queue: {}  - {}", this.queueEventDestination,  e);
			}
		}
	}
}