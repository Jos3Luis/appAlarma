<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="includes/inclu.jsp" />
</head>
<body>
	<jsp:include page="includes/head.jsp">
		<jsp:param name="bar" value="0" />
	</jsp:include>
	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h4 class="page-head-line">Login</h4>

				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<form action="loginAction.action">
						<label>DNI : </label> <input type="text" class="form-control"
							name="dni"> <label>Password : </label> <input
							type="password" class="form-control" name="clave">
						<hr>
						<button type="submit" class="btn btn-danger">
							<span class="glyphicon glyphicon-user"></span> &nbsp;Acceder
						</button>
						&nbsp;
					</form>
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