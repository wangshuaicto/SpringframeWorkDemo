package com.test.hello;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.test.hello.aoptest.AopTest;

@Configuration
@ComponentScan(basePackageClasses={Application.class,AopTest.class})
@EnableAspectJAutoProxy
public class Application {
	@Bean(name="test")
	MessageService mockMessageService() {
		return new MessageService() {

			public String getMessage() {
				// TODO Auto-generated method stub
				return "Hello World !";
			}
		};
	}
	
	@Bean(name="testone")
	@Description("What this will display!!!")
	MessageService getMessageService()
	{
		return new MessageService() {
			
			public String getMessage() {
				// TODO Auto-generated method stub
				return "It is Work!";
			}
		};
	}
	/**
	 * 
	 * @Bean注解到方法上如果不设置name属性,那么默认会用方法名作为name属性
	 * 同时DataSourceTest也会有一个默认的类名的属性
	 * 
	 */
	@Bean
	DataSourceTest getDataSourceTest()
	{
		return new DataSourceTest();
	}
	
	
	
	// Main方法
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				Application.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage("100");
		
		
		
		/**
			String[]names= context.getBeanDefinitionNames();
			System.out.println("============================");
			for (String name : names) {
				System.out.println(name);
			}
			System.out.println("============================");
		*/
		
		MessageService service = (MessageService) context.getBean("test");
		System.out.println(service.getMessage());
		
		MethodRequired required = (MethodRequired) context.getBean("methodrequired");
		required.dowork();
		
		DataSourceTest datastest = (DataSourceTest) context.getBean("dataSourceTest");
		datastest.print();
		
		AppPropertites app = (AppPropertites) context.getBean("appPropertites");
		app.print();
		
		AppDefaultPropertites app1 = (AppDefaultPropertites) context.getBean("appDefaultPropertites");
		app1.print();
		
		context.close();
		try {
		InputStream defclas = Application.class.getResourceAsStream("/config/app.properties");
		Properties p = new Properties();
		
			p.load(defclas);
			System.out.println(p.getProperty("testbean.name"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
