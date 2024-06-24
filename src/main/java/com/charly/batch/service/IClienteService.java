package com.charly.batch.service;

import java.util.List;

import com.charly.batch.entities.Cliente;

public interface IClienteService {

	List<Cliente> saveAll(List<Cliente> clienteList);
}
