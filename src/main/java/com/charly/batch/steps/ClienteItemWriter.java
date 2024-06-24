package com.charly.batch.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.charly.batch.entities.Cliente;
import com.charly.batch.service.IClienteService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ClienteItemWriter implements ItemWriter<Cliente> {

	@Autowired
	private IClienteService clienteService;
	
	@Override
	public void write(List<? extends Cliente> list) throws Exception {
		
		list.forEach( cliente -> cliente.toString());
		
		clienteService.saveAll( (List<Cliente>) list);
		
	}

}
