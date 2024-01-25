package com.fran.pedido.model.dao;

import com.fran.pedido.model.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoDao extends CrudRepository<Pedido, Integer> {
}
