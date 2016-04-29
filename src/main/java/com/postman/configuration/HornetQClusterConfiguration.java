package com.postman.configuration;

import static org.hornetq.api.jms.HornetQJMSClient.createConnectionFactoryWithoutHA;
import static org.hornetq.core.remoting.impl.netty.TransportConstants.HOST_PROP_NAME;
import static org.hornetq.core.remoting.impl.netty.TransportConstants.PORT_PROP_NAME;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.JMSFactoryType;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;
import org.hornetq.jms.client.HornetQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import com.postman.yml.HornetQClusterAddressYml;
import com.postman.yml.HornetQYml;

@EnableJms
@Configuration
public class HornetQClusterConfiguration {

	@Autowired
	private HornetQYml hornetQProperties;
	
	@Bean
	public HornetQConnectionFactory hornetQConnectionFactory() {
		final List<TransportConfiguration> configurations = new ArrayList<>();
		
		for (final HornetQClusterAddressYml address : hornetQProperties.getCluster()) {
			final Map<String, Object> connectionParam = new HashMap<>();
			connectionParam.put(HOST_PROP_NAME, address.getHost());
			connectionParam.put(PORT_PROP_NAME, address.getPort());
			configurations.add(new TransportConfiguration(NettyConnectorFactory.class.getName(), connectionParam ));
		}
		
		final HornetQConnectionFactory connectionFactory = createConnectionFactoryWithoutHA(JMSFactoryType.CF, getTransportConfiguration(configurations));
		return connectionFactory;
	}

	private TransportConfiguration[] getTransportConfiguration(final List<TransportConfiguration> configurations) {
		return (TransportConfiguration[]) configurations.toArray(new TransportConfiguration[hornetQProperties.getCluster().size()]);
	}
}