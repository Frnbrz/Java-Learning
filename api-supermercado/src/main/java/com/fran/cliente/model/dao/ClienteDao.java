package com.fran.cliente.model.dao;

import com.fran.cliente.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, String> {
}
