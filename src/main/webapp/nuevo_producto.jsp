<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="includes/inclu.jsp" />
</head>
<body>
	<jsp:include page="includes/head.jsp" />
	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h4 class="page-head-line">Nuevo Producto</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form action="grabarProductoAction">
						<label>Mac : </label> <input type="text" class="form-control"
							name="mac"> <label>Latitud : </label> <input type="text"
							class="form-control" name="latitud"> <label>Longitud
							: </label> <input type="text" class="form-control" name="longitud">
						<label>Correo : </label> <input type="radio" name="activarCorreo"
							value="true" checked="checked"> Activar &nbsp;&nbsp;
						&nbsp; <input type="radio" name="activarCorreo" value="false">
						Desactivar<br> <label>Alarma : </label> <input type="radio"
							name="activarSirena" value="true" checked="checked">
						Activar &nbsp;&nbsp; &nbsp; <input type="radio"
							name="activarSirena" value="false"> Desactivar<br>
						<label>Duracion : </label> <input type="text" class="form-control"
							name="duracion"> <input type="hidden" name="idCliente"
							value='<% out.print(request.getParameter("idCliente") );%>'>

						<hr>
						<button type="submit" class="btn btn-danger">
							<span class="glyphicon glyphicon-user"></span> &nbsp;Grabar
						</button>
						&nbsp;
					</form>
				</div>


			</div>
		</div>
	</div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>