package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{

	@Query("Select a from Marca a where nombre like :fil")
	public abstract List<Marca> listaClientePorNombreLike(@Param("fil") String filtro);
	
}
