<%@ include file="imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Aplicação - WE Games</title>
		<%@ include file="imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		
		<div class="container-fluid">
			<!-- <%@ include file="imports/header.jsp" %> -->
			
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<h3 class="page-header text-center">Login do Usuário:</h3>
						
						<c:if test="${not empty msg}">
							<h4 class="page-header text-center">${msg}</h4>
						</c:if>
							
						 <form role="form" action="logar.html" method="POST">
							  <div class="form-group">
								<label for="email">Email de Contato:</label>
								<input type="email" class="form-control" placeholder="Email@Email.com" name="email" id="email" required maxlength="40">
							  </div>
							  <div class="form-group">
								<label for="senha">Senha:</label>
								<input type="password" class="form-control" placeholder="Senha" name="senha" id="senha" required maxlength="20">
							  </div>
							  <div style="text-align: center;"><button type="submit" class="btn btn-default" style="align: center">Logar</button></div>
							  
							  <br>
						</form>
						<!--  <p style="margin-top:3%"><b>Esqueceu a Senha?</b>
						<a href="recuperarSenha.html"> Clique aqui para recuperá-la </a></p> -->
					</div>
				</div>	
            </div>	
		</div>
		
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
	</body>
</html>