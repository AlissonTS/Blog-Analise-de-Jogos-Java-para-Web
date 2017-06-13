<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ver Usu�rio - WE Games</title>
		<%@ include file="imports/head.jsp" %>
		<link rel="stylesheet" href="css Pags/index.css">
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<h3 class="page-header text-center">Visualizar Usu�rio:</h3>
					<c:if test="${not empty usuario}">
						<h3 class="page-header text-center">Usu�rio: ${usuario.nome}</h3>		
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
							      <td>${usuario.email}</td>
							    </tr>
							    <tr>
							      <th scope="row">Nome</th>
							      <td>${usuario.nome}</td>
							    </tr>
							    <tr>
							      <th scope="row">Data de Nascimento</th>
							      <td>${usuario.dataNasc}</td>
							    </tr>
							    <tr>
							      <th scope="row">Ocupa��o/Escolaridade</th>
							      <td>${usuario.ocupacao}</td>
							    </tr>
							    <tr>
							      <th scope="row">Descri��o</th>
							      <td>${usuario.descricao}</td>
							    </tr>
							    <tr>
							      <th scope="row">Data de Cria��o da Conta</th>
							      <td>${usuario.dataCriacao}</td>
							    </tr>
							    <tr>
							      <th scope="row">Hor�rio de Cria��o da Conta</th>
							      <td>${usuario.horaCriacao}</td>
							    </tr>
							    <tr>
							      <th scope="row">Data da �ltima Modifica��o da Conta</th>
							      <td>${usuario.dataModific}</td>
							    </tr>
							    <tr>
							      <th scope="row">Hor�rio da �ltima Modifica��o da Conta</th>
							      <td>${usuario.horaModific}</td>
							    </tr>
							    <jsp:useBean id="usuarios" class="br.csi.dao.UsuarioDao"/>
							    <c:set value="${usuarios.quantidadePostagem(usuario.codigo)}" var="q"/>
							    
							    <tr>
							      <th scope="row">Quantidade de Postagens</th>
							     	<c:if test="${q>0}">
										<td>${q}</td>
									</c:if>
									<c:if test="${q==0}">
										<td>Nenhuma Postagem Cadastrada</td>
									</c:if>
							    </tr>
							  </tbody>
							</table>
						</div>
						<c:if test="${q>0}">	
							<h3 style="text-align: center"><b><a href="visualizarPostagensUsuario.html?codigo=${usuario.codigo}">Ver Postagens do Usu�rio</a></b></h3>
						</c:if>
					</c:if>
					<c:if test="${empty usuario}">
						<h3 class="page-header text-center">Nenhum Usu�rio Visualizado</h3>
					</c:if>
				</div>
			</div>
		</div>
		
		<%@ include file="imports/footer.jsp" %>
				
		<%@ include file="imports/script.jsp" %>
	</body>
</html>