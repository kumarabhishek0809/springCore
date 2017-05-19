package com.async.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.async.executor.AsyncExecutor;
import com.async.manager.AsyncManager;

@Configuration
@EnableAsync
@ComponentScan("com.async")
public class AppConfig {
	@Bean
	public AsyncManager asyncManger() {
		return new AsyncManager();
	}
	
	@Bean
	public AsyncExecutor asyncExecutor() {
		return new AsyncExecutor();
	}
	
}