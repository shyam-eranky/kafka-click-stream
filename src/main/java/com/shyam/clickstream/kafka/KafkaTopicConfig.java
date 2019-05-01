package com.shyam.clickstream.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {
	
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;
	
	@Value(value = "${clicks.topic.name}")
	private String clicksTopic;

	@Value(value = "${impr.topic.name}")
	private String imprTopic;	
	
	@Bean
	public KafkaAdmin admin() {
		Map<String, Object> configs = new HashMap<String, Object>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		return new KafkaAdmin(configs);
	}
	
	@Bean
	public NewTopic clicksTopic() {
		return new NewTopic(clicksTopic,2,(short)2);
	}

	@Bean
	public NewTopic imprTopic() {
		return new NewTopic(imprTopic,4,(short)2);
	}

}
