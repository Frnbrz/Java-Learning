package com.fran.producto.model.entity;


import com.fran.categoria.model.entity.Categoria;
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
@Table(name="producto")
public class Producto {

    @Id
    private int idproducto;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;
    private String medida;
    private int precio;
    private int stock;
}
