package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Cliente;
import com.cibertec.entity.FiltroCliente;
import com.cibertec.entity.Cliente;
import com.cibertec.repository.ClienteRepository;
import com.cibertec.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> listaCliente() {
				return repository.findAll();
	}
	
	@Override
	public Cliente insertaActualizaCliente(Cliente obj) {
		return repository.save(obj);
	}

	@Override
	public List<Cliente> listaClientePoridCliente(String idCliente) {
			return repository.findByidCliente(idCliente);
	}

	
	@Override
	public List<Cliente> listaClientePorApellidos(String apellidos) {
		
		return repository.findByApellidosContaining(apellidos);
	}
	
	@Override
	public List<Cliente> listaClientePoridClienteApellidos(String idCliente, String apellidos){
		return repository.listaClientePoridClienteApellidos(idCliente, apellidos);
		
	}
	
	
	@Override
	public List<Cliente> listaClientePoridClienteApellidosUbigeo(String idCliente, String apellidos, int idUbigeo) {
		return repository.listaClientePoridClienteApellidosUbigeo(idCliente, apellidos, idUbigeo);
	}

	@Override
	public List<Cliente> listaPorFiltro(FiltroCliente filtro) {
		return repository.listaPorFiltro(filtro);
	}
	
	@Override
	public List<Cliente> listaCliente(String nom, String ape, int idUbigeo) {
		return repository.listaCliente(nom, ape, idUbigeo);
	}

	

}
