package com.charly.batch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charly.batch.entities.Cliente;
import com.charly.batch.persistence.IClienteDAO;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDAO clienteDAO;
	
	@Override
	public List<Cliente> saveAll(List<Cliente> clienteList) {
		
		return clienteDAO.saveAll(clienteList);
	}

}
