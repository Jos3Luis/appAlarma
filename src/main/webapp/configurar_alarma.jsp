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
					<h4 class="page-head-line">Configurar Alarma</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form action="configurarAlarmaAction.action">
						<h2>Alarma</h2>
						<input type="radio" name="alarma" value="1"> Activar
						&nbsp;&nbsp; &nbsp; <input type="radio" name="alarma" value="0">
						Desactivar<br> Duracion: <input type="text" name="duracion"><br />
						<br />
						<button type="submit" class="btn btn-danger">
							<span class="glyphicon glyphicon-user"></span> &nbsp;Guardar
						</button>
						&nbsp; <br />
					</form>
				</div>


			</div>
		</div>
	</div>
	<s:if test="%{msg!=''}">
		<script type="text/javascript">
	alert("<s:property value='msg' />");
    </script>
	</s:if>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>