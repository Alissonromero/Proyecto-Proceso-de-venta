package com.cibertec.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UsuarioHasRolPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int idUsuario;
	private int idRol;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRol;
		result = prime * result + idUsuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioHasRolPK other = (UsuarioHasRolPK) obj;
		if (idRol != other.idRol)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

}
