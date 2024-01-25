package com.fran.producto.service.impl;

import com.fran.producto.model.dao.ProductoDao;
import com.fran.producto.model.entity.Producto;
import com.fran.producto.service.InterfaceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoImpl implements InterfaceProducto {

    @Autowired
    private ProductoDao productoDao;

    @Transactional
    @Override
    public List<Producto> findAll() {
        return (List) productoDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findById(Integer idproducto) {
        return productoDao.findById(idproducto).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Integer idproducto) {
        productoDao.deleteById(idproducto);
    }

    @Override
    public boolean existsById(Integer idproducto) {
        return productoDao.existsById(idproducto);
    }

    @Transactional
    @Override
    public Producto save(Producto cliente) {

        return productoDao.save(cliente);
    }

    @Override
    public Integer findMaxId() {
        return productoDao.findMaxIdProducto();
    }
}
