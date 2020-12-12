package com.mx.proyectojavaweb.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexion {
	Connection con;



    public Connection crearConexion() throws NamingException, SQLException{
        
        Context envContext = new InitialContext();
        DataSource ds = (DataSource)envContext.lookup("java:/comp/env/jdbc/curso_java_web_db");
        con = ds.getConnection();
     return con;
    }
    
    
    public void cerrar() throws SQLException {
    	con.close();
    }
}
