<!Doctype html>
<html>
	<head>
		<jsp:include page="styles.jsp"/>
		<script type="text/javascript">
			function verListado() {
				//http://localhost:8080/app-web/FindAllProductoController
				window.location = '<%=request.getContextPath()%>/FindAllProductoController';
			}
		</script>
	</head>
	<body>
		<!-- aca va el navbar.jsp -->
		<jsp:include page="navbar.jsp"/>
		<jsp:include page="scripts.jsp"/>
	</body>
</html>