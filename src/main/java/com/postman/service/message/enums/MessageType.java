package com.postman.service.message.enums;

import static com.postman.service.message.constants.BeanConstants.DEFAULT_BEAN;
import static com.postman.service.message.constants.BeanConstants.ERROR_BEAN;
import static com.postman.service.message.constants.BeanConstants.EVENT_BEAN;
import static com.postman.service.message.constants.BeanConstants.SUCCESS_BEAN;

public enum MessageType {
	
	ERROR(ERROR_BEAN),
	EVENT(EVENT_BEAN),
	SUCCESS(SUCCESS_BEAN),
	DEFAULT(DEFAULT_BEAN);
	
	private String beanName;

	private MessageType(final String beanName) {
		this.beanName = beanName;
	}
	public String getBeanName() {
		return beanName;
	}
}