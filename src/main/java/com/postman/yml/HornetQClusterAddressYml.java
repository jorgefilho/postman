package com.postman.yml;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "hornetq.cluster")
public class HornetQClusterAddressYml implements Serializable {

	private static final long serialVersionUID = 1L;

	private String host;
	private String port;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "HornetQClusterAddressYml [host=" + host + ", port=" + port + "]";
	}
}
