package com.test.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
 
@Configuration
@PropertySource("classpath:/config/app.properties")
public class AppPropertites {
	@Value("${testbean.name}")
	public String testbeanName;
	
	public void print()
	{
		System.out.println(this.testbeanName);
	}
}
