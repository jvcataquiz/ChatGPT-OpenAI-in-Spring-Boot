package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

//@SpringBootApplication(scanBasePackages = {"controller","repository","service","entity","mapper"})
//@EnableFeignClients(basePackages= {"x.xx"})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

@SpringBootApplication
@ComponentScan(value = "com.example.demo")
public class TryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TryDemoApplication.class, args);
		System.out.println("Hellooo Started");
	}

}
