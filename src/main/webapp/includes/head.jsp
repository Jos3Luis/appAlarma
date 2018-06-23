<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<header>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<strong>Email: </strong>winpcjose@gmail.com &nbsp;&nbsp; <strong>Support:
				</strong>947246045
			</div>

		</div>
	</div>
</header>
<!-- HEADER END-->
<div class="navbar navbar-inverse set-radius-zero">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp"> <img
				src="assets/img/logo.png" />
			</a>

		</div>

		<div class="left-div">
			<div class="user-settings-wrapper">
				<ul class="nav">

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" aria-expanded="false"> <span
							class="glyphicon glyphicon-user" style="font-size: 25px;"></span>
					</a>
						<div class="dropdown-menu dropdown-settings">
							<div class="media">
								<a class="media-left" href="#"> <img
									src="assets/img/64-64.jpg" alt="" class="img-rounded" />
								</a>
								<div class="media-body">
									<h4 class="media-heading">Jose Luis</h4>
									<h5>Developer & Designer</h5>

								</div>
							</div>
							<hr />
							<hr />
							<a href="#" class="btn btn-info btn-sm">Full Profile</a>&nbsp; <a
								href="login.html" class="btn btn-danger btn-sm">Logout</a>

						</div></li>


				</ul>
			</div>
		</div>
	</div>
</div>
<!-- LOGO HEADER END-->
<section class="menu-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<%
                 if(request.getParameter("bar")==null){
                %>
				<div class="navbar-collapse collapse ">
					<ul id="menu-top" class="nav navbar-nav navbar-right">
						<li><a class="menu-top-active" href="index.jsp">Inicio</a></li>
						<li><a href="consultarIncidentesAction">Incidentes</a></li>

					</ul>
				</div>
				<% } %>
			</div>

		</div>
	</div>
</section>
