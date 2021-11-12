package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Marca;
import com.cibertec.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	private MarcaRepository repository;
	
	@Override
	public List<Marca> listaMarca() {
		return repository.findAll();
	}
	
	
}
