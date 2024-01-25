package com.fran.detalle.model.entity;


import com.fran.pedido.model.entity.Pedido;
import com.fran.producto.model.entity.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="detalle")
public class Detalle {

    @Id
    private int iddetalle;
    @ManyToOne
    @JoinColumn(name="idpedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name="idproducto")
    private Producto producto;
    private float precio;
    private int unidades;
    private float descuento;
}
