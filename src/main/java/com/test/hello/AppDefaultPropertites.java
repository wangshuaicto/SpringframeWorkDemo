package com.test.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
 
@Configuration
//classpath:/com/${my.placeholder:default/path}/app.properties
@Import(AppPropertites.class)
@PropertySource("classpath:/${my.apppath:config}/app1.properties")
public class AppDefaultPropertites {
	@Value("${test1}")
	public String test;
	
	public void print()
	{
		System.out.println(this.test);
	}
}
