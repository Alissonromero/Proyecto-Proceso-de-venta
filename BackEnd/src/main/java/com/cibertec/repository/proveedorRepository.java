package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Proveedor;
import com.cibertec.entity.FiltroProveedor;


public interface proveedorRepository extends JpaRepository<Proveedor, Integer> {

	 @Query("select d from Proveedor d where "
				+ "( :p_ruc is '' or d.ruc = :p_ruc ) and "
				+ "( :p_direc is '' or d.direccion like :p_direc ) and "
				+ "( :p_ubi is 0  or d.ubigeo.idUbigeo = :p_ubi ) ")
		public abstract List<Proveedor> listaProveedorconsureposi(
									 	@Param("p_ruc") String ruc, 
									 	@Param("p_direc") String direccion,
									 	@Param("p_ubi") int idUbigeo);	
		

}

	
	
