package com.test.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	final private MessageService service;
	 
	@Autowired 
	public MessagePrinter(@Qualifier("testone")MessageService service)
	{
		this.service=service;
	}
	public void printMessage(String name)
	{
		System.out.println(this.service.getMessage());
	}
}
