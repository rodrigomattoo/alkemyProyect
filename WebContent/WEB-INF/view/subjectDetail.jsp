<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="libs.jsp"%>

<!DOCTYPE html>
<html>
<%@include file="head.jsp"%>
<title>Detalle de materia</title>
<body>
	<%@include file="navBar.jsp"%>
	<div class="container mt-5">
	<h1>Detalle de materia</h1>
	<form:form action="../registerInscription" modelAttribute="subject" method="post">
		<form:hidden path="id" />
		<div class="mb-3">
			<form:label path="name" class="form-label">Nombre</form:label>
			<form:input path="name" class="form-control" readonly="true"/>
		</div>
		<div class="mb-3">
			<form:label path="day" class="form-label">Dia</form:label>
			<form:input path="day" class="form-control" readonly="true"/>

		</div>
		<div class="mb-3">
			<form:label path="schedule" class="form-label">Dia</form:label>
			<form:input path="schedule" class="form-control" readonly="true"/>
		</div>
		<div class="mb-3">
			<form:label path="capacity" class="form-label">Cupo Maximo</form:label>
			<form:input path="capacity" class="form-control" readonly="true"/>
		</div>
		<div class="mb-3">
			<form:label path="professor.name" class="form-label">Profesor</form:label>
			<form:input path="professor.name" class="form-control" readonly="true"/>
			
		</div>
		<div class="mb-3">
			<form:label path="description" class="form-label">Descripcion</form:label>
			<form:textarea path="description" class="form-control" readonly="true"/>
		</div>
		<div class="mb-3">
			<input type="submit" value="Inscribirse" class="btn btn-primary">
		</div>
	</form:form>
	</div>

</body>
</html>