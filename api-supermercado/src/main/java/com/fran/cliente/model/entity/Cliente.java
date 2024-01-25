package com.fran.cliente.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

    @Id
    private String idcliente;
    private String cia;
    private String contacto;
    private String cargo;
    private String direccion;
    private String ciudad;
    private String region;
    private String cp;
    private String pais;
    private String tlf;
    private String fax;
}
