<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/resources/css/estilos.css "
	type="text/css" rel="stylesheet">
</head>
<body>
	<h1>Profesores</h1>

	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>dni</th>
			<th></th>
		</tr>
		<c:forEach var="professor" items="${professors }">
			<c:url var="linkActualizar" value="/updateForm">
				<c:param name="professorId" value="${professor.id }"/>
			</c:url>
			<tr>
				<td>${professor.name }</td>
				<td>${professor.lastName}</td>
				<td>${professor.dni}</td>
				<td><a href="${linkActualizar }">Modificar</a></td>
			</tr>

		</c:forEach>
	</table>

	<input type="button" value="Agregar"
		onclick="window.location.href='professorForm'; return false;" />

</body>
</html>