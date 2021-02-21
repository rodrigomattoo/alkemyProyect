<%@include file="libs.jsp"%>
<!DOCTYPE html>
<html>
<%@ include file='head.jsp'%>
<title>Insert title here</title>
<body>
	<%@ include file='navBar.jsp'%>
	<div class="container">
		<h2>Navigation Tabs</h2>
		<p>Turn the nav menu into navigation tabs with the .nav nav-tabs
			class. Add the active class to the active/current link. If you want
			the tabs to be togglable, see the last example on the tutorial page.</p>
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active"
				href="professorsList">Profesores</a></li>
			<li class="nav-item"><a class="nav-link" href="subjectsList">Materias</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>
		</ul>
	</div>

</body>
</html>
<div class="container mt-5 d-flex justify-content-around">
	<c:if test="${ROL == 'admin' }">
		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Profesores</h5>
				<p class="card-text">Gestione desde aqui a todos sus profesores.</p>
				<a href="professorsList" class="btn btn-primary">Ver</a>
			</div>
		</div>
		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Materias</h5>
				<p class="card-text">Gestione desde aqui a todos sus profesores.</p>
				<a href="subjectsList" class="btn btn-primary">Ver</a>
			</div>
		</div>
	</c:if>
	<c:if test="${ROL == 'student' }">
		<a href="listAvailableSubjects">Materias disponibles</a>
		
			que muestre cuales con las materias disponibles.
			Entrar a la materia ver descripcion e informacion.
			Inscribirse en dicha materia.
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