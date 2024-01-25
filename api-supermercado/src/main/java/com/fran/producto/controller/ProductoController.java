package com.fran.producto.controller;

import com.fran.producto.model.entity.Producto;
import com.fran.producto.service.InterfaceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {

    private final String URL = "productos";

    @Autowired
    private InterfaceProducto interfaceProducto;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(URL)
    public Producto create(@RequestBody Producto producto){
        Integer id = interfaceProducto.findMaxId();
        producto.setIdproducto(id+1);
        return interfaceProducto.save(producto);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping(URL)
    public Producto update(@RequestBody Producto producto){
        return interfaceProducto.save(producto);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping(URL+"/{idproducto}")
    public void delete(@PathVariable Integer idproducto){
        interfaceProducto.delete(idproducto);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(URL+"/{idproducto}")
    public Producto getById(@PathVariable Integer idproducto){
        return interfaceProducto.findById(idproducto);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(URL)
    public Iterable<Producto> getAll(){
        return interfaceProducto.findAll();
    }

}
