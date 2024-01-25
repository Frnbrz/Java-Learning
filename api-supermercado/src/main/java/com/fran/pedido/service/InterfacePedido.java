package com.fran.pedido.service;

import com.fran.pedido.model.entity.Pedido;

import java.util.List;

public interface InterfacePedido {

    List<Pedido> findAll();

    Pedido save(Pedido pedido);

    Pedido findById(Integer idpedido);

    void delete(Integer idpedido);

    boolean existsById(Integer idpedido);
}
