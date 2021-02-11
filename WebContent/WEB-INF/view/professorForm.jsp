<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Carga de profesores.</h1>

	<form:form action="insertProfessor" modelAttribute="professor"
		method="POST">
		<table>


			<td><form:hidden path="id" /></td>


			<tr>
				<td>Nombre</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>DNI</td>
				<td><form:input path="dni" /></td>
			</tr>
			<tr colspan="2">
				<input type="submit" value="Insertar">
			</tr>
		</table>
	</form:form>
</body>
</html>