package com.fran.cliente.controller;

import com.fran.cliente.service.InterfaceCliente;
import com.fran.cliente.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    private final String URL = "clientes";

    @Autowired
    private InterfaceCliente interfaceCliente;

    @PostMapping(URL)
    public Cliente create(@RequestBody Cliente cliente){
        return interfaceCliente.save(cliente);
    }

    @PutMapping(URL)
    public Cliente update(@RequestBody Cliente cliente){
        return interfaceCliente.save(cliente);
    }

    @DeleteMapping(URL+"/{idcliente}")
    public void delete(@PathVariable String idcliente){
        interfaceCliente.delete(idcliente);
    }

    @GetMapping(URL+"/{idcliente}")
    public Cliente getById(@PathVariable String idcliente){
        Cliente cliente = interfaceCliente.findByCia(idcliente);
        System.out.println("cliente: "+cliente);
        return interfaceCliente.findByCia(idcliente);
    }

    @GetMapping(URL)
    public Iterable<Cliente> getAll(){
        return interfaceCliente.findAll();
    }

}
