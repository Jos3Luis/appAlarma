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
	<h2>Va a Cancelar el siguiente Incidente</h2>

	<form action="cancelarIncidentePostAction">
		<input type="hidden" name="_id" value="<s:property value="_id" />" />
		<h4>
			Fecha:
			<s:date name="fecha" format="dd/MM/yyyy" />
		</h4>
		<h4>
			Hora:
			<s:date name="hora" format="H:m:s" />
		</h4>
		<h4>
			Detalles:
			<s:property value="detalles" />
		</h4>
		<label>Detalles: </label>
		<textarea class="form-control" name="txtDetalles" rows="5" cols="3"></textarea>
		<br />
		<button type="submit" class="btn btn-danger">
			<span class="glyphicon glyphicon-user"></span> &nbsp;Guardar
		</button>
		&nbsp; <br />
	</form>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>