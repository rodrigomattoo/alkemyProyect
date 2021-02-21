<%@ include file='libs.jsp'%>
<!DOCTYPE html>
<html>
<%@ include file='head.jsp'%>
<title>Materias Disponibles</title>
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
		<h1>Materias Disponibles</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Dia</th>
					<th scope="col">Horario</th>
					<th scope="col">Cupo Máximo</th>
					<th scope="col">Profesor</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="subject" items="${list}">
					<tr>
						<th scope="row">${subject.name }</th>
						<td>${subject.day }</td>
						<td>${subject.schedule }</td>
						<td>${subject.availability }</td>
						<td>${subject.professor.fullName }</td>
						<td><a class="btn btn-warning"
							href="subjectDetail/${subject.id }">Ver Detalles</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<c:if	test="${DATA == 'Ya se encuentra inscripto en una materia en el mismo dia y horario.'}">
				<div class="alert alert-danger" role="alert">
					${DATA }
				</div>
			</c:if >
			<c:if	test="${DATA == 'Se ha Inscripto con exito.'}">
        		<div class="alert alert-success" role="alert">
					${DATA }
				</div>
        	</c:if >
		
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