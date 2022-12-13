<!Doctype html>
<!-- directiva para importar clases-->
<%@page import="ar.com.codoacodo.domain.Producto"%>
<%@page import="java.util.List"%>
<html lang="es">
	<head>
		<jsp:include page="styles.jsp"/>
	</head>
	<!-- codigo html para mostrar la tabla que viene desde el controller-->
	<body>
		<!-- aca va el navbar.jsp -->
		<jsp:include page="navbar.jsp"/>
		<main class="container">
			<h1>Listado de Producto</h1>
			<section>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Codigo</th>
				      <th scope="col">Titulo</th>
				      <th scope="col">Precio</th>
				      <th scope="col">Fecha Alta</th>
				      <th scope="col">Autor</th>
				      <th scope="col">Imagen</th>
				      <th scope="col">&nbsp;</th>
				    </tr>
				  </thead>
				  <tbody>
				  <% //scriplet
				  	//en las jsp exixte un objeto llamado request que esta implicito
				  	//capurar/bajar/obtener la lista que guardamos en el controller
				  	List<Producto> listado = (List<Producto>) request.getAttribute("productos");
				  	for(Producto p : listado) {
				  %>
				    <tr>
				      <th scope="row"><%=p.getId()%></th>
				      <td><%=p.getCodigo()%></td>
				      <td><%=p.getTitulo()%></td>
				      <td><%=p.getPrecio()%></td>
				      <td><%=p.getFechaAlta()%></td>
				      <td><%=p.getAutor()%></td>
				      <td><%=p.getImg()%></td>
				      <td>Editar | Eliminar</td>
				    </tr>
				  <%
				  	}
				  %>				    
				  </tbody>
				</table>
			</section>
		</main>
		<jsp:include page="scripts.jsp"/>
	</body>
</html>