<%@ include file="imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastrar - WE Games</title>
		<%@ include file="imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		
		<div class="container-fluid">
			<!-- <%@ include file="imports/header.jsp" %> -->
			
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<h3 class="page-header text-center">Formulário de Cadastro:</h3>
						
						<c:if test="${not empty msg}">
							<h4 class="page-header text-center">${msg}</h4>
						</c:if>
						
						 <form role="form" action="cadastrarUsuario.html" method="POST">
						  <div class="form-group">
							<label for="email">Email de Contato:</label>
							<input type="email" class="form-control" placeholder="Email@Email.com" id="email" name="email" maxlength="40" required>
						  </div>	
						  <div class="form-group">
							<label for="nome">Nome para Usuário - Identificação no Sistema:</label>
							<input type="text" class="form-control" placeholder="Nome Usuário" id="nome" name="nome" maxlength="40" required>
						  </div>	 
						  <div class="form-group">
							<label for="senha">Senha:</label>
							<input class="form-control" type="password" id="senha" placeholder="Senha" name="senha" id="senha" 
							    value="" onblur="document.getElementById('senha').type = 'password'; " maxlength="20"
							    onclick="document.getElementById('senha').type = 'text';" required/>  
						  </div>
						  <div class="form-group">
							<label for="senha2">Digite novamente a Senha para Confirmação:</label>
							<input class="form-control" type="password" id="senha2" placeholder="Digite novamente a Senha"
								name="senha2" id="senha2" 
							    value="" onblur="document.getElementById('senha2').type = 'password'; " maxlength="20"
							    onclick="document.getElementById('senha2').type = 'text';" oninput="validaSenha(this)" required/>  
						  </div>
						  <div class="form-group">
							<label for="dataNasc">Data de Nascimento:</label>
							<input type="text" class="form-control" name="dataNasc" placeholder="Data de Nascimento" id="dataNasc" name="dataNasc" required>
						  </div>	
						  <div class="form-group">
							<label for="ocupacao">Ocupação/Escolaridade do Usuário:</label>
							<input type="text" class="form-control" placeholder="Ocupação/Escolaridade" id="ocupacao" name="ocupacao" maxlength="60">
						  </div>
						  <div class="form-group">
							 <label for="descricao">Descrição do Usuário:</label>
							 <textarea class="form-control" rows="3" placeholder="Descrição (200 caracteres)" id="descricao" name="descricao" maxlength="200"></textarea>
						  </div>
						  <div style="text-align: center;"><button type="submit" class="btn btn-default">Cadastrar</button>
						  <button type="reset" class="btn btn-default">Limpar Campos</button></div>
						</form>
						<p style="margin-top:3%"><b>Importante!</b></p>
						<p>Apenas os campos Ocupação/Escolaridade do Usuário e Descrição do Usuário não são Obrigatórios</p>
					</div>
				</div>	
            </div>	
		</div>
		
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
	</body>
</html>