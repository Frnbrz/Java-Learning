package com.fran.cliente.service.impl;

import com.fran.cliente.model.dao.ClienteDao;
import com.fran.cliente.model.entity.Cliente;
import com.fran.cliente.service.InterfaceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteImpl implements InterfaceCliente {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }
    @Transactional(readOnly = true)
    @Override
    public Cliente findByCia(String cia) {
        System.out.println("cia: "+cia);
        Cliente cliente = clienteDao.findById(cia).orElse(null);
        System.out.println("cliente: "+cliente);
        return clienteDao.findById(cia).orElse(null);
    }
    @Transactional
    @Override
    public void delete(String idcliente) {
        clienteDao.deleteById(idcliente);
    }

    @Override
    public boolean existsById(String idcliente) {
        return clienteDao.existsById(idcliente);
    }
}
