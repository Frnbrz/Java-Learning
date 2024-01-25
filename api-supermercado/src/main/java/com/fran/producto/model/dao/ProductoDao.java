package com.fran.producto.model.dao;

import com.fran.producto.model.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Integer> {

    @Query("SELECT MAX(p.idproducto) FROM Producto p ")
    public Integer findMaxIdProducto();
}
