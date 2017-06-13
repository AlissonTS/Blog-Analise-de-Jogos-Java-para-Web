<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gerenciar Conta Usuário - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<c:if test="${not empty usuarioLogado}">
		  	<c:if test="${usuarioLogado.codigo ne 1}">
				<%@ include file="/imports/menuPrincipal.jsp" %>
			</c:if>
			<c:if test="${usuarioLogado.codigo eq 1}">
				<%@ include file="/imports/menuAdmin.jsp" %>
			</c:if>
		</c:if>	
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<c:if test="${not empty usuarioLogado}">
					  	<c:if test="${usuarioLogado.codigo ne 1}">
							<h3 class="page-header text-center">Gerenciar Conta Usuário:</h3>
						</c:if>
						<c:if test="${usuarioLogado.codigo eq 1}">
							<h3 class="page-header text-center">Gerenciar Conta Administrador:</h3>
						</c:if>
					</c:if>
					<c:if test="${not empty msg}">
						<h4 class="page-header text-center">${msg}</h4>
					</c:if>			
					<div class="table-responsive">
						<table class="table table-striped">
						  <thead>
						    <tr>
						      <th scope="row">Campo</th>
						      <th>Dado</th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr>
						      <th scope="row">Email</th>
						      <td>${usuarioLogado.email}</td>
						    </tr>
						    <tr>
						      <th scope="row">Nome</th>
						      <td>${usuarioLogado.nome}</td>
						    </tr>
						    <tr>
						      <th scope="row">Data de Nascimento</th>
						      <td>${usuarioLogado.dataNasc}</td>
						    </tr>
						    <tr>
						      <th scope="row">Ocupação/Escolaridade</th>
						      <td>${usuarioLogado.ocupacao}</td>
						    </tr>
						    <tr>
						      <th scope="row">Descrição</th>
						      <td>${usuarioLogado.descricao}</td>
						    </tr>
						    <tr>
						      <th scope="row">Data de Criação da Conta</th>
						      <td>${usuarioLogado.dataCriacao}</td>
						    </tr>
						    <tr>
						      <th scope="row">Horário de Criação da Conta</th>
						      <td>${usuarioLogado.horaCriacao}</td>
						    </tr>
						    <tr>
						      <th scope="row">Data da Última Modificação da Conta</th>
						      <td>${usuarioLogado.dataModific}</td>
						    </tr>
						    <tr>
						      <th scope="row">Horário da Última Modificação da Conta</th>
						      <td>${usuarioLogado.horaModific}</td>
						    </tr>
						  </tbody>
						</table>
					</div>	
					<form role="form" action="alterarConta.html">
					 	<div style="text-align: center;"><button type="submit" class="btn btn-default" style="align: center">Alterar Conta</button></div>
					</form>
					
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
	</body>
</html>