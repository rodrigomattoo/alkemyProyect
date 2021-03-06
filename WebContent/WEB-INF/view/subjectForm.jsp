<%@ include file="libs.jsp"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<title>Insert title here</title>
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
		<h1>Insertar materias</h1>
		<form:form action="insertSubject" modelAttribute="subject"
			method="POST">
			<form:hidden path="id" />
			<div class="mb-3">
				<form:label path="name" class="form-label">Nombre</form:label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="mb-3">
				<form:select path="day" class="form-select">
					<form:option value="Lunes">Lunes</form:option>
					<form:option value="Martes">Martes</form:option>
					<form:option value="Miercoles">Miercoles</form:option>
					<form:option value="Jueves">Jueves</form:option>
					<form:option value="Viernes">Viernes</form:option>
					<form:option value="Sabado">Sabado</form:option>
				</form:select>
			</div>
			<div class="mb-3">
				<form:select path="schedule" class="form-select">
					<form:option value="Ma�ana">Ma�ana</form:option>
					<form:option value="Tarde">Tarde</form:option>
					<form:option value="Noche">Noche</form:option>
				</form:select>
			</div>
			<div class="mb-3">
				<form:label path="capacity" class="form-label">Cupo Maximo</form:label>
				<form:input path="capacity" class="form-control" />
			</div>
			<div class="mb-3">
				<form:label path="professorId" class="form-label">Profesor</form:label>
				<form:select path="professorId" class="form-select">
					<c:forEach var="varProfessor" items="${professors }">
						<form:option value="${varProfessor.id}">${varProfessor.name } ${varProfessor.lastName }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label">Descripcion</form:label>
				<form:textarea path="description" class="form-control" />
			</div>
			<div class="mb-3">
				<input type="submit" value="Insertar" class="btn btn-primary">
			</div>
		</form:form>
		<c:if test="${ERROR == 'Formulario invalido.'}">
			<div class="alert alert-danger" role="alert">${ERROR }</div>
		</c:if>
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