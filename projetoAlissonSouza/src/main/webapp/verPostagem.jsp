<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ver Postagem - WE Games</title>
		<%@ include file="imports/head.jsp" %>
		<link rel="stylesheet" href="css Pags/verPostagem.css">	
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		
		<div class="container-fluid">
			<%@ include file="imports/header.jsp" %>
			
			<c:if test="${not empty post}">
				<div class="row" style="margin-top: 1%">
                	<div class="col-md-10 col-md-offset-1">
	                    <h1 class="page-header text-center">
	                       	${post.titulo}
	                    </h1>
                	</div>
            	</div>
            	<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="row" style="margin-top: 1%">
							<div class="col-md-10 col-md-offset-1" style="padding: 15px;">
								<jsp:useBean id="usuario" class="br.csi.dao.UsuarioDao"/>
								<jsp:useBean id="acessos" class="br.csi.dao.AcessosDao"/>
									
								<c:set value="${usuario.nomeUsuario(post.codUsuario)}" var="n"/>
								<c:set value="${acessos.incrementoAcessosPost(post)}" var="a"/>
								
								<h2 id="indexh2">Autor: ${n.nome}</h2> 
								<h2 id="indexh2">Data: ${post.dataC} - ${post.horarioC}</h2>
								<h2 id="indexh2">Data da Última Modificação: ${post.dataM} - ${post.horarioM}</h2>
								<h2 id="indexh2">Nota sobre o Jogo: ${post.nota}</h2>
								<h2 id="indexh2">Categorias de Jogo:</h2>
								<center><p id="descricao" style="display: inline">
									<c:if test="${not empty cat}">
										<c:forEach var="c" items="${cat}">
											${c.nome}, 
										</c:forEach>
									</c:if>
									<c:if test="${empty cat}">
											Nenhuma Categoria Vinculada
									</c:if>
								</p></center>	
								<p></p>
								<h2 id="indexh2">Plataformas de Jogo:</h2>
								<center><p id="descricao" style="display: inline">
									<c:if test="${not empty plat}">
										<c:forEach var="c" items="${plat}">
											${c.nome}, 
										</c:forEach>
									</c:if>
									<c:if test="${empty plat}">
											Nenhuma Plataforma Vinculada
									</c:if>
								</p></center>
								<h2 id="indexh2">Descrição da Análise:</h2>
								<p id="descricao">${post.descricao}</p>		
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${empty postagem}">
				<div class="row" style="margin-top: 1%">
                	<div class="col-md-10 col-md-offset-1">
	                    <h1 class="page-header text-center">
	                       Nenhuma Postagem Visualizada!
	                    </h1>
		            	<c:if test="${not empty msg}">
		            		<h1 class="page-header text-center">${msg}</h1>	
		            	</c:if>
            		</div>
            	</div>
			</c:if>
		</div>	
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
	</body>
</html>