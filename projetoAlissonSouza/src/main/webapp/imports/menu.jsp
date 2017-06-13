	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-inverse" role="navigation" style="border-radius: 0px">		
			<!-- <nav class="navbar navbar-default" role="navigation"> -->
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
						</button>	
						<!-- <a class="navbar-brand" href="index.jsp"><h3 style="color: black">WE<span>Games</span></h3></a> -->
						<a class="navbar-brand" href="paginaInicial.html"><h3 style="color: white">WE<span>Games</span></h3></a>
					</div>
					<div class="collapse navbar-collapse" id="myNavbar">
						<ul class="nav navbar-nav navbar-right">
						  <!-- <li class="active"><a href="paginaInicial.html">Página Inicial</a></li> -->
						  <li><a href="paginaInicial.html">Página Inicial</a></li>
						  
						  		<jsp:useBean id="categorias" class="br.csi.dao.TipoJogoDao"/>
						  		<c:set value="${categorias.listaTipo()}" var="t"/>
						  			
						  		<c:if test="${not empty t}">
						  			<li class="dropdown">
						  			<a href="#" class="dropdown-toggle" data-toggle="dropdown">Categorias de Jogos<b class="caret"></b></a>
										<ul class="dropdown-menu">
											<c:forEach var="tipo" items="${t}">
												<li>
													<a href="buscarPostagensCategoria.html?cod=${tipo.cod}">${tipo.nome}</a>
												</li>
											</c:forEach>
										</ul>
								   </li>
						  		</c:if>
					   		<jsp:useBean id="plataformas" class="br.csi.dao.TipoPlataformaDao"/>
					   		<c:set value="${plataformas.listaPlataforma()}" var="t"/>
					   		
					   		<c:if test="${not empty t}">
						   		<li class="dropdown">
						   			<a href="#" class="dropdown-toggle" data-toggle="dropdown">Plataformas<b class="caret"></b></a>
										<ul class="dropdown-menu">
											<c:forEach var="plataforma" items="${t}">
												<li>
													<a href="buscarPostagensPlataforma.html?cod=${plataforma.cod}">${plataforma.nome}</a>
												</li>
											</c:forEach>
										</ul>
								</li>		
					   		</c:if>
					   		
						  <!--  <li><a href="buscaAvancada.html">Busca Avançada</a></li> -->
						  <li><a href="usuariosPagina.html">Usuários da Página</a></li>
						  <li><a href="sobrePagina.html">Sobre a Página</a></li>
						  
						  <!--
						  <c:if test="${empty usuarioLogado}">
								  <li><a href="#" data-toggle="modal" data-target="#modal"><span class="glyphicon glyphicon-envelope"></span> Mande sua Dúvida</a></li>
								  <li><a href="mandeDuvida.html"><span class="glyphicon glyphicon-envelope"></span> Mande sua Dúvida</a></li>
						  </c:if>  -->
						  
						  <c:if test="${empty usuarioLogado}">	
							  <!-- <li><a href="#" data-toggle="modal" data-target="#modal2"><span class="glyphicon glyphicon-user"></span> Cadastrar</a></li> -->
							  <li><a href="cadastroConta.html"><span class="glyphicon glyphicon-user"></span> Cadastrar</a></li>
							  <!-- <li><a href="#" data-toggle="modal" data-target="#modal3"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
							  <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
						  </c:if>
						  
						  <c:if test="${not empty usuarioLogado}">
						  	  <c:if test="${usuarioLogado.codigo>1}">	
						  	  	<li><a href="principal.html"><span class="glyphicon glyphicon-log-in"></span> Página do Usuário</a></li>
						  	  </c:if>
						  	  <c:if test="${usuarioLogado.codigo eq 1}">	
						  	  	<li><a href="principalAdm.html"><span class="glyphicon glyphicon-log-in"></span> Página do Administrador</a></li>
						  	  </c:if>
						  	  <li><a href="logout.html"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>	
						  </c:if> 	 
						   
						 </ul>
					  </div>
				</div>  
			</nav>
		</div>
	</div>
	<jsp:useBean id="ac" class="br.csi.dao.AcessosDao"/>
									
	<c:set value="${ac.adicionarAcessos()}" var="incremento"/>
			