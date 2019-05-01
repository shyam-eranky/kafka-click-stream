package com.shyam.clickstream;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shyam.clickstream.kafka.ClickSender;

@SpringBootApplication
public class ClickstreamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClickstreamApplication.class, args);
	}
	
	@Autowired
	private ClickSender clickSender;
	

	@Override
	public void run(String... args) throws Exception {
		Thread.sleep(1000);
		Click click = new Click();
		
		for(int i=1; i < 100; i++) {
			click.setSellerId("seller" + i);
			click.setBuyerId("buyer" + i);
			click.setItemId(2000L + i);
			click.setDevice("Chrome");
			click.setTimestamp(new Date());
			click.setSrcPage("Search");
			click.setDstPage("Product");
			
			clickSender.send(click);	
			Thread.sleep(25);
		}
		
	}
	

}
