package com.async.runner;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.async.config.AppConfig;
import com.async.manager.AsyncManager;
public class AppTest {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		AsyncManager task= ctx.getBean(AsyncManager.class);
		task.doAsyncTask();
	}
}