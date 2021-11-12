package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.TipoReclamo;
import com.cibertec.repository.TipoReclamoRepository;




@Service
public class TipoReclamoServiceImpl implements TipoReclamoService {

	@Autowired
	private TipoReclamoRepository repository;

	@Override
	public List<TipoReclamo> listaTipoReclamo() {
		return repository.findAll();
	}


}
