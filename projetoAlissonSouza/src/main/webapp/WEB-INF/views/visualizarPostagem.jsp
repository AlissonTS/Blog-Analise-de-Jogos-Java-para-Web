<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Visualizar Postagem - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuPrincipal.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<h3 class="page-header text-center">Visualizar Postagem:</h3>
					
					<c:if test="${not empty msg}">
						<h4 class="page-header text-center">${msg}</h4>
					</c:if>
					
					<c:if test="${empty msg}">
						<c:if test="${not empty postagem}">
							<div class="table-responsive">
								<table class="display table text-center table table-bordered">
										<thead>
											<tr>
												<th class="text-center">Postagem </th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><b>Autor:</b> ${usuarioLogado.nome}</td>
											</tr>
											<tr>
												<td><b>Título:</b> ${postagem.titulo}</td>
											</tr>	
											<tr>
												<td><b>Nota:</b> ${postagem.nota}</td>
											</tr>
											<tr>
												<td><b>Categorias:</b>
													<c:if test="${not empty categorias}">
														<c:forEach var="c" items="${categorias}">
															${c.nome}, 
														</c:forEach>
													</c:if>
													<c:if test="${empty categorias}">
															Nenhuma Categoria Vinculada!
													</c:if>		
												</td>
											</tr>
											<tr>
												<td><b>Plataformas:</b>
													<c:if test="${not empty plataformas}">
														<c:forEach var="p" items="${plataformas}">
															${p.nome},  
														</c:forEach>
													</c:if>
													<c:if test="${empty plataformas}">
															Nenhuma Plataforma Vinculada!
													</c:if>		
												</td>
											</tr>	
											<tr>
												<td><b>Descrição:</b> ${postagem.descricao}</td>
											</tr>
											<tr>
												<td><b>Data da Criação:</b> ${postagem.dataC}</td>
											</tr>
											<tr>
												<td><b>Horário da Criação:</b> ${postagem.horarioC}</td>
											</tr>
											<tr>
												<td><b>Data da Última Modificação:</b> ${postagem.dataM}</td>
											</tr>
											<tr>
												<td><b>Horário da Última Modificação:</b> ${postagem.horarioM}</td>
											</tr>							
										</tbody>
								</table>
							</div>
								<p style="text-align: center"><a href="alterarPostagem.html?codPost=${postagem.codPost}" title="Alterar Postagem">Alterar Postagem</a></p>
						</c:if>	
						
						<c:if test="${empty postagem}">
							<h4 class="page-header text-center">Nenhuma Postagem Visualizada</h4>
						</c:if>	
					
					</c:if>		
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
		
	</body>
</html>