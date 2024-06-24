package com.charly.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.charly.batch.entities.Cliente;
import com.charly.batch.steps.ClienteItemProcessor;
import com.charly.batch.steps.ClienteItemReader;
import com.charly.batch.steps.ClienteItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public ClienteItemReader itemReader() {
		return new ClienteItemReader();
	}
	
	@Bean
	public ClienteItemProcessor itemProcessor() {
		return new ClienteItemProcessor();
	}
	
	
	@Bean
	public ClienteItemWriter itemWriter() {
		return new ClienteItemWriter();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(1);
		taskExecutor.setMaxPoolSize(5);
		taskExecutor.setQueueCapacity(5);
		
		return taskExecutor;
	}
	
	
	@Bean
	public Step readFile() {
		return stepBuilderFactory.get("readFile")
					.<Cliente, Cliente>chunk(10)
					.reader(itemReader())
					.processor(itemProcessor())
					.writer(itemWriter())
					.taskExecutor(taskExecutor())
					.build();
	}
	
	@Bean
	public Job job() {
		return jobBuilderFactory.get("readFileWithChunk")
				.start(readFile())
				.build();
	}
	
}
