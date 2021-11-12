package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Cliente;
import com.cibertec.entity.FiltroCliente;
import com.cibertec.entity.Cliente;

public interface ClienteService {
	
	public abstract List<Cliente> listaCliente();
	
	public abstract Cliente insertaActualizaCliente(Cliente obj);
	
	public abstract List<Cliente> listaClientePoridCliente( String idCliente);
	
	public abstract List<Cliente> listaClientePorApellidos( String apellidos);
	
	public abstract List<Cliente> listaClientePoridClienteApellidos(String idCliente, String apellidos);
	
	public abstract List<Cliente> listaClientePoridClienteApellidosUbigeo(String idCliente, String apellidos, int idUbigeo);
	
	public abstract List<Cliente> listaPorFiltro(FiltroCliente filtro);
	
	public abstract List<Cliente> listaCliente(String nom, String ape, int idUbigeo);

}
