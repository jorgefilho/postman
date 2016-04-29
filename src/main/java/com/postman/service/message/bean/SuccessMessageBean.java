package com.postman.service.message.bean;

import static com.postman.service.message.constants.BeanConstants.SUCCESS_BEAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.postman.service.message.impl.SuccessProcessorService;

@Component
public class SuccessMessageBean implements MessageBean {

	@Autowired
	private SuccessProcessorService successProcessorService;
	
	@Bean(name = SUCCESS_BEAN)
	public SuccessProcessorService processSuccess() {
		return this.successProcessorService;
	}
}