package com.postman.service.message.bean;

import static com.postman.service.message.constants.BeanConstants.EVENT_BEAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.postman.service.message.impl.EventProcessorService;

@Component
public class EventMessageBean implements MessageBean {

	@Autowired
	private EventProcessorService eventProcessorService;
	
	@Bean(name = EVENT_BEAN)
	public EventProcessorService processEvent() {
		return this.eventProcessorService;
	}
}