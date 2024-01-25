package com.fran.pedido.service.impl;

import com.fran.pedido.model.dao.PedidoDao;
import com.fran.pedido.model.entity.Pedido;
import com.fran.pedido.service.InterfacePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoImpl implements InterfacePedido {

    @Autowired
    private PedidoDao pedidoDao;

    @Override
    public List<Pedido> findAll() {
        return (List<Pedido>) pedidoDao.findAll();
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoDao.save(pedido);
    }

    @Override
    public Pedido findById(Integer idpedido) {
        return pedidoDao.findById(idpedido).orElse(null);
    }

    @Override
    public void delete(Integer idpedido) {
        pedidoDao.deleteById(idpedido);
    }

    @Override
    public boolean existsById(Integer idpedido) {
        return pedidoDao.existsById(idpedido);
    }

}
