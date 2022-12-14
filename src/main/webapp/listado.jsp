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
				  	List<Producto> listado = (List<Producto>)request.getAttribute("productos");
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
				      <td>
				      	<a class="btn btn-info" role="button" href="<%=request.getContextPath()%>/EditarProductoController?id=<%=p.getId()%>">Editar</a> | 
			      		<!-- Button trigger modal -->
						<button type="button" class="btn btn-danger" 
							data-bs-toggle="modal" 
							data-bs-target="#exampleModal" 
							onclick="setProductoId(<%=p.getId()%>)">
						  Eliminar
						</button>
					</td>
				    </tr>
				  <%
				  	}
				  %>				    
				  </tbody>
				</table>
			</section>
		</main>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    	<form action="<%=request.getContextPath()%>/DeleteProductoController">
		    	  <input type="hidden" name="idProducto" id="idProducto">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Eliminar Producto</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        ¿Confirma que desea eliminar? 
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			        <button type="submit" class="btn btn-danger">Eliminar</button>
			      </div>
		    	</form>
		    </div>
		  </div>
		</div>
		<jsp:include page="scripts.jsp"/>
		<script>
			function setProductoId(id) {
				document.getElementById('idProducto').value=id;
			}
		</script>
	</body>
	
</html>