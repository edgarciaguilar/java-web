package com.mx.proyectojavaweb.view;

import java.util.List;

import com.mx.proyectojavaweb.beans.RolesBean;
import com.mx.proyectojavaweb.daos.RegistroUsuarioDAO;

public class RegistroUsuarioView {
	
	public List<RolesBean> getRoles() {
		RegistroUsuarioDAO regDAO=new RegistroUsuarioDAO();
		List<RolesBean> listRoles= regDAO.getRoles();
		return listRoles;
	}

}
