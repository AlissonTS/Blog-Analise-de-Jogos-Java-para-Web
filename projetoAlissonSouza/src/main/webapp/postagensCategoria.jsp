<%@ include file="imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Postagens Categoria - WE Games</title>
		<%@ include file="imports/head.jsp" %>
		<link rel="stylesheet" href="css Pags/index.css">	
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		
		<div class="container-fluid">
			<%@ include file="imports/header.jsp" %>
			
			<div class="row" style="margin-top: 1%">
                <div class="col-md-10 col-md-offset-1">
                    <h1 class="page-header text-center">
                        <c:if test="${not empty categoria}">
                        	Categoria: ${categoria.nome}
                        </c:if>
                        <c:if test="${empty categoria}">
                        	Categoria não Registrada!
                        </c:if>
                    </h1>
                </div>
            </div>
			<c:if test="${not empty categoria}">
				 <c:if test="${not empty pesquisaAviso}">
                  	<h3 class="page-header text-center">${pesquisaAviso}</h3>
                 </c:if>
				<c:if test="${not empty p}">
					<jsp:useBean id="usuario" class="br.csi.dao.UsuarioDao"/>
					
					<c:forEach var="postagem" items="${p}">
						<div class="row">
							<div class="col-md-10 col-md-offset-1">
								<div class="row" style="margin-top: 1%">
									<div class="col-md-10 col-md-offset-1" style="border-bottom-style: double; padding: 15px;">
										<h1 id="indexh1" class="page-header">${postagem.titulo}</h1>
										
										<c:set value="${usuario.nomeUsuario(postagem.codUsuario)}" var="n"/>
										<h2 id="indexh2">Autor: ${n.nome}</h2> 
										<h2 id="indexh2">Data da Criação - ${postagem.dataC}</h2>
										<!-- <div style="overflow: auto; width:200px">
											<p>${postagem.descricao}</p>
										</div> -->
										<form action="verPost.html?codPost=${postagem.codPost}" method="POST">
											<button class="btn btn-primary" style="float: right" type="submit">Veja Mais >></button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</c:if>
		</div>
		
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
	</body>
</html>