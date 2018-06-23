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
					<h4 class="page-head-line">Incidentes</h4>
				</div>
			</div>
			<div class="row">

				<div class="col-md-12">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>DETALLES</th>
								<th>FECHA</th>
								<th>HORA</th>
								<th>ESTADO</th>
								<th>ACCION</th>
							</tr>
						</thead>
						<s:iterator value="incidentes">
							<tr>
								<td><s:property value="_id" /></td>
								<td><s:property value="detalles" /></td>
								<td><s:property value="fecha" /></td>
								<td><s:date name="hora" format="H:m:s" /></td>
								<td><s:if test="%{estado==1}">
							REGISTRADO
							</s:if> <s:else>
							CANCELADO
							</s:else></td>
								<td><s:url action="cancelarIncidenteAction.action"
										var="canc">
										<s:param name="_id">
											<s:property value="_id" />
										</s:param>
									</s:url> <a href="<s:property value="#canc" />">Cancelar</a></td>
							</tr>
						</s:iterator>
					</table>
				</div>


			</div>
		</div>
	</div>
	<s:if test="%{msg!='' && msg!=null}">
		<script type="text/javascript">
	alert("<s:property value='msg' />");
    </script>
	</s:if>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>