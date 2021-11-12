package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Proveedor;

public interface proveedorService {

	
	public abstract Proveedor insertaproveedor(Proveedor obj);
		public abstract List<Proveedor> listaproveedor();
	public Optional<Proveedor> buscarPorId( int idProveedor);
	public abstract void eliminaPorId(int idProveedor );
	
	public abstract List<Proveedor> listaProveedorconsureposi(String ruc,String direccion,int idUbigeo );
	
}
