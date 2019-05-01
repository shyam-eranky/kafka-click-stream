package com.shyam.clickstream.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.shyam.clickstream.Click;

@Service
public class ClickReceiver {
	private static final Logger logger = LogManager.getLogger();

	
	@KafkaListener(topics="clicks",containerFactory="kafkaListenerContainerFactory")
	public void listener(Click click,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.CONSUMER) KafkaConsumer<String, Click> cons) {
		logger.info("Partition:" + partition + "Msg:" + click);
	}

}
