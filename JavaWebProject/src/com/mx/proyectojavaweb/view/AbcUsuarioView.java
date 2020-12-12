package com.mx.proyectojavaweb.view;

import java.util.List;

import com.mx.proyectojavaweb.beans.UsuarioBean;
import com.mx.proyectojavaweb.daos.AbcUsuarioDAO;

public class AbcUsuarioView {
	
	public List<UsuarioBean> getAllUSer() {
		AbcUsuarioDAO userDao = new AbcUsuarioDAO();
		List<UsuarioBean> listUsers = userDao.getAllUsuario();
		return listUsers;
	}
	
}
