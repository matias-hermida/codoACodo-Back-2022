<!Doctype html>
<html>
	<head>
		<jsp:include page="styles.jsp"/>
	</head>
	<body>
		<jsp:include page="navbar.jsp"/>
		<main class="container">
			<h1>Nuevo Producto</h1>
			<div class="row">
				<div class="col-12">
					<form class="row g-3 needs-validation" novalidate
						action="<%=request.getContextPath()%>/CreateProductoController"
						method="POST">
					  <div class="col-md-4">
					    <label for="validationCustom01" class="form-label">
					    	Codigo
					    </label>
					    <input type="text"
					    	name="codigo" 
					    	class="form-control" 
					    	id="validationCustom01" 
					    	value="" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="validationCustom02" class="form-label">Titulo</label>
					    <input type="text"
					    	name="titulo" 
					    	class="form-control" 
					    	id="validationCustom02"
					    	value="" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="validationCustom02" class="form-label">Precio</label>
					    <input type="number"
					    	name="precio" 
					    	class="form-control" 
					    	id="validationCustom02"
					    	value="" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="validationCustom03" class="form-label">Fecha Alta</label>
					    <input type="date"
					    	name="fechaAlta" 
					    	class="form-control" 
					    	id="validationCustom03" 
					    	required>
					    <div class="invalid-feedback">
					      Please provide a valid city.
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="validationCustom04" class="form-label">Autor</label>
					    <input type="text"
					    	name="autor" 
					    	class="form-control" 
					    	id="validationCustom03" 
					    	required>
					    <div class="invalid-feedback">
					      Please select a valid state.
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="validationCustom05" class="form-label">Imagen</label>
					    <div class="input-group">
						  <input type="file"
						  	name="img" 
						  	class="form-control" 
						  	id="inputGroupFile04" 
						  	aria-describedby="inputGroupFileAddon04" 
						  	aria-label="Upload">
						</div>
					    <div class="invalid-feedback">
					      Please provide a valid zip.
					    </div>
					  </div>
					  <div class="col-12">
					    <button class="btn btn-primary" type="submit">Nuevo</button>
					  </div>
					</form>
				</div>
			</div>
		</main>
		<jsp:include page="scripts.jsp"/>
	</body>
</html>