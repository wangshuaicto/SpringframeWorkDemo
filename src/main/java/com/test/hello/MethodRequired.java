package com.test.hello;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
@Configuration
public class MethodRequired {
	public String name="2";
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	public void dowork()
	{
		System.out.println(this.name);
	}
	
	@Bean(name="methodrequired")
	public MethodRequired getMethodRequired()
	{
		return new MethodRequired();
	}
}
