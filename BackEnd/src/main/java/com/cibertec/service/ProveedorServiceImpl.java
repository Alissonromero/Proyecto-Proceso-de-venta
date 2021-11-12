package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Proveedor;
import com.cibertec.repository.proveedorRepository;
@Service
public class ProveedorServiceImpl implements proveedorService {

	
	@Autowired
		private proveedorRepository repository;
	@Override
	public Proveedor insertaproveedor(Proveedor obj) {
	
		return repository.save(obj);
	}

	@Override
	public List<Proveedor> listaproveedor() {
	
		return repository.findAll()	;
	}

	@Override
	public Optional<Proveedor> buscarPorId(int idProveedor) {
		// TODO Auto-generated method stub
		return repository.findById(idProveedor);
	}

	@Override
	public void eliminaPorId(int idProveedor) {
		repository.deleteById(idProveedor);
		
	}

	@Override
	public List<Proveedor> listaProveedorconsureposi(String ruc, String direccion, int idUbigeo) {
		// TODO Auto-generated method stub
		return repository.listaProveedorconsureposi(ruc, direccion, idUbigeo);
	}

	
}
