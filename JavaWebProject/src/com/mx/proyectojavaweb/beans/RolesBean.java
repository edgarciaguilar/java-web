package com.mx.proyectojavaweb.beans;

import java.io.Serializable;

public class RolesBean implements Serializable{
	private int idRol;
	private String nomRol;
	
	
	public RolesBean(int idRol, String nomRol) {
		super();
		this.idRol = idRol;
		this.nomRol = nomRol;
	}
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNomRol() {
		return nomRol;
	}
	public void setNomRol(String nomRol) {
		this.nomRol = nomRol;
	}

}
