package com.fran.detalle.service;

import com.fran.detalle.model.entity.Detalle;
import java.util.List;

public interface InterfaceDetalle {

    List<Detalle> findAll();

    Detalle save(Detalle detalle);

    Detalle findById(Integer idcliente);

    void delete(Integer idcliente);

    boolean existsById(Integer idcliente);
}
