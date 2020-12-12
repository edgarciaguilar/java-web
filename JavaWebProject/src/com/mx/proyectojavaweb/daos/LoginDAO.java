package com.mx.proyectojavaweb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.mx.proyectojavaweb.beans.UsuarioBean;
import com.mx.proyectojavaweb.db.Conexion;

public class LoginDAO {
	private static final String QUERY_LOGIN = "SELECT  u.id_usuario, \r\n" + 
			"		u.nom_completo, \r\n" + 
			"        u.correo,\r\n" + 
			"        u.sexo, \r\n" + 
			"        u.pais,\r\n" + 
			"		r.nom_rol,\r\n" +
			"		r.id_rol\r\n" +
			"FROM curso_java_web_db.usuarios_tab u,\r\n" + 
			"	  rol_tab r\r\n" + 
			"WHERE r.id_rol = u.id_rol\r\n" + 
			"AND u.correo 	= ?\r\n" + 
			"AND   u.password = md5(?)";
			
	Connection con;
	
	public UsuarioBean obtenerUsuario(String correo, String pass) {
		Conexion conexion=new Conexion();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		int existe=0;
		UsuarioBean usuarioBean=null;
		try {
			con=conexion.crearConexion();
			pstm= con.prepareStatement(QUERY_LOGIN);
			pstm.setString(1, correo);
			pstm.setString(2, pass);
			
			rs=pstm.executeQuery();
			while(rs.next()) {
				//existe=rs.getInt(1);
				usuarioBean = new UsuarioBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						  rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pstm.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();			
			}
		}
		return usuarioBean;
	}
}
