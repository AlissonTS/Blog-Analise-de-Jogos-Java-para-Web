<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gerenciar Postagens - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuPrincipal.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<h3 class="page-header text-center">Gerenciar Postagens Cadastradas:</h3> 
					
					<jsp:useBean id="postagens" class="br.csi.dao.PostagemDao"/>
					<c:if test="${empty p}">
			  			<c:set value="${postagens.listaPostagens(usuarioLogado.codigo)}" var="p"/>
			  			<c:if test="${not empty p}">
			  				<h4 class="page-header text-center">${p.size()} Postagem(ns) Cadastrada(s)</h4>
			  			</c:if>
			  			<c:if test="${empty p}">
			  				<h4 class="page-header text-center">Nenhuma Postagem Cadastrada</h4>
			  			</c:if>
		  			</c:if>
		  			<c:if test="${not empty p}">
		  				<br>
		  				<form class="navbar-form" role="search" method="POST" action="gerenciarPostagensPesquisar.html">
			                <div class="input-group">
			                    <input type="text" class="form-control" placeholder="Digite o Título da Postagem" name="titulo" size="40" required>
			                    <div class="input-group-btn">
			                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			                    </div>
			                </div>
			            </form> 
		  				<br>
		  				
		  				<c:if test="${not empty msg}">
			  				<h4 class="page-header text-center">${msg}</h4>
			  			</c:if>
		  				
		  				<c:if test="${not empty pesquisaAviso}">
		  					<form action="gerenciarPostagens.html" style="padding: 15px">
		  						<button type="submit" class="btn btn-default">Todas as Postagens</button>
		  					</form>
			  				<h4 class="page-header text-center">${pesquisaAviso}</h4>
			  			</c:if>
		  				
						<div class="table-responsive" style="height:500px; overflow:auto;">
							<table class="text-center table table-bordered">
								<thead>
									<tr>
										<th class="text-center">Título da Postagem </th>
										<th class="text-center">Data da Postagem </th>
										<th class="text-center">Data da Última Modificação </th>
										<th class="text-center">Quantidade de Visualizações </th>	
										<th class="text-center">Alterar/Excluir </th>
										<th class="text-center">Visualizar Postagem </th>
									</tr>
								</thead>
								<tbody>
									<jsp:useBean id="visualizarTotal" class="br.csi.dao.AcessosDao"/>				   
			           
									<c:forEach var="postagem" items="${p}">
										<tr>
											<c:set value="${visualizarTotal.verAcessosPost(postagem)}" var="visualizar"/>
											
											<td>${postagem.titulo}</td>
											<td>${postagem.dataC}</td>
											<td>${postagem.dataM}</td>
											
											<c:if test="${visualizar.acessosTotal>0}">
												<td>${visualizar.acessosTotal}</td>
											</c:if>
											<c:if test="${visualizar.acessosTotal eq 0}">
												<td>Nenhuma Visualização</td>
											</c:if>
											
											<td><a class="btn btn-success"
														href="alterarPostagem.html?codPost=${postagem.codPost}"
														title="Alterar Postagem"><i class="fa fa-refresh"></i></a><i
														class="fa fa-arrows-h"></i><a class="btn btn-danger"
														href="excluirPostagem.html?codPost=${postagem.codPost}"
														title="Excluir Postagem"><i class="fa fa-trash"></i></a></td>
											<td><a class="btn btn-success"
														href="visualizarPostagem.html?codPost=${postagem.codPost}"
														title="Visualizar Postagem"><i class="fa fa-eye"></i></a></td>						
										</tr>	
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
	</body>
</html>