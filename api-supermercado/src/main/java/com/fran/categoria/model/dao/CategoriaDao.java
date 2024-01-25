package com.fran.categoria.model.dao;

import com.fran.categoria.model.entity.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Integer> {

    @Query("SELECT MAX(idcategoria) FROM Categoria")
    public Integer getMaxIdCategoria();
}
