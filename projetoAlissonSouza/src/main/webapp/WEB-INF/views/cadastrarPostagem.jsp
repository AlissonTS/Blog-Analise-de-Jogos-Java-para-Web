<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastrar Postagem - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuPrincipal.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<h3 class="page-header text-center">Cadastrar Postagem:</h3>
						 
						 <c:if test="${not empty msg}">
								<h4 class="page-header text-center">${msg}</h4>
						 </c:if>
						 	
						 <form role="form" action="adicionarPostagem.html?codUsuario=${usuarioLogado.codigo}" method="POST">	
						  <div class="form-group">
							<label for="titulo">Título:</label>
							<input type="text" class="form-control" placeholder="Título" id="titulo" name="titulo" required maxlength="30">
						  </div>
						  <div class="form-group">
							<label for="nota">Nota para o Jogo:</label>
							<input type="number" min="0" max="10" step="0.1" value="7" id="nota" name="nota" class="form-control" required>
						  </div>
						  <div class="form-group">
							<label for="plataforma">Tipos de Plataforma:</label>
							
							<jsp:useBean id="plataformas" class="br.csi.dao.TipoPlataformaDao"/>
							<c:set value="${plataformas.listaPlataforma()}" var="t"/>
							
							<c:if test="${not empty t}">
								<c:forEach var="tipo" items="${t}">
									<label class="checkbox-inline"><input type="checkbox" value="${tipo.cod}" name="plataforma">${tipo.nome} &nbsp</label>
								</c:forEach>
							</c:if>
							<c:if test="${empty t}">
			  					<label for="plataforma">Nenhuma Plataforma Cadastrada</label>
			  				</c:if>
			  				
						  </div>
						   <div class="form-group">
							<label for="categoria">Categorias de Jogo:</label>
							<jsp:useBean id="categorias" class="br.csi.dao.TipoJogoDao"/>
			  				<c:set value="${categorias.listaTipo()}" var="t"/>
			  				
			  				<c:if test="${not empty t}">
			  					<c:forEach var="tipo" items="${t}">
			  						<label class="checkbox-inline"><input type="checkbox" value="${tipo.cod}" name="categoria">${tipo.nome} &nbsp</label>
			  					</c:forEach>
			  				</c:if>
			  				<c:if test="${empty t}">
			  					<label for="categoria">Nenhuma Categoria Cadastrada</label>
			  				</c:if>
			  				
						  </div>
						  <div class="form-group">
							 <label for="descricao">Descrição:</label>
							 <textarea class="form-control" rows="3" placeholder="Descrição (700 caracteres)" id="descricao" name="descricao" maxlength="700"></textarea>
						  </div>	 
						  <button type="submit" class="btn btn-default">Inserir Postagem</button>
						  <button type="reset" class="btn btn-default">Limpar Campos</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
	</body>
</html>