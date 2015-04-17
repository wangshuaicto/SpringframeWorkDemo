package com.test.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
 
@Configuration
@ImportResource("classpath:/config/properties-config.xml")
public class DataSourceTest {
	@Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    
    public void print()
    {
    	System.out.println(this.url+" ; "+this.username+" ; "+this.password);
    }
}
