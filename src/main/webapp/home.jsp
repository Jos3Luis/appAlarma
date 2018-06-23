<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="includes/inclu.jsp" />
</head>
<body>
	<jsp:include page="includes/head.jsp" />
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<a href="consultarIncidentesAction.action" class="btn btn-success"><span
				class="glyphicon glyphicon-name"></span> CONSULTAR INCIDENTES</a> <a
				href="actualizarPerfilAction.action" class="btn btn-success"><span
				class="glyphicon glyphicon-name"></span> ACTUALIZAR PERFIL</a> <a
				href="" class="btn btn-success"><span
				class="glyphicon glyphicon-name"></span> CONFIGURAR ALARMA</a> <a
				href="" class="btn btn-success"><span
				class="glyphicon glyphicon-name"></span> CONFIGURAR RADIO SEGURO</a>
		</div>
		<div class="col-md-2"></div>
	</div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>