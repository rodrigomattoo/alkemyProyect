<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<%@ include file='head.jsp'%>
<title>Materias</title>
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
			<li class="nav-item"><a class="nav-link" href="professorsList">Profesores</a></li>
			<li class="nav-item"><a class="nav-link active"
				href="subjectsList">Materias</a></li>
		</ul>
	</div>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12 col-md-10 mb-3">
				<h3>Materias</h3>
			</div>
			<div class="col-12 col-md-2">
				<a href="subjectForm" class="btn btn-primary btn-block">Agregar</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Dia</th>
					<th scope="col">Horario</th>
					<th scope="col">Cupo Máximo</th>
					<th scope="col">Profesor</th>
					<th scope="col">Activo</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="subject" items="${subjects }">
					<c:url var="update" value="updateSubjectForm">
						<c:param name="subjectId" value="${subject.id }"></c:param>
					</c:url>
					<tr>
						<th scope="row">${subject.name }</th>
						<td>${subject.day }</td>
						<td>${subject.schedule }</td>
						<td>${subject.capacity }</td>
						<td>${subject.professor.name }</td>
						<td><c:choose>
								<c:when test="${subject.active == 1}">
									<i class="bi bi-check-circle"></i>
									<br />
								</c:when>
								<c:otherwise>
									<i class="bi bi-x-circle"></i>
									<br />
								</c:otherwise>
							</c:choose></td>
						<td><c:if test="${ROL == 'admin' }">
								<a class="btn btn-primary" href="${update}">Editar</a>
								<c:choose>
									<c:when test="${subject.active == 1}">
										<a class="btn btn-danger"
											href="deactivateSubject/${subject.id }">Desactivar</a>
										<br />
									</c:when>
									<c:otherwise>
										<a class="btn btn-success"
											href="activateSubject/${subject.id  }">Activar</a>
										<br />
									</c:otherwise>
								</c:choose>
							</c:if> <c:if test="${ROL == 'student' }">
								<a class="btn btn-warning" href="#">Incribirse</a></td>
						</c:if>
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