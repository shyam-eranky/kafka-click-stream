package com.shyam.clickstream.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.shyam.clickstream.Click;

@Configuration
@EnableKafka
public class ClickReceiverConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;
	@Value(value = "${consumer.click.groupid}")
	private String clickGroupId;

	@Bean
	public Map<String, Object> consumerConfigs(){
		Map<String, Object> configs = new HashMap<String, Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		System.out.println("$$$$$$$$clickgroupid=" + clickGroupId );
		configs.put(ConsumerConfig.GROUP_ID_CONFIG,clickGroupId);
		//configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		//configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return configs;
	}
	
	@Bean
	public ConsumerFactory<String, Click> consumerFactory() {
		return new DefaultKafkaConsumerFactory<String, Click>(consumerConfigs(),new StringDeserializer(),new JsonDeserializer<>(Click.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Click> kafkaListenerContainerFactory() {
  
      ConcurrentKafkaListenerContainerFactory<String, Click> factory
        = new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory());
      factory.setConcurrency(2);
      return factory;
  }
	
}
