<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gerenciar Plataformas Jogos - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuAdmin.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<c:if test="${empty plataforma}">
							<h3 class="page-header text-center">Adicionar Plataforma de Jogo:</h3>
						</c:if>
						<c:if test="${not empty plataforma}">
							<h3 class="page-header text-center">Alterar Plataforma de Jogo:</h3>
						</c:if>
						<c:if test="${not empty msg}">
							<h4 class="page-header text-center">${msg}</h4>
						</c:if>
						<c:if test="${empty plataforma}">
							<form role="form" action="adicionarPlataforma.html" method="POST">
						</c:if>
						<c:if test="${not empty plataforma}">
							<form role="form" action="concluirAlterarPlataforma.html?cod=${plataforma.cod}" method="POST">
						</c:if> 	
						  <div class="form-group">
							<label for="nome">Nome da Plataforma:</label>
							<input type="text" class="form-control" placeholder="Nome Categoria" id="nome" name="nome" value="${plataforma.nome}" required maxlength="30">
						  </div>
						  <c:if test="${empty plataforma}">
							 <button type="submit" class="btn btn-default">Adicionar</button>
						  </c:if>
						  <c:if test="${not empty plataforma}">
						      <button type="submit" class="btn btn-default">Alterar</button>
						  </c:if>
						  <button type="reset" class="btn btn-default">Limpar Campo</button> 	 
						</form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<h3 class="page-header text-center">Gerenciar Plataformas de Jogo Cadastradas:</h3>
					<jsp:useBean id="plataformas" class="br.csi.dao.TipoPlataformaDao"/>
						<c:if test="${empty t}">
							<c:set value="${plataformas.listaPlataforma()}" var="t"/>
							<c:if test="${not empty t}">
				  				<h4 class="page-header text-center">${t.size()} Plataforma(s) Cadastrada(s)</h4>
				  			</c:if>
				  			<c:if test="${empty t}">
				  				<h4 class="page-header text-center">Nenhuma Plataforma Cadastrada</h4>
				  			</c:if>
						</c:if>
			   			<c:if test="${not empty t}">
			   				<br>
			   				<form class="navbar-form" role="search" method="POST" action="gerenciarPlataformasPesquisar.html">
				                <div class="input-group">
				                    <input type="text" class="form-control" placeholder="Digite o nome da Plataforma Desejada" id="nome" name="nome" size="40" required>
				                    <div class="input-group-btn">
				                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
				                    </div>
				                </div>
				            </form>
			   				<br>
			   				<c:if test="${not empty pesquisaAviso}">
			   					<form action="gerenciarPlataformas.html" style="padding: 15px">
			  						<button type="submit" class="btn btn-default">Todas as Plataformas</button>
			  					</form>
				  				<h4 class="page-header text-center">${pesquisaAviso}</h4>
				  			</c:if>
				  			
		   					<div class="table-responsive" style="height:500px; overflow:auto;">
								<table class="text-center table table-bordered">
									<thead>
										<tr>
											<th class="text-center">Nome da Plataforma </th>
											<th class="text-center">Alterar/Excluir </th>
										</tr>
									</thead>
									<tbody>
										
								   				<c:forEach var="tipo" items="${t}">
												<tr>
													<td>${tipo.nome}</td>
													
													<td><a class="btn btn-success"
																href="alterarPlataforma.html?cod=${tipo.cod}&&nome=${tipo.nome}"
																title="Alterar Plataforma"><i class="fa fa-refresh"></i></a><i
																class="fa fa-arrows-h"></i><a class="btn btn-danger"
																href="excluirPlataforma.html?cod=${tipo.cod}&&nome=${tipo.nome}"
																title="Excluir Plataforma"><i class="fa fa-trash"></i></a></td>
												</tr>
												</c:forEach>	
									</tbody>
								</table>
							</div>
			   			</c:if>
			   			<c:if test="${empty t}">
			   				<h4 class="page-header text-center">Nenhuma Plataforma de Jogo Cadastrada!</h4>
			   			</c:if>
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
	</body>
</html>