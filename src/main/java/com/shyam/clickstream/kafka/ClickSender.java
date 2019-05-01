package com.shyam.clickstream.kafka;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.shyam.clickstream.Click;

@Service
public class ClickSender {

	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	private KafkaTemplate<String, Click> clickTemplate;
	
	@Value(value = "{clicks.topic.name}")
	private String clickTopic;
	
	public void send(Click click) {
		ListenableFuture<SendResult<String, Click>> future =  clickTemplate.send("clicks", click);
		future.addCallback(new ListenableFutureCallback<SendResult<String, Click>>() {

			@Override
			public void onSuccess(SendResult<String, Click> result) {
				logger.info("Topic="+ result.getRecordMetadata().topic() + 
						";Partition=" + result.getRecordMetadata().partition());
				
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.info(ex.getMessage());
			}
			
		});
	}
}
