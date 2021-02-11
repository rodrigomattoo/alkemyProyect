<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Alkemy</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Profesores</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Materias</a>
					</li>


				</ul>

				<div class="d-flex">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</div>

			</div>
		</div>
	</nav>

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