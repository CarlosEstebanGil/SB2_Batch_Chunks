package com.charly.batch.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ApplicationConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManager= new DriverManagerDataSource();
		driverManager.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManager.setUrl("jdbc:mysql://localhost:3306/SB2_batch_Chunk");
		driverManager.setUsername("root");
		driverManager.setPassword("root");
		
		return driverManager;
	}
}
