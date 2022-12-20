<!Doctype html>
<!-- directiva para importar clases-->
<%@page import="ar.com.codoacodo.domain.Producto"%>
<%@page import="java.util.*"%>
<%@page import="ar.com.codoacodo.dao.IProductoDAO"%>
<%@page import="ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl"%>

<html lang="es">
	<head>
		<jsp:include page="styles.jsp"/>
	</head>
	<!-- codigo html para mostrar la tabla que viene desde el controller-->
	<body>
		<!-- aca va el navbar.jsp -->
		<jsp:include page="navbar.jsp"/>
		<main class="container">
			<div class="col-1">
				<h3>Categorias:</h3>
			  <%
				IProductoDAO dao = new ProductoDAOMysqlImpl();
				Set<String> setCategoria = dao.allCategories();
				%>
				<form class="d-flex" action="<%=request.getContextPath()%>/SearchProductosByCategoryController">
				<%for(String cat : setCategoria) {
					%>
					  <div class="m-3 form-check">
					    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="<%=cat%>">
					    <label class="form-check-label" for="exampleCheck1"><%=cat%></label>
					  </div>
				<% } %>
				  <button type="submit" class="btn btn-primary">Filtrar</button>
				</form>
			</div>
			<h1>Productos:</h1>
			<jsp:include page="mensajeria.jsp"/>
			<section>
				<div class="col-12">
		          <div class="row row-cols-8 g-4">
				  <% //scriplet	
				  	//en las jsp exixte un objeto llamado request que esta implicito
				  	//capurar/bajar/obtener la lista que guardamos en el controller
			  		List<Producto> listado2 = (List<Producto>)request.getAttribute("productos");
				  	for(Producto p : listado2) {
				  %>
		            <div class="col">
		         	     <div class="card" style="width: 20rem;">
		                <img src="imagenes/<%=p.getImg()%>" class="card-img-top" alt="...">
		                <div class="card-body">
		                  <h5 class="card-title"><%=p.getTitulo()%></h5>
		                </div>
		                <ul class="list-group list-group-flush">
		                  <li class="list-group-item">Precio = $<%=p.getPrecio()%></li>
		                  <li class="list-group-item">Autor = <%=p.getAutor()%></li>
		                  <li class="list-group-item">Codigo = <%=p.getCodigo()%></li>
		                  <li class="list-group-item">id = <%=p.getId()%></li>
		                  <li class="list-group-item">Fecha Alta = <%=p.getFechaAlta()%></li>
		                  <li class="list-group-item">Categoria = <%=p.getCat()%></li>
		                </ul>
		                <div class="card-footer">
		                  <a class="btn btn-info" role="button" href="<%=request.getContextPath()%>/EditarProductoController?id=<%=p.getId()%>">Editar</a> | 
		                  <button type="button" class="btn btn-danger" 
							data-bs-toggle="modal" 
							data-bs-target="#exampleModal" 
							onclick="setProductoId(<%=p.getId()%>)">
						  		Eliminar
							</button>
		                </div>
		              </div>
		            </div>
				  <%
				  	}
				  %>
		          </div>
		        </div>
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