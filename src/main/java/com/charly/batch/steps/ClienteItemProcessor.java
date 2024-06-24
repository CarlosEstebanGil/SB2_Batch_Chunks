package com.charly.batch.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;

import com.charly.batch.entities.Cliente;

public class ClienteItemProcessor implements ItemProcessor<Cliente, Cliente> {

	@Override
	public Cliente process(Cliente cliente) throws Exception {
	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		
		cliente.setCreateAt(formatter.format(date));
		
		return cliente;
	}

	
}
