<%@ include file="imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastro Concluído - WE Games</title>
		<%@ include file="imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		
		<div class="container-fluid">
			<!-- <%@ include file="imports/header.jsp" %> -->
			
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<c:if test="${not empty conta}">
						<h3 class="page-header text-center">Cadastro Concluído</h3>
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
							      <td>${conta.email}</td>
							    </tr>
							    <tr>
							      <th scope="row">Nome</th>
							      <td>${conta.nome}</td>
							    </tr>
							    <tr>
							      <th scope="row">Data de Nascimento</th>
							      <td>${conta.dataNasc}</td>
							    </tr>
							    <tr>
							      <th scope="row">Ocupação/Escolaridade</th>
							      <td>${conta.ocupacao}</td>
							    </tr>
							    <tr>
							      <th scope="row">Descrição</th>
							      <td>${conta.descricao}</td>
							    </tr>
							    <tr>
							      <th scope="row">Data de Criação da Conta</th>
							      <td>${conta.dataCriacao}</td>
							    </tr>
							    <tr>
							      <th scope="row">Horário de Criação da Conta</th>
							      <td>${conta.horaCriacao}</td>
							    </tr>
							    <tr>
							      <th scope="row">Data da Última Modificação da Conta</th>
							      <td>${conta.dataModific}</td>
							    </tr>
							    <tr>
							      <th scope="row">Horário da Última Modificação da Conta</th>
							      <td>${conta.horaModific}</td>
							    </tr>
							  </tbody>
							</table>
						</div>	
						<h3 style="text-align: center"><b><a href="login.html"> Fazer Login </a></b></h3>
					</c:if>
					<c:if test="${empty conta}">
						<h3 class="page-header text-center">Nenhum Cadastro</h3>
					</c:if>	
				</div>
            </div>	
		</div>
		
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
	</body>
</html>