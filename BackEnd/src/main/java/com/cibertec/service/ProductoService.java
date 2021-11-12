package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Producto;

public interface ProductoService {
	
	public abstract Producto insertaProducto(Producto obj);
	
	public abstract List<Producto> listaProducto(String nombre, String serie, int idMarca);

}
