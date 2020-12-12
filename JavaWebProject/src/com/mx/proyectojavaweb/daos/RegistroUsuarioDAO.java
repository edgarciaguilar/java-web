package com.mx.proyectojavaweb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.mx.proyectojavaweb.beans.FormularioBean;
import com.mx.proyectojavaweb.beans.RolesBean;
import com.mx.proyectojavaweb.beans.UsuarioBean;
import com.mx.proyectojavaweb.db.Conexion;

public class RegistroUsuarioDAO {
	Connection con;
	public static final String QUERY="SELECT id_rol,nom_rol FROM curso_java_web_db.rol_tab";
	
	private final static String INSERT_USER = "INSERT INTO curso_java_web_db.usuarios_tab\r\n" + 
			"															(nom_completo,\r\n" + 
			"															correo,\r\n" + 
			"															password,\r\n" + 
			"															sexo,\r\n" + 
			"															pais,\r\n" + 
			"															fec_creation,\r\n" + 
			"															creation_by,\r\n" + 
			"															last_update_date,\r\n" + 
			"															update_by,\r\n" + 
			"															id_rol)\r\n" + 			
			"															VALUES\r\n" + 
			"															(?,?,md5(?),?,?,sysdate(),0,sysdate(),0,?)";
	
	/***
	 * Metodo que inserta un usuario
	 * @param formularioBean bean que contiene los datos del usuario
	 * @return devuelve true si se inserto correctamente, false en caso contrario
	 */
	
	public boolean insertUser(UsuarioBean usuarioBean) {
		Conexion conexion=new Conexion();

		PreparedStatement psmt = null;
		boolean paso = false;
		try {
			con = conexion.crearConexion();
			psmt = con.prepareStatement(INSERT_USER);
			psmt.setString(1,usuarioBean.getNomCompleto());
			psmt.setString(2,usuarioBean.getCorreo());
			psmt.setString(3,usuarioBean.getPass());
			psmt.setString(4,usuarioBean.getSexo());
			psmt.setString(5,usuarioBean.getPais());
			psmt.setInt(6, usuarioBean.getIdRol());
			psmt.executeUpdate();			
			paso = true;
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				con.close();
				conexion.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return paso;
	}
	
	public List<RolesBean> getRoles() {
		Connection 			con 	= null;
		PreparedStatement 	psmt 	= null;
		ResultSet 			rs 		= null;
		List<RolesBean>		listRoles	=	new ArrayList<>();
		Conexion conexion = new Conexion();
		try {
			con = conexion.crearConexion();
			psmt = con.prepareStatement(QUERY);
			rs = psmt.executeQuery();
			while(rs.next()) {
				listRoles.add(new RolesBean (rs.getInt(1),rs.getString(2)));
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
		return listRoles;
		
	}
	

}
