package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Reclamo;
import com.cibertec.repository.ReclamoRepository;



@Service
public class ReclamoServiceImpl implements ReclamoService {

	@Autowired
	private ReclamoRepository repo;
	
	@Override
	public Reclamo insertaActualizaReclamo(Reclamo obj) {
		return repo.save(obj);
	}

	@Override
	public List<Reclamo> listaReclamo(int est, int cli, int tip_rec) {
		return repo.listaReclamo(est, cli, tip_rec);
	}

}
