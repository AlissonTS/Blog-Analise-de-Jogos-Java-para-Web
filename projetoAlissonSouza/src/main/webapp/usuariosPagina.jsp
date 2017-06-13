<%@ include file="imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Usuários Página - WE Games</title>
		<%@ include file="imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		
		<div class="container-fluid">
			<!-- <%@ include file="imports/header.jsp" %> -->
			
			<div class="row" style="margin-top: 1%">
                <div class="col-md-10 col-md-offset-1">
                    <h3 class="page-header text-center">
                        Usuários da Página:
                    </h3>
                    
                    <jsp:useBean id="usuarios" class="br.csi.dao.UsuarioDao"/>
                    <c:if test="${empty u}">
		  				<c:set value="${usuarios.listaUsuarios()}" var="u"/>
		  				
		  				<c:if test="${not empty u}">
		  					<h4 class="page-header text-center">${u.size()} Usuário(s) Cadastrado(s)</h4>
		  				</c:if>
		  				<c:if test="${empty u}">
		  					<h4 class="page-header text-center">Nenhum Usuário Cadastrado!</h4>
		  				</c:if>
		  			</c:if>
		  			<c:if test="${not empty pesquisa}">
		  				<h4 class="page-header text-center">${pesquisa}</h4>
		  			</c:if>
		  			
		  			<c:if test="${not empty u}">
		  				<br>
		  				<form class="navbar-form" role="search" method="POST" action="usuariosPesquisar.html">
			                <div class="input-group">
			                    <input type="text" class="form-control" placeholder="Digite o nome do Usuário Desejado" name="nome" size="40" required>
			                    <div class="input-group-btn">
			                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			                    </div>
			                </div>
			            </form>
			            <br>
		  				
		  				<c:if test="${not empty pesquisaAviso}">
		  					<form action="usuariosPagina.html" style="padding: 15px">
		  						<button type="submit" class="btn btn-default">Todos os Usuários</button>
		  					</form>
			  				<h4 class="page-header text-center">${pesquisaAviso}</h4>
			  			</c:if>
		  				
		  				
		  				<!-- <div class="table-responsive" style="overflow: auto; width: auto; height: 500px;"> -->
	                    <div class="table-responsive" style="height:500px; overflow:auto;">
		                    <table class="text-center table table-bordered">
								<thead>
									<tr>
										<th class="text-center">Nome do Autor</th>
										<th class="text-center">Quantidade de Postagens </th>
										<th class="text-center">Usuário Desde </th>		
										<!--  <th class="text-center">Seguir/Deixar de Seguir </th> -->
										<th class="text-center">Visualizar Usuário </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="usuario" items="${u}">
										<tr>
											<td>${usuario.nome}</td>
											<c:set value="${usuarios.quantidadePostagem(usuario.codigo)}" var="q"/>
											
											<c:if test="${not empty q}">
												<td>${q}</td>
											</c:if>
											
											<td>${usuario.dataCriacao}</td>
											
											<!-- <td><a class="btn btn-success"
														href="#"
														title="Seguir"><i class="fa fa-thumbs-up"></i></a><i
														class="fa fa-arrows-h"></i><a class="btn btn-danger"
														href="#"
														title="Deixar de Seguir"><i class="fa fa-thumbs-down"></i></a></td> -->
											<td><a class="btn btn-success"
														href="verUsuario.html?codigo=${usuario.codigo}"
														title="Visualizar Usuário"><i class="fa fa-eye"></i></a></td>						
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
		  			</c:if>
		  			<c:if test="${empty u}">
		  				<h4 class="page-header text-center">Nenhum Usuário Cadastrado</h4>
		  			</c:if>
                </div>
            </div>
			
		</div>
		
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
	</body>
</html>