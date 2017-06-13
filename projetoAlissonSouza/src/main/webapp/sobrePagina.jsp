<%@ include file="imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sobre a Página - WE Games</title>
		<%@ include file="imports/head.jsp" %>
		<link rel="stylesheet" href="css Pags/sobrePagina.css">	
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		<div class="container-fluid">
			
			<!-- <%@ include file="imports/header.jsp" %> -->
			
			<div class="row" style="margin-top: 1%">
				<div class="col-md-10 col-md-offset-1">
                    <h1 class="page-header text-center">
                        Sobre a Página:
                    </h1>
                </div>
            </div>
            <div class="row" style="text-align: justify; padding:15px;">
				<div class="col-md-10 col-md-offset-1">
                        <center><img class="img-responsive" style="border: 3px solid #D7D7D7" src="imagens/games.png" alt="" height="270" width="550" style="border-radius: 10px;"></center>
                        <h2 id="sobreh2">Finalidade da Página:</h2>
                        <p id="paragrafo">Atender aos usuários da internet com postagens inteligentes sobre dicas, análises de Games jogados pelos usuários
                            cadastrados. Este então é então um espaço destinado para postagens, para as pessoas que desejarem compartilhar o que acharam e o que sentiram 
                            ao jogar para outras pessoas.</p>
                        <p id="paragrafo">Aqui você poderá achar uma análise sobre um Game que você quer comprar, mas que não sabe como foi a aceitação
                            do público, se a história é cativante, se a jogabilidade é boa e que agrada ao seu estilo de jogo. Além da análise, da dica, você poderá ver informações do Game, como ano de lançamento, tipo de jogo, 
                            plataforma em que o Game foi jogado. Tudo isso é feito visando cada vez mais que as pessoas possam conhecer novos jogos, jogos antigos e expandir seus horizontes
                            e imaginação no mundo dos Games.</p>
                        <jsp:useBean id="visualizarTotal" class="br.csi.dao.AcessosDao"/>
									
						<c:set value="${ac.adicionarAcessos()}" var="incremento"/>    
                        <c:set value="${visualizarTotal.verAcessos()}" var="visualizar"/>  
                        
                        <c:if test="${not empty visualizar}">
                        	 <p id="paragrafo">Atualmente a página possui ${visualizar.acessosTotal} acessos totais!</p>
                        </c:if>
                         <c:if test="${empty visualizar}">
                        	 <p id="paragrafo">Atualmente a página não possui nenhum acesso!</p>
                        </c:if>      
                        <h3 id="sobreh3">Por: Alisson Trindade Souza - Administrador da Página</h3>
						
						<h3 class="page-header text-center" style="margin-top: 5%;">
	                        Comentários sobre a Página
	                    </h3>
						<div data-width="100%" class="fb-comments" data-href="http://localhost:8080/projetoAlissonSouza/sobrePagina.jsp"
						 	data-numposts="10">
						</div>
				</div>
            </div>
		</div>
		
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
		<%@ include file="imports/facebook.jsp" %>
	</body>
</html>