package com.charly.batch.steps;

import java.nio.charset.StandardCharsets;

import org.springframework.batch.item.file.FlatFileItemReader;import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.charly.batch.entities.Cliente;

public class ClienteItemReader extends FlatFileItemReader<Cliente>{
	
	public ClienteItemReader() {
		setName("readClientes");
		setResource(new ClassPathResource("clientes.csv"));
		setLinesToSkip(1);
		setEncoding(StandardCharsets.UTF_8.name());
		setLineMapper(getLineMapper());
	} 
	
	public LineMapper<Cliente> getLineMapper() {
		
		DefaultLineMapper<Cliente > lineMapper = new DefaultLineMapper<>();
		
			DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		
				String[] columns = new String[] {"name","lastName","age"};
				int[] indexFields = new int[] {0,1,2};
				
				lineTokenizer.setNames(columns);
				lineTokenizer.setIncludedFields(indexFields);
				lineTokenizer.setDelimiter(",");
				
			BeanWrapperFieldSetMapper<Cliente>	fieldSetMapper = new BeanWrapperFieldSetMapper<>();
			fieldSetMapper.setTargetType(Cliente.class);
			
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		return lineMapper;
	}
}
