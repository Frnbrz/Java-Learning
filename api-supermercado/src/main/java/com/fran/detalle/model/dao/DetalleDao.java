package com.fran.detalle.model.dao;

import com.fran.detalle.model.entity.Detalle;
import org.springframework.data.repository.CrudRepository;

public interface DetalleDao extends CrudRepository<Detalle, Integer> {
}
