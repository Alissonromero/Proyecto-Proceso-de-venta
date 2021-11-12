package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Sede;
import com.cibertec.repository.SedeRepository;


@Service
public class SedeServiceImpl implements SedeService {

	@Autowired
	private SedeRepository repositorio;
	
	@Override
	public Sede insertarActualizarSede(Sede obj) {
		// TODO Auto-generated method stub
		return repositorio.save(obj);
	}

	@Override
	public List<Sede> listarSede() {
	 
		return repositorio.findAll();
	}

	@Override
	public List<Sede> listarSedePorNombre(String nombre) {
	 
		return repositorio.listarSedePorNombre(nombre);
	}

	@Override
	public Optional<Sede> obtienePorIdSede(int idSede) {
		// TODO Auto-generated method stub
		return repositorio.findById(idSede);
	}

	@Override
	public void eliminarSede(int idSede) {
		repositorio.deleteById(idSede);
		
	}

	@Override
	public List<Sede> listarSedeNombre(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.findByNombreContaining(nombre);
	}

	@Override
	public List<Sede> listaSedePorNombreDireccionPais(String nombre, String direccion, int idPais) {
		// TODO Auto-generated method stub
		return  repositorio.listaSedePorNombreDireccionPais(nombre, direccion, idPais);
	}

	
	
	
	
	
	
}
