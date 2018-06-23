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
					<h4 class="page-head-line">Lista de Productos</h4>
				</div>
			</div>
			<div class="row">
				<a class="btn btn-success"
					href="nuevo_producto.jsp?idCliente=<s:property value="idCliente"/>">Nuevo
					Producto</a> <br /> <br />
				<div class="col-md-12">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>ID</th>
								<th>MAC</th>
								<th>LATITUD</th>
								<th>LONGITUD</th>
								<th>CORREO</th>
								<th>ALARMA</th>
								<th>DURACION</th>
								<th>ESTADO</th>
								<th>ACCION</th>
							</tr>
						</thead>
						<% int nro=1; %>
						<s:iterator value="productos">
							<tr>
								<td><%=nro%></td>
								<td><s:property value="_id" /></td>
								<td><s:property value="mac" /></td>
								<td><s:property value="latitud" /></td>
								<td><s:property value="longitud" /></td>
								<td><s:property value="activarCorreo" /></td>
								<td><s:property value="activarSirena" /></td>
								<td><s:property value="duracion" /></td>
								<td><s:if test="%{estado==1}">
								ACTIVADO
								</s:if> <s:else>
								DESACTIVADO
								</s:else></td>
								<td><s:url action="eliminarProductoAction.action"
										var="elim" escapeAmp="false">
										<s:param name="_id">
											<s:property value="_id" />
										</s:param>
										<s:param name="idCliente">
											<s:property value="idCliente" />
										</s:param>
									</s:url> <a href="<s:property value="#elim" />"
									onclick="return confirm('Esta Seguro de Eliminar el Producto?')">Eliminar</a>
									| <s:url action="actualizarProductoAction.action" var="act">
										<s:param name="_id">
											<s:property value="_id" />
										</s:param>
									</s:url> <a href="<s:property value="#act" />">Actualizar</a> | <s:url
										action="desactivarProductoAction.action" var="ds"
										escapeAmp="false">
										<s:param name="_id">
											<s:property value="_id" />
										</s:param>
										<s:param name="idCliente">
											<s:property value="idCliente" />
										</s:param>
									</s:url> <a href="<s:property value="#ds" />"
									onclick="return confirm('Esta Seguro de Desactivar el Producto?')">Desactivar</a>
								</td>
							</tr>
							<% nro++;%>
						</s:iterator>
					</table>
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