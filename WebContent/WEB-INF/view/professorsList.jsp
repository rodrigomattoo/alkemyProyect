<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<title>Profesores</title>
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
		<h1>Profesores</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">DNI</th>
					<th scope="col">Activo</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="professor" items="${professors }">
				
				<c:url var="update" value="updateForm">
				
				<c:param name="professorId" value="${professor.id }"></c:param>
				
				</c:url>
					<tr>
						<th scope="row">${professor.name }</th>
						<td>${professor.lastName }</td>
						<td>${professor.dni }</td>
						<td>${professor.active }</td>
						<td>
							<a class="btn btn-primary" href="${update}">Editar</a>
							<button class="btn btn-danger">Eliminar</button>
						</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
		
		<a class="btn btn-primary" href="professorForm" >Agregar</a>
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