package com.fran.cliente.service;

import com.fran.cliente.model.entity.Cliente;

import java.util.List;

public interface InterfaceCliente {

    List<Cliente> findAll();

    Cliente save(Cliente cliente);

    Cliente findByCia(String idcliente);

    void delete(String idcliente);

    boolean existsById(String idcliente);
}
