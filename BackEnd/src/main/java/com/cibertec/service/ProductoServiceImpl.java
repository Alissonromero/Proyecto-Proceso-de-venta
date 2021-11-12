package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Producto;
import com.cibertec.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository repositorioProducto;
	
	@Override
	public Producto insertaProducto(Producto obj) {
		return repositorioProducto.save(obj);
	}

	@Override
	public List<Producto> listaProducto(String nombre, String serie, int idMarca) {
		return repositorioProducto.listaProducto(nombre, serie, idMarca);
	}

}
