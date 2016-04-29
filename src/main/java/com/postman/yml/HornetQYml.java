package com.postman.yml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "hornetq")
public class HornetQYml implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<HornetQClusterAddressYml> cluster = new ArrayList<>();

	public List<HornetQClusterAddressYml> getCluster() {
		return cluster;
	}

	public void setCluster(List<HornetQClusterAddressYml> cluster) {
		this.cluster = cluster;
	}

	@Override
	public String toString() {
		return "HornetQYml [cluster=" + cluster + "]";
	}
}
