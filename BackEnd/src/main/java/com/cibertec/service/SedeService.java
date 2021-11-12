package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Sede;

public interface SedeService {

	
	
	public abstract List<Sede> listarSede();
	public abstract List<Sede> listarSedePorNombre(String nombre);
	public abstract Sede insertarActualizarSede(Sede obj);
	
	public abstract Optional<Sede> obtienePorIdSede(int idSede);
	public abstract void eliminarSede(int  idSede);
	
	public abstract List<Sede> listarSedeNombre(String nombre);
	
	
	public abstract List<Sede> listaSedePorNombreDireccionPais(String nombre,String direccion,int idPais);
	
	
	
	
}
