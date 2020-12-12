package com.mx.proyectojavaweb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mx.proyectojavaweb.db.Conexion;

/**
 * Servlet implementation class ProbarConexionServlet
 */
@WebServlet("/ProbarConexionServlet")
public class ProbarConexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	public ProbarConexionServlet() {
			Conexion conexion=new Conexion();
			try {
				con= conexion.crearConexion();
				if(con !=null) {
					System.out.println("Conexion Exitosa");
				}else{
					System.out.println("Error de conexion");
				}
			} catch (NamingException | SQLException e) {

				e.printStackTrace();
			}finally {
				try {
					conexion.cerrar();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
