package com.test.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class MyController {
	
	@RequestMapping("/test")
	public void helloworld(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("----------");
	}
}
