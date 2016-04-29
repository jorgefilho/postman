package com.postman.service.message.bean;

import static com.postman.service.message.constants.BeanConstants.DEFAULT_BEAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.postman.service.message.impl.DefaultProcessorService;

@Component
public class DefaultMessageBean implements MessageBean {

	@Autowired
	private DefaultProcessorService defaultProcessorService;
	
	@Bean(name = DEFAULT_BEAN)
	public DefaultProcessorService processDefault() {
		return this.defaultProcessorService;
	}
}