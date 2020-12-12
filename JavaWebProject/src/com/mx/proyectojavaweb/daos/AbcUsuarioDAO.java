package com.mx.proyectojavaweb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.mx.proyectojavaweb.beans.UsuarioBean;
import com.mx.proyectojavaweb.db.Conexion;

public class AbcUsuarioDAO {
	
	private static final String QUERY_USUARIO="select u.id_usuario,\r\n"
			+ "	u.nom_completo,\r\n"
			+ "	u.correo,\r\n"
			+ "	u.sexo,\r\n"
			+ "	u.pais,\r\n"
			+ "	r.nom_rol,\r\n"
			+ "	r.id_rol\r\n" 
			+ "from curso_java_web_db.usuarios_tab u,\r\n"
			+ "	curso_java_web_db.rol_tab r\r\n"
			+ "where r.id_rol=u.id_rol;";

	public List<UsuarioBean> getAllUsuario() {
		Conexion conexion = new Conexion();
		Connection 			con =	 null;
		PreparedStatement 	psmt 	= null;
		ResultSet			rs		=	null;
		List<UsuarioBean>	listUsuarioBean	=	new ArrayList<>();
		UsuarioBean			usuarioBean	= null;
		try {
			con = conexion.crearConexion();
			psmt = con.prepareStatement(QUERY_USUARIO);
			rs = psmt.executeQuery();
			while(rs.next()) {
				usuarioBean = new UsuarioBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						  rs.getString(5), rs.getString(6),rs.getInt(7));
				listUsuarioBean.add(usuarioBean);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				conexion.cerrar();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return listUsuarioBean;
	}
}
