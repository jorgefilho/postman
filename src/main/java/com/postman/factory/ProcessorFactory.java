package com.postman.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.postman.model.StoreMessage;
import com.postman.service.message.MessageProcessorService;
import com.postman.service.message.enums.MessageType;

@Component
public class ProcessorFactory {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ProcessorFactory.class);

	@Autowired
    private ApplicationContext context;
	
	public void process(final MessageType messageType, final StoreMessage storeMessage) {
		try{
			final MessageProcessorService service = (MessageProcessorService) context.getBean(messageType.getBeanName());
			service.doProcessing(messageType, storeMessage);
		}catch (Exception e){
			LOGGER.error("Processor Factory tried to call a Service Undefined: {}", e.getMessage() );
		}
	}
}