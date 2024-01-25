package com.fran.pedido.model.entity;


import com.fran.cliente.model.entity.Cliente;
import com.fran.detalle.model.entity.Detalle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="producto")
public class Pedido {

    @Id
    private int idpedido;
    @ManyToOne
    @JoinColumn(name="idcliente")
    private Cliente cliente;
    private Date fechapedido;
    private Date fechaentrega;
    @OneToMany(mappedBy="pedido")
    private List<Detalle> detalles;

}
