package com.charly.batch.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charly.batch.entities.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Long> {

	
}
