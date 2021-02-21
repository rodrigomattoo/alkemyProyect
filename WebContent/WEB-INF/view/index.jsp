<%@ include file="libs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">
<title>Login</title>
</head>
<body class="text-center">
	<form:form action="login" modelAttribute="user" class="form-signin"
		method="POST">
		<h1 class="h3 mb-3 font-weight-normal">Inicie Sesión</h1>
		<form:label path="dni" class="sr-only" />
		<form:input path="dni" class="form-control"
			placeholder="Ingrese su numero de DNI" />
		<form:label path="file" class="sr-only" />
		<form:password path="file" id="file" class="form-control"
			placeholder="Ingrese su legajo" />
		<div>
			<button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Ingresar</button>
		</div>
		<div class="mt-3">
			<c:if test="${not empty ERROR }">
				<span>${ERROR }</span>
			</c:if>
		</div>
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
	</form:form>
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