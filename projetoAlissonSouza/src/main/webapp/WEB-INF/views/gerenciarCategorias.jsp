<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gerenciar Categorias Jogos - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuAdmin.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<c:if test="${empty categoria}">
							<h3 class="page-header text-center">Adicionar Categoria de Jogo:</h3>
						</c:if>
						<c:if test="${not empty categoria}">
							<h3 class="page-header text-center">Alterar Categoria de Jogo:</h3>
						</c:if>
						<c:if test="${not empty msg}">
							<h4 class="page-header text-center">${msg}</h4>
						</c:if>
						<c:if test="${empty categoria}">
							<form role="form" action="adicionarCategoria.html" method="POST">
						</c:if>
						<c:if test="${not empty categoria}">
							<form role="form" action="concluirAlterarCategoria.html?cod=${categoria.cod}" method="POST">
						</c:if> 	
						  <div class="form-group">
							<label for="nome">Nome da Categoria:</label>
							<input type="text" class="form-control" placeholder="Nome Categoria" id="nome" name="nome" value="${categoria.nome}" required maxlength="30">
						  </div>
						  <c:if test="${empty categoria}">
							 <button type="submit" class="btn btn-default">Adicionar</button>
						  </c:if>
						  <c:if test="${not empty categoria}">
						      <button type="submit" class="btn btn-default">Alterar</button>
						  </c:if>
						  <button type="reset" class="btn btn-default">Limpar Campo</button> 	 
						</form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<h3 class="page-header text-center">Gerenciar Categorias de Jogo Cadastradas:</h3>
					<jsp:useBean id="categorias" class="br.csi.dao.TipoJogoDao"/>
			  			<c:if test="${empty t}">
			  				<c:set value="${categorias.listaTipo()}" var="t"/>
			  				<c:if test="${not empty t}">
				  				<h4 class="page-header text-center">${t.size()} Categoria(s) Cadastrada(s)</h4>
				  			</c:if>
				  			<c:if test="${empty t}">
				  				<h4 class="page-header text-center">Nenhuma Categoria Cadastrada</h4>
				  			</c:if>
			  			</c:if>
			  			<c:if test="${not empty t}">
			  				<br>
			  				<form class="navbar-form" role="search" method="POST" action="gerenciarCategoriasPesquisar.html">
				                <div class="input-group">
				                    <input type="text" class="form-control" placeholder="Digite o nome da Categoria Desejada" name="nome" id="nome" size="40" required>
				                    <div class="input-group-btn">
				                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
				                    </div>
				                </div>
				            </form>
				            <br>
				            
				            <c:if test="${not empty pesquisaAviso}">
				            	<form action="gerenciarCategorias.html" style="padding: 15px">
			  						<button type="submit" class="btn btn-default">Todas as Categorias</button>
			  					</form>
				  				<h4 class="page-header text-center">${pesquisaAviso}</h4>
				  			</c:if>
				             
							<div class="table-responsive" style="height:500px; overflow:auto;">
								<table class="display table text-center table table-bordered">
									<thead>
										<tr>
											<th class="text-center">Nome da Categoria </th>
											<th class="text-center">Alterar/Excluir </th>
										</tr>
									</thead>
									<tbody>
								  				<c:forEach var="tipo" items="${t}">
								  					<tr>	
														<td>${tipo.nome}</td>
														
														<td><a class="btn btn-success"
																	href="alterarCategoria.html?cod=${tipo.cod}&&nome=${tipo.nome}"
																	title="Alterar Categoria"><i class="fa fa-refresh"></i></a><i
																	class="fa fa-arrows-h"></i><a class="btn btn-danger"
																	href="excluirCategoria.html?cod=${tipo.cod}&&nome=${tipo.nome}"
																	title="Excluir Categoria"><i class="fa fa-trash"></i></a></td>
													</tr>	
								  				</c:forEach>
									</tbody>
								</table>
							</div>
						</c:if>
						<c:if test="${empty t}">
			   				<h4 class="page-header text-center">Nenhuma Categoria de Jogo Cadastrada!</h4>
			   			</c:if>	
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
		
	</body>
</html>