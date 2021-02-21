<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<%@ include file='head.jsp'%>
<title>Profesores</title>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand">Alkemy</a>
			<form class="d-flex">
				<a class="btn btn-outline-success" href="logOut">Salir</a>
			</form>
		</div>
	</nav>
	<div class="container mt-5">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active"
				href="professorsList">Profesores</a></li>
			<li class="nav-item"><a class="nav-link" href="subjectsList">Materias</a></li>
		</ul>
	</div>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12 col-md-10 mb-3">
				<h3>Profesores</h3>
			</div>
			<div class="col-12 col-md-2">
				<a href="professorForm" class="btn btn-primary btn-block">Agregar</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">DNI</th>
					<th scope="col">Activo</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="professor" items="${professors }">
					<c:url var="update" value="updateProfessorForm">
						<c:param name="professorId" value="${professor.id }"></c:param>
					</c:url>
					<tr>
						<th scope="row">${professor.name }</th>
						<td>${professor.lastName }</td>
						<td>${professor.dni }</td>
						<td><c:choose>
								<c:when test="${professor.active == 1}">
									<i class="bi bi-check-circle"></i>
									<br />
								</c:when>
								<c:otherwise>
									<i class="bi bi-x-circle"></i>
									<br />
								</c:otherwise>
							</c:choose></td>
						<td><a class="btn btn-primary" href="updateProfessorForm/${professor.id }">Editar</a> <c:choose>
								<c:when test="${professor.active == 1}">
									<a class="btn btn-danger"
										href="deactivateProfessor/${professor.id }">Desactivar</a>
									<br />
								</c:when>
								<c:otherwise>
									<a class="btn btn-success"
										href="activateProfessor/${professor.id }">Activar</a>
									<br />
								</c:otherwise>
							</c:choose></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

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