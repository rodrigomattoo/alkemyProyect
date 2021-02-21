<%@ include file="libs.jsp"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<title>Insert title here</title>
<body>
	<%@ include file="navBar.jsp"%>
	<div class="container mt-5">
		<h1>Edicion de materias</h1>
		<form:form action="updateSubject" modelAttribute="subject" 	method="POST">
			<form:hidden path="id" />
			<form:hidden path="active" />
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
					<form:option value="Mañana">Mañana</form:option>
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
						<form:option  value="${varProfessor.id}">${varProfessor.name } ${varProfessor.lastName }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label">Descripcion</form:label>
				<form:textarea path="description" class="form-control" />
			</div>
			<div class="mb-3">
				<input type="submit" value="Guardar" class="btn btn-primary">
			</div>
		</form:form>
	</div>
</body>
</html>