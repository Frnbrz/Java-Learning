package com.fran.producto.service;


import com.fran.producto.model.entity.Producto;

import java.util.List;

public interface InterfaceProducto {

    List<Producto> findAll();

    Producto save(Producto producto);

    Producto findById(Integer idproducto);

    void delete(Integer idproducto);

    boolean existsById(Integer idproducto);

    Integer findMaxId();
}
