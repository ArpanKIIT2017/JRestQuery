package com.frame.JRestFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackages = "com.frame")
@SpringBootApplication
public class JRestFrameApplication {

	public static void main(String[] args)
        {
            SpringApplication.run(JRestFrameApplication.class, args);
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 
            CustomResourceLoader customResourceLoader = (CustomResourceLoader) context.getBean("customResourceLoader");
	}
}
