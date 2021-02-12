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
<title>Materias</title>
</head>
<body>

	<%@ include file='navBar.jsp'%>

	<div class="container mt-5">
		<h1>Materias</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Dia</th>
					<th scope="col">Horario</th>
					<th scope="col">Cupo Máximo</th>
					<th scope="col">Profesor</th>
					<th></th>
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
						<td>${subject.professorId }</td>
						<td><a class="btn btn-primary" href="${update}">Editar</a>
							<button class="btn btn-danger">Eliminar</button></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>

		<a class="btn btn-primary" href="subjectForm">Agregar</a>
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