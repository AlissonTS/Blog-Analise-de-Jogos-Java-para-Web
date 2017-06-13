<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alterar Postagem - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuPrincipal.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<h3 class="page-header text-center">Alterar Postagem:</h3>
						
						<c:if test="${not empty msg}">
							<h4 class="page-header text-center">${msg}</h4>
						</c:if>
						
						<c:if test="${empty msg}">
							<c:if test="${not empty postagem}">
								<form role="form" action="concluirAlterarPostagem.html?codPost=${postagem.codPost}" method="POST">	
								  <div class="form-group">
									<label for="titulo">Título:</label>
									<input type="text" class="form-control" placeholder="Título" id="titulo" name="titulo" value="${postagem.titulo}" required maxlength="30">
								  </div>
								  <div class="form-group">
									<label for="nota">Nota para o Jogo:</label>
									<input type="number" min="0" max="10" step="0.1" value="${postagem.nota}" id="nota" name="nota" class="form-control" required>
								  </div>
								  <div class="form-group">
								  	<jsp:useBean id="plat" class="br.csi.dao.TipoPlataformaDao"/>
								  	<c:set value="${plat.listaPlataforma()}" var="t"/>
								  	
									<label for="plataforma">Tipos de Plataforma:</label> &nbsp
									
									<c:set var="verificador" value="1"/> 
								
									<c:forEach var="tudo" items="${t}">
									
										<c:forEach var="postagem" items="${plataformas}">
											<c:if test="${tudo.cod==postagem.cod}">
												<label class="checkbox-inline"><input type="checkbox" value="${tudo.cod}" name="plataforma" checked> 
												${tudo.nome}</label>
												<c:set var="verificador" value="2"/> 
											</c:if>
										</c:forEach>
										
										<c:choose>
											<c:when test="${verificador==1}">
											<label class="checkbox-inline"><input type="checkbox" value="${tudo.cod}" name="plataforma"> 
											${tudo.nome}</label>
											</c:when>
											
											<c:when test="${verificador==2}">
												<c:set var="verificador" value="1"/>
											</c:when>
										</c:choose>
			
									</c:forEach>
								  </div>
								   <div class="form-group">
								   	<jsp:useBean id="cat" class="br.csi.dao.TipoJogoDao"/>
									<c:set value="${cat.listaTipo()}" var="t"/>
									
									<label for="categoria">Categorias de Jogo:</label> &nbsp
									
									<c:set var="verificador" value="1"/> 
								
									<c:forEach var="tudo" items="${t}">
									
										<c:forEach var="postagem" items="${categorias}">
											<c:if test="${tudo.cod==postagem.cod}">
												<label class="checkbox-inline"><input type="checkbox" value="${tudo.cod}" name="categoria" checked> 
												${tudo.nome}</label>
												<c:set var="verificador" value="2"/> 
											</c:if>
										</c:forEach>
										
										<c:choose>
											<c:when test="${verificador==1}">
											<label class="checkbox-inline"><input type="checkbox" value="${tudo.cod}" name="categoria"> 
											${tudo.nome}</label>
											</c:when>
											
											<c:when test="${verificador==2}">
												<c:set var="verificador" value="1"/>
											</c:when>
										</c:choose>
			
									</c:forEach>
										
								  </div>
								  <div class="form-group">
									 <label for="descricao">Descrição:</label>
									 <textarea class="form-control" rows="3" placeholder="Descrição (700 Caracteres)" id="descricao" name="descricao" maxlength="700">${postagem.descricao}</textarea>
								  </div>	 
								  <button type="submit" class="btn btn-default">Alterar Postagem</button>
								  <button type="reset" class="btn btn-default">Resetar Campos</button>
								</form>
								<h4><b>Observação:</b></h4>
								<h5>Resetar Campos: Retorna aos dados de Postagem não editados...</h5>
							</c:if>	
						</c:if>
					</div>
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
	</body>
</html>