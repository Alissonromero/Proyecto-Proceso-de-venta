package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Sede;

public interface SedeRepository  extends JpaRepository<Sede, Integer> {

	
	
	
	@Query("Select a from Sede a where nombre like :filtro")
	public abstract List<Sede> listarSedePorNombre(@Param("filtro") String filtro);
	
	public abstract List<Sede> findByNombreContaining(String nombre);
	
	
	
	
	

	@Query("select d from Sede d where "
			+ "( :p_nombre is '' or d.nombre = :p_nombre ) and "
			+ "( :p_direcion is '' or d.direccion =:p_direcion ) and "
			+ "( :p_idPais is 0  or d.pais.idPais = :p_idPais ) ")
	public abstract List<Sede> listaSedePorNombreDireccionPais(
								 	@Param("p_nombre") String nombre, 
								 	@Param("p_direcion") String direccion,
								 	@Param("p_idPais") int idPais);
	
	
}

