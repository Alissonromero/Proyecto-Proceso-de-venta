package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Reclamo;



public interface ReclamoRepository extends JpaRepository<Reclamo,Integer>{

	@Query("select r from Reclamo r where "
			+"(	:est is 0 or r.estado = :est ) and "
			+"(	:cli is 0 or r.cliente.idCliente = :cli ) and "
			+"(	:tip_rec is 0 or r.tipoReclamo.idTipoReclamo = :tip_rec ) ")
	public List<Reclamo> listaReclamo(@Param("est") int est,
									  @Param("cli") int cli, 
									  @Param("tip_rec")int tip_rec);
}
