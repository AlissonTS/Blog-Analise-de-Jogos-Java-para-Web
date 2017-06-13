	<div class="row">
		<div class="col-md-12">
			<footer class="footer-distributed">
				<div class="footer-left">
					<a style="text-decoration:none;" href="paginaInicial.html"><h3 style="color: white">WE<span>Games</span></h3></a>
					<p class="footer-links">
						<a href="paginaInicial.html">Página Inicial</a>
						·
						<a href="usuariosPagina.html">Usuários da Página</a>
						<c:if test="${empty usuarioLogado}">
							·
							<a href="cadastroConta.html">Cadastrar</a>
						</c:if>
						<!--
						<c:if test="${not empty usuarioLogado}">
							<c:if test="${usuarioLogado.codigo>1}">
								·
								<a href="mandeDuvida.html">Dúvidas</a>
							</c:if>
						</c:if>  -->	
						.	
						<a href="sobrePagina.html">Sobre a Página</a>
						·
					</p>
					<p class="footer-company-name">Desenvolvido por: Alisson Trindade Souza &copy; 2016</p>
				</div>
				<div class="footer-center">
					<div>
						<i class="fa fa-map-marker"></i>
						<p><span>Colégio Politécnico - UFSM - Avenida Roraima</span> Santa Maria, Brasil</p>
					</div>
					<div>
						<i class="fa fa-phone"></i>
						<p>+55 99 99999999</p>
					</div>
					<div>
						<i class="fa fa-envelope"></i>
						<p><a href="#">alissonts2010@hotmail.com</a></p>
					</div>
				</div>
				<div class="footer-right">
					<p class="footer-company-about">
						<span>Sobre a Página</span>
						Página destinada a postagens de jogos para computador (PC) e consoles!
					</p>
					<p class="footer-company-about" style="margin-top:3%;">
						<span>Redes Sociais</span>
					</p>
				 	<p style="text-align: center">
				 	<i class="fa fa-facebook-official" style="font-size:48px; color:rgb(83, 131, 211)"></i>
				 	<!--  <i class="fa fa-github" style="font-size:48px; color:rgb(83, 131, 211)"></i> -->
				 	<i class="fa fa-whatsapp" style="font-size:48px;color:rgb(83, 131, 211)"></i>
				 	</p>
				</div>
			</footer>
		</div>
	</div>		