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
					<h4 class="page-head-line">Gestionar Clientes</h4>
				</div>
			</div>
			<div class="row">
				<a class="btn btn-success" href="nuevo_cliente.jsp">Nuevo
					Cliente</a> <br /> <br />
				<div class="col-md-12">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>NOMBRES</th>
								<th>PATERNO</th>
								<th>MATERNO</th>
								<th>CORREO</th>
								<th>CELULAR</th>
								<th>TELEFONO</th>
								<th>DNI</th>
								<th>F. CREACION</th>
								<th>ACCION</th>
							</tr>
						</thead>
						<s:iterator value="clientes">
							<tr>
								<td><s:property value="_id" /></td>
								<td><s:property value="nombres" /></td>
								<td><s:property value="paterno" /></td>
								<td><s:property value="materno" /></td>
								<td><s:property value="correo" /></td>
								<td><s:property value="celular" /></td>
								<td><s:property value="telefono" /></td>
								<td><s:property value="dni" /></td>
								<td><s:property value="fecha_creacion" /></td>
								<td><s:url action="eliminarClienteAction.action" var="elim">
										<s:param name="_id">
											<s:property value="_id" />
										</s:param>
									</s:url> <a href="<s:property value="#elim" />">Eliminar</a> | <s:url
										action="actualizarClienteAction.action" var="act">
										<s:param name="_id">
											<s:property value="_id" />
										</s:param>
									</s:url> <a href="<s:property value="#act" />">Actualizar</a> | <s:url
										action="listarProductosAction.action" var="pp">
										<s:param name="idCliente">
											<s:property value="_id" />
										</s:param>
									</s:url> <a href="<s:property value="#pp" />">Productos</a></td>
							</tr>
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