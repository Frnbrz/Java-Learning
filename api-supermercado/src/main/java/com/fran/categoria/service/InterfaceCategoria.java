package com.fran.categoria.service;


import com.fran.categoria.model.entity.Categoria;

import java.util.List;

public interface InterfaceCategoria {

    List<Categoria> findAll();

    Categoria save(Categoria categoria);

    Categoria findById(Integer idcategoria);

    void delete(Integer idcategoria);

    boolean existsById(Integer idcategoria);
}
