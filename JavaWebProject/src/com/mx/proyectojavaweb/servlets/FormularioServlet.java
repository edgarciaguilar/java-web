package com.mx.proyectojavaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mx.proyectojavaweb.beans.FormularioBean;
import com.mx.proyectojavaweb.beans.UsuarioBean;
import com.mx.proyectojavaweb.daos.FormularioDAO;
import com.mx.proyectojavaweb.daos.RegistroUsuarioDAO;


@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaPeticion( request,  response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaPeticion( request,  response);
		//doGet(request, response);
	}
	protected void procesaPeticion(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out	=	null;
		try {
			request.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			System.out.println("Entro en el Servlet");
			String nomCompleto 	= request.getParameter("nomCompleto");
			String email 		= request.getParameter("email");
			String pass 		= request.getParameter("password");
			String sexo 		= request.getParameter("sexo");
			String pais 		= request.getParameter("pais");
			String idRol 		= request.getParameter("roles");
			
			RegistroUsuarioDAO registroDAO = new RegistroUsuarioDAO();
			UsuarioBean usuarioBean = new UsuarioBean(nomCompleto,email,sexo,pais,Integer.parseInt(idRol),pass);
			HttpSession session=request.getSession();
			boolean paso = registroDAO.insertUser(usuarioBean);
			if(paso) {
				out.print("<h1> El usuario "+ nomCompleto +" Se insert correctamente</h1>");
			}else {
				out.print("<h1> Ocurrio un error al insertar el usuario "+ nomCompleto);
			}
			String redirectPage=(String) session.getAttribute("urlRedirectMain");
			response.sendRedirect(redirectPage+"abcUsuario");
			/*System.out.println("nomCompleto: " + nomCompleto);
			System.out.println("email: " + email);
			System.out.println("pass: " + pass);
			System.out.println("sexo: " + sexo);
			System.out.println("pais: " + pais);*/
			/*out.println("nomCompleto: " + nomCompleto);
			out.println("email: " + email);
			out.println("pass: " + pass);
			out.println("sexo: " + sexo);
			out.println("pais: " + pais);
			*/
			//Obtener valor de un check box
			/*String [] values = request.getParameterValues("hobbie");
			for(String val : values) {
				out.println("Hobbies: " + val);
			}*/
			/* Para obtener todos los valores de un formulario
			Enumeration nombresParametros = request.getParameterNames();
			String parametro	=	"";
			String valor 		= "";
			while(nombresParametros.hasMoreElements()) {
				parametro = (String)nombresParametros.nextElement();
				valor = request.getParameter(parametro);
				out.println("<h3>valor " + valor + "</h3>");
			}*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
		
		
	}

}
