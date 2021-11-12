package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Reclamo;



public interface ReclamoService {

	public abstract Reclamo insertaActualizaReclamo(Reclamo obj);
	
	public abstract List<Reclamo> listaReclamo(int est, int cli, int tip_rec);
}
