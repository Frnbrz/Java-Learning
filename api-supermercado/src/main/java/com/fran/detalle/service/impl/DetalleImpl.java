package com.fran.detalle.service.impl;

import com.fran.cliente.model.entity.Cliente;
import com.fran.detalle.model.dao.DetalleDao;
import com.fran.detalle.model.entity.Detalle;
import com.fran.detalle.service.InterfaceDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleImpl implements InterfaceDetalle {

    @Autowired
    private DetalleDao detalleDao;

    @Override
    public List<Detalle> findAll() {
       return (List) detalleDao.findAll();
    }

    @Override
    public Detalle save(Detalle detalle) {
        return detalleDao.save(detalle);
    }

    @Override
    public Detalle findById(Integer idcliente) {
        return null;
    }

    @Override
    public void delete(Integer idcliente) {

    }

    @Override
    public boolean existsById(Integer idcliente) {
        return false;
    }




}
