package com.fran.detalle.controller;

import com.fran.cliente.model.entity.Cliente;
import com.fran.detalle.model.entity.Detalle;
import com.fran.detalle.service.InterfaceDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DetalleController {

    private final String URL = "detalles";

    @Autowired
    private InterfaceDetalle interfaceDetalle;

    @PostMapping(URL)
    public Detalle create(@RequestBody Detalle detalle){
        return interfaceDetalle.save(detalle);
    }

    @PutMapping(URL)
    public Detalle update(@RequestBody Detalle detalle){
        return interfaceDetalle.save(detalle);
    }

    @DeleteMapping(URL+"/{idcliente}")
    public void delete(@PathVariable Integer id ){
        interfaceDetalle.delete(id);
    }

    @GetMapping(URL+"/{idcliente}")
    public Detalle getById(@PathVariable Integer id){
        return interfaceDetalle.findById(id);
    }

    @GetMapping(URL)
    public Iterable<Detalle> getAll(){
        return interfaceDetalle.findAll();
    }

}
