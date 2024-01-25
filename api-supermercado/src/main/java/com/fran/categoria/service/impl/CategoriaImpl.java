package com.fran.categoria.service.impl;


import com.fran.categoria.model.dao.CategoriaDao;
import com.fran.categoria.model.entity.Categoria;
import com.fran.categoria.service.InterfaceCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaImpl implements InterfaceCategoria {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    @Transactional
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaDao.save(categoria);
    }
    @Transactional(readOnly = true)
    @Override
    public Categoria findById(Integer idcategoria) {
        return categoriaDao.findById(idcategoria).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Integer idcliente) {
        categoriaDao.deleteById(idcliente);
    }

    @Override
    public boolean existsById(Integer idcliente) {
        return categoriaDao.existsById(idcliente);
    }

}
