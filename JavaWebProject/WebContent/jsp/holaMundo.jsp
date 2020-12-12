<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Hola mundo con JSP</title>
</head>
<body>
<% 
Cookie[] cookies = request.getCookies();
				String vecesInsertadas = null;
				if(cookies != null) { //Si hay cookies
					for(int i = 0; i < cookies.length; i++) {
						if(cookies[i].getName().equals("cookieInsert") ) {
							vecesInsertadas = cookies[i].getValue();
							break;
						}
					}
				}
				
				int count = 0;
				if(vecesInsertadas == null) {
					count = 1;
				}else {
					count = Integer.parseInt(vecesInsertadas) + 1;
				}
				Cookie c = new Cookie("cookieInsert", String.valueOf(count));
				//Añadir la cookie a las cabeceras de la respuesta HTTP
				response.addCookie(c);
				String pluralSingular=(count==1?" vez.":" veces.");
				
				%>
				<h1>Has entrado a esta pagina: <%=count %><%=pluralSingular %>  </h1>
</body>
</html>