<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mx.proyectojavaweb.view.AbcUsuarioView" %>
<%@page import="java.util.List" %>
<%@page import="com.mx.proyectojavaweb.beans.UsuarioBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../icons/css/all.min.css">
<link rel="stylesheet" href="../css/abcUsuario.css" />
</head>
<% 
	AbcUsuarioView abcView = new AbcUsuarioView();
	List<UsuarioBean> listUser = abcView.getAllUSer();
	//String urlPage  = request.getContextPath() + "/MenuRedirectServlet?pagina=";
%>
<body>
	<div class="content-abcUsuario">
		<div class="div-busqueda">
			<div class="txt-busqueda">
				<input type="text" name="txtBuscar" placeholder="Buscar Por Nombre" /> 
				<input type="submit" value="Buscar">
			</div>
			<div class="new-user">
			 <a href="<%=session.getAttribute("urlRedirectMain")+"registroUsuario" %>"> <i class="fas fa-plus-circle"></i> <span>Nuevo</span>  </a>
			</div>
		</div>
		
		<div class="list-user">
			<table>
				<tr>
					<th>Nombre Completo</th>
					<th>Correo</th>
					<th>Sexo</th>
					<th>país</th>
					<th>Rol</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
		<%for(UsuarioBean usuario : listUser){ %>		
				<tr>
					<td><%=usuario.getNomCompleto() %></td>
					<td><%=usuario.getCorreo() %></td>
					<td><%=usuario.getSexo() %></td>
					<td><%=usuario.getPais() %></td>
					<td><%=usuario.getNomRol() %></td>
					<td><a href="<%=request.getContextPath()+"/EditRegistroUsuarioServlet?nomCompleto="+usuario.getNomCompleto()
					+"&correo="+usuario.getCorreo()+"&sexo="+usuario.getSexo()+ "&pais="+usuario.getPais()+"&idRol="+usuario.getIdRol()+"&idUsuario="+usuario.getIdUsuario() %>"> <i class="far fa-edit"></i> </a></td>
					<td><a href=""><i class="fas fa-minus-circle"></i></a></td>
				</tr>
		<%} %>
			</table>
		</div>
	</div>
</body>
</html>