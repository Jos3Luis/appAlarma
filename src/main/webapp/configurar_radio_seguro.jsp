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
					<h4 class="page-head-line">Configurar Radio Seguro</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form action="actualizarClientePostAction">
						<input type="hidden" name="_id" value="<s:property value='_id' />">
						<label>Radio: </label> <input type="text" class="form-control"
							name="radioCliente" value="<s:property value='radioCliente' />">
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