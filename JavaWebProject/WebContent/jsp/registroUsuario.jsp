<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mx.proyectojavaweb.view.RegistroUsuarioView" %>
<%@page import="java.util.List" %>
<%@page import="com.mx.proyectojavaweb.beans.RolesBean" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Formulario con Java Servlets</title>
	<link rel="stylesheet" href="../css/formulario.css" />
	<%
		RegistroUsuarioView regView=new RegistroUsuarioView();
		List<RolesBean> listaRoles=regView.getRoles();
	%>
	<div class="contenedor-registro-usuario">
	<form action="/JavaWebProject/FormularioServlet" method="post">
		<div class="tit-reg-user">
			<span>Registro Usuario</span>
		</div>
		<main>
			<input type="text" name="nomCompleto" placeholder="Nombre Completo" />
			<input type="email" name="email" placeholder="E-mail" />
			<input type="password" name="password" placeholder="Contraseña" />
			<fieldset class="field-sexo">
				<legend>Sexo</legend>
				<div class="div-sexo">
					<input id="m" type="radio" name="sexo" value="M" checked="checked"/>
					<label for="m">Masculino</label>
					<input id="f" type="radio" name="sexo" value="F"/>
					<label for="f">Femenino</label>
				</div>
			</fieldset>
			
			<fieldset class="field-pais">
				<legend>País Origen</legend>
				<div class="div-pais">
					<select class="select-pais" name="pais" id="pais">
						<option class="class-pais" value="MX">México</option>
						<option class="class-pais" value="ES">España</option>
						<option class="class-pais" value="AR">Argentina</option>
						<option class="class-pais" value="EU">EU</option>
					</select>
				</div>
			</fieldset>
			<fieldset class="field-roles">
			<legend>Roles</legend>
			<div class="div-roles">
				<select class="select-roles" name="roles" id="roles">
					<%for(RolesBean rol : listaRoles){ %>
							<option class="class-pais" value="<%=rol.getIdRol() %>"><%=rol.getNomRol() %></option>
					<%} %>
				</select>
			</div>
			</fieldset>
			<input type="submit"  value="Enviar"/>
		</main>
	
	</form>
</div>
</head>
<body>

</body>
</html>