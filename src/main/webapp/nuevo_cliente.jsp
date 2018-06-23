<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<h4 class="page-head-line">Nuevo Cliente</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form action="grabarClienteAction">
						<label>Nombres : </label> <input type="text" class="form-control"
							name="nombres"> <label>A. Paterno : </label> <input
							type="text" class="form-control" name="paterno"> <label>A.
							Materno : </label> <input type="text" class="form-control" name="materno">
						<label>DNI : </label> <input type="text" class="form-control"
							name="dni"> <label>Correo : </label> <input type="text"
							class="form-control" name="correo"> <label>Celular
							: </label> <input type="text" class="form-control" name="celular">
						<label>Telefono : </label> <input type="text" class="form-control"
							name="telefono"> <label>Clave : </label> <input
							type="password" class="form-control" name="clave">
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