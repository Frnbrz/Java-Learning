package com.fran.pedido.controller;

import com.fran.pedido.model.entity.Pedido;
import com.fran.pedido.service.InterfacePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PedidoController {

    private final String URL = "pedidos";

    @Autowired
    private InterfacePedido interfacePedido;

    @PostMapping(URL)
    public Pedido create(@RequestBody Pedido pedido){
        return interfacePedido.save(pedido);
    }

    @PutMapping(URL)
    public Pedido update(@RequestBody Pedido pedido){
        return interfacePedido.save(pedido);
    }

    @DeleteMapping(URL+"/{idcliente}")
    public void delete(@PathVariable Integer idpedido){
        interfacePedido.delete(idpedido);
    }

    @GetMapping(URL+"/{idcliente}")
    public Pedido getById(@PathVariable Integer idpedido){
        return interfacePedido.findById(idpedido);
    }

    @GetMapping(URL)
    public Iterable<Pedido> getAll(){
        return interfacePedido.findAll();
    }

}
