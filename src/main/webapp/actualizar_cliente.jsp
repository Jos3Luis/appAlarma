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
					<h4 class="page-head-line">Actualizar Cliente</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form action="actualizarClientePostAction">
						<input type="hidden" name="_id" value="<s:property value='_id' />">
						<label>Nombres : </label> <input type="text" class="form-control"
							name="nombres" value="<s:property value='nombres' />"> <label>A.
							Paterno : </label> <input type="text" class="form-control" name="paterno"
							value="<s:property value='paterno' />"> <label>A.
							Materno : </label> <input type="text" class="form-control" name="materno"
							value="<s:property value='materno' />"> <label>DNI
							: </label> <input type="text" class="form-control" name="dni"
							value="<s:property value='dni' />"> <label>Correo
							: </label> <input type="text" class="form-control" name="correo"
							value="<s:property value='correo' />"> <label>Celular
							: </label> <input type="text" class="form-control" name="celular"
							value="<s:property value='celular' />"> <label>Telefono
							: </label> <input type="text" class="form-control" name="telefono"
							value="<s:property value='telefono' />"> <label>Clave
							: </label> <input type="password" class="form-control" name="clave"
							value="<s:property value='clave' />">
						<hr>
						<button type="submit" class="btn btn-danger">
							<span class="glyphicon glyphicon-user"></span> &nbsp;Actualizar
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