<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@page import="com.mx.proyectojavaweb.beans.UsuarioBean" %>

<%UsuarioBean usuarioBean = (UsuarioBean)session.getAttribute("usuarioBean"); 
 String urlLogut = request.getContextPath() + "/LogoutServlet";
 String urlPage  = request.getContextPath() + "/MenuRedirectServlet?pagina=";
 
%>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://kit.fontawesome.com/cd24763895.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="../css/layout.css">
	<script src="../jquery/jquery-3.5.1.min.js"></script>
	<script src="../js/layout.js"></script>
	<title>Sistema ABC Web basado en Java</title>
	<div class="contenido">
		<header>
		<div>
			<img src="../img/ADigitales.png"/>
		</div>
			

			<div class="menu-bar">
				<a href="#"><span>Menú</span><i class="fas fa-bars"></i></a>
			</div>
			<ul class="menu">
				<li class="sub-menu">
					<a href="#"><i class="fas fa-caret-down"></i>Recursos Humanos</a>
					<ul class="children">
						<li><a href="<%=urlPage + "abcUsuario"%>">Usuarios</a></li>
						<li><a href="<%=urlPage + "ambitos"%>"">Ámbitos</a></li>
						<li><a href="#">Modificaciones</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fas fa-folder"></i>Administración</a></li>
				<li><a href="#"><i class="fas fa-chart-bar"></i>Reportes</a></li>
				<li><a href="#"><i class="fas fa-cogs"></i>Configuración</a></li>
			</ul>

			<div class="usuario">
				<span><%=usuarioBean.getNomCompleto()%></span>
				<span><%=usuarioBean.getNomRol()%></span>
				<span><a href="<%=urlLogut%>">Salir<i class="fas fa-sign-out-alt salir"></i></a></span>
			</div>
		</header>
		<main>

			<jsp:include page="${sessionScope.page}" />
		</main>
		<footer>
			<img src="../img/ADigitales.png"/>
			<span>Todos los derechos reservados</span>
		</footer>

	</div>
</head>
<body>

</body>
</html>