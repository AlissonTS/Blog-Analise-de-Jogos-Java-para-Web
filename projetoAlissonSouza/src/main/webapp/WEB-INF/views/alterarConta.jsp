<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alterar Conta Usu�rio - WE Games</title>
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
					<div class="form-group">
						<h3 class="page-header text-center">Alterar Conta:</h3>
						
						<c:if test="${not empty msg}">
							<h4 class="page-header text-center">${msg}</h4>
						</c:if>
						
						 <form role="form" action="alterarContaU.html?codigo=${usuarioLogado.codigo}" method="POST">	
						  <div class="form-group">
							<label for="email">Email de Contato:</label>
							<input type="email" class="form-control" placeholder="Email@Email.com" id="email" name="email" maxlength="40" 
							value="${usuarioLogado.email}" required>
						  </div>
						  <div class="form-group">
							<label for="nome">Nome Usu�rio:</label>
							<input type="text" class="form-control" placeholder="Nome Usu�rio" id="nome" name="nome" maxlength="40" 
							value="${usuarioLogado.nome}" required>
						  </div>			
						  <div class="form-group">
							<label for="senha">Senha:</label>
							<input class="form-control" type="password" id="senha" placeholder="Senha" name="senha" id="senha" 
							    value="${usuarioLogado.senha}" onblur="document.getElementById('senha').type = 'password'; " maxlength="20"
							    onclick="document.getElementById('senha').type = 'text';"
							    required/>  
						  </div>
						  <div class="form-group">
							<label for="senha2">Digite novamente a Senha para Confirma��o:</label>
							<input class="form-control" type="password" id="senha2" placeholder="Digite novamente a Senha"
								name="senha2" id="senha2" 
							    value="${usuarioLogado.senha}" onblur="document.getElementById('senha2').type = 'password'; " maxlength="20"
							    onclick="document.getElementById('senha2').type = 'text';" oninput="validaSenha(this)"
							  	required/>  
						  </div>
						  <div class="form-group">
							<label for="data">Data de Nascimento:</label>
							<input type="text" class="form-control" name="dataNasc" placeholder="Data de Nascimento" id="dataNasc"
							value="${usuarioLogado.dataNasc}" required>
						  </div>
						  <div class="form-group">
							<label for="ocupacao">Ocupa��o/Escolaridade do Usu�rio:</label>
							<input type="text" class="form-control" placeholder="Ocupa��o/Escolaridade" id="ocupacao" name="ocupacao" maxlength="60"
							value="${usuarioLogado.ocupacao}">
						  </div>
						  <div class="form-group">
							 <label for="descricao">Descri��o do Usu�rio:</label>
							 <textarea class="form-control" rows="3" placeholder="Descri��o" id="descricao" name="descricao" maxlength="200">
							 ${usuarioLogado.descricao}</textarea>
						  </div>	 
						  <button type="submit" class="btn btn-default">Alterar Conta</button>
						  <button type="reset" class="btn btn-default">Resetar Campos</button>
						</form>
						<h4><b>Observa��o:</b></h4>
						<h5>Email pode ser alterado, desde que n�o esteja cadastrado em outro usu�rio...</h5>
						<h5>Resetar Campos: Retorna aos dados de usu�rio n�o editados...</h5>
					</div>
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
	</body>
</html>