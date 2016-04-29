package com.postman.service.message.bean;

import static com.postman.service.message.constants.BeanConstants.ERROR_BEAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.postman.service.message.impl.ErrorProcessorService;

@Component
public class ErrorMessageBean implements MessageBean {

	@Autowired
	private ErrorProcessorService errorProcessorService;
	
	@Bean(name = ERROR_BEAN)
	public ErrorProcessorService processError() {
		return this.errorProcessorService;
	}
}