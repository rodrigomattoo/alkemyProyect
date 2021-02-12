
<%@include file='libs.jsp'%>
<!DOCTYPE html>
<html>
<%@ include file = 'head.jsp' %>
<title>Formulario Profesor</title>
<body>

	<%@ include file='navBar.jsp'%>

	<div class="container mt-5">
		<h1>Carga de profesores</h1>

		<form:form action="insertProfessor" modelAttribute="professor"
			method="POST">



			<form:hidden path="id" />


			<div class="mb-3">
				<form:label path="name" class="form-label">Nombre</form:label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="mb-3">
				<form:label path="lastName" class="form-label">Apellido</form:label>
				<form:input path="lastName" class="form-control" />
			</div>
			<div class="mb-3">
				<form:label path="dni" class="form-label">DNI</form:label>
				<form:input path="dni" class="form-control" />
			</div>
			<div class="mb-3">
				<input type="submit" value="Insertar" class="btn btn-primary">
			</div>

		</form:form>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
		integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
		integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
		crossorigin="anonymous"></script>
</body>
</html>