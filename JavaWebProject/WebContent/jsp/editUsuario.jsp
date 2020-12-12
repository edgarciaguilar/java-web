<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mx.proyectojavaweb.view.RegistroUsuarioView" %>
<%@page import="java.util.List" %>
<%@page import="com.mx.proyectojavaweb.beans.RolesBean" %>
<%@page import="com.mx.proyectojavaweb.beans.UsuarioBean" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Formulario con Java Servlets</title>
	<link rel="stylesheet" href="../css/formulario.css" />
	<%
		RegistroUsuarioView regView=new RegistroUsuarioView();
		List<RolesBean> listaRoles=regView.getRoles();
		UsuarioBean usuarioBean=(UsuarioBean)session.getAttribute("editUsuarioBean");
	%>
	<div class="contenedor-registro-usuario">
	<form action="/JavaWebProject/FormularioServlet" method="post">
		<div class="tit-reg-user">
			<span>Editar Usuario</span>
		</div>
		<main>
			<input type="text" name="nomCompleto" placeholder="Nombre Completo" value="<%=usuarioBean.getNomCompleto() %>" />
			<input type="email" name="email" placeholder="E-mail" value="<%=usuarioBean.getCorreo() %>" />
			<input type="password" name="password" placeholder="Contraseña" />
			<fieldset class="field-sexo">
				<legend>Sexo</legend>
				<div class="div-sexo">
					<input id="m" type="radio" name="sexo" value="M" <%=usuarioBean.getSexo().equals("M")?"checked='checked'":"" %> />
					<label for="m">Masculino</label>
					<input id="f" type="radio" name="sexo" value="F" <%=usuarioBean.getSexo().equals("F")?"checked='checked'":"" %>/>
					<label for="f">Femenino</label>
				</div>
			</fieldset>
			
			<fieldset class="field-pais">
				<legend>País Origen</legend>
				<div class="div-pais">
					<select class="select-pais" name="pais" id="pais">
						<option class="class-pais" value="MX" <%=usuarioBean.getPais().equals("MX")?"selected='selected'":"" %>>México</option>
						<option class="class-pais" value="ES" <%=usuarioBean.getPais().equals("ES")?"selected='selected'":"" %>>España</option>
						<option class="class-pais" value="AR" <%=usuarioBean.getPais().equals("AR")?"selected='selected'":"" %>>Argentina</option>
						<option class="class-pais" value="EU" <%=usuarioBean.getPais().equals("EU")?"selected='selected'":"" %>>EU</option>
					</select>
				</div>
			</fieldset>
			<fieldset class="field-roles">
			<legend>Roles</legend>
			<div class="div-roles">
				<select class="select-roles" name="roles" id="roles">
					<%for(RolesBean rol : listaRoles){ %>
							<option class="class-pais" value="<%=rol.getIdRol() %>" <%=usuarioBean.getIdRol()== rol.getIdRol()?"selected='selected'":""%>> <%=rol.getNomRol() %></option>
					<%} %>
				</select>
			</div>
			</fieldset>
			<input type="submit"  value="Modificar"/>
		</main>
	
	</form>
</div>
</head>
<body>

</body>
</html>