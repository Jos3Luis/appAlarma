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
				<div class="col-md-12"></div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form action="actualizarProductoPostAction">
						<input type="hidden" name="_id" value="<s:property value='_id' />">
						<label>Mac : </label> <input type="text" class="form-control"
							name="mac" value="mac"> <label>Latitud : </label> <input
							type="text" class="form-control" name="latitud"
							value='<s:property value="latitud"/>' /> <label>Longitud
							: </label> <input type="text" class="form-control" name="longitud"
							value='<s:property value="longitud"/>' /> <label>Correo
							: </label>
						<s:if test="%{activarCorreo=='true'}">
							<input type="radio" name="activarCorreo" value="true"
								checked="checked"> Activar &nbsp;&nbsp; &nbsp;
                      	<input type="radio" name="activarCorreo"
								value="false"> Desactivar<br>
						</s:if>
						<s:else>
							<input type="radio" name="activarCorreo" value="true"> Activar &nbsp;&nbsp; &nbsp;
	                      <input type="radio" name="activarCorreo"
								value="false" checked="checked"> Desactivar<br>
						</s:else>
						<label>Alarma : </label>
						<s:if test="%{activarSirena=='true'}">
							<input type="radio" name="activarSirena" value="true"
								checked="checked"> Activar &nbsp;&nbsp; &nbsp; 
	                      <input type="radio" name="activarSirena"
								value="false"> Desactivar<br>
						</s:if>
						<s:else>
							<input type="radio" name="activarSirena" value="true"> Activar &nbsp;&nbsp; &nbsp; 
	                    <input type="radio" name="activarSirena"
								value="false" checked="checked"> Desactivar<br>
						</s:else>
						<label>Duracion : </label> <input type="text" class="form-control"
							name="duracion" value='<s:property value="duracion"/>' /> <input
							type="hidden" name="idCliente"
							value='<s:property value="idCliente"/>'>
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