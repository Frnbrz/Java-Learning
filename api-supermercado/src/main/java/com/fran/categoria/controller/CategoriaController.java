package com.fran.categoria.controller;

import com.fran.categoria.model.entity.Categoria;
import com.fran.categoria.service.InterfaceCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {

    private final String URL = "categorias";

    @Autowired
    private InterfaceCategoria interfaceCategoria;

    @PostMapping(URL)
    public Categoria create(@RequestBody Categoria categoria){
        return interfaceCategoria.save(categoria);
    }

    @PutMapping(URL)
    public Categoria update(@RequestBody Categoria categoria){
        return interfaceCategoria.save(categoria);
    }

    @DeleteMapping(URL+"/{idcategoria}")
    public void delete(@PathVariable Integer idcategoria){
        interfaceCategoria.delete(idcategoria);
    }

    @GetMapping(URL+"/{idcategoria}")
    public Categoria getById(@PathVariable Integer idcategoria){
        return interfaceCategoria.findById(idcategoria);
    }

    @GetMapping(URL)
    public Iterable<Categoria> getAll(){
        return interfaceCategoria.findAll();
    }

}
