package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query("select p from Producto p where (:p_nombre is '' or p.nombre like :p_nombre) and "
										+ "(:p_serie is '' or p.serie like :p_serie) and "
										+ "(:p_marca is 0 or p.marca.idMarca = :p_marca)")
	public List<Producto> listaProducto(@Param("p_nombre") String nombre, 
										@Param("p_serie") String serie, 
										@Param("p_marca") int idMarca);
		
	
}
