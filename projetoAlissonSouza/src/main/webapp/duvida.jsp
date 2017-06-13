<%@ include file="imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mande sua Dúvida - WE Games</title>
		<%@ include file="imports/head.jsp" %>
	</head>
	<body>
		<c:if test="${not empty usuarioLogado}">
			<c:if test="${usuarioLogado.codigo>1}">
				<%@ include file="imports/menuPrincipal.jsp" %>
			</c:if>
		</c:if>	
		<c:if test="${empty usuarioLogado}">
			<%@ include file="imports/menu.jsp" %>
		</c:if>	
		<div class="container-fluid">
			<!-- <%@ include file="imports/header.jsp" %> -->
			
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<h3 class="page-header text-center">Mande sua Dúvida:</h3>	
						
						<c:if test="${not empty msg}">
							<h4 class="page-header text-center">${msg}</h4>
						</c:if>
						
						 <form role="form" action="enviarDuvida.html" method="POST">
							  <div class="form-group">
								<label for="email">Email de Contato:</label>
								<c:if test="${empty usuarioLogado}">
									<input type="email" class="form-control" placeholder="Email@Email.com" name="email" id="email" required>
								</c:if>
								<c:if test="${not empty usuarioLogado}">
									<input type="email" class="form-control" placeholder="Email@Email.com" name="email" id="email" required value="${usuarioLogado.email}" readonly>
								</c:if>
							  </div>
							  <div class="form-group">
								 <label for="duvida">Dúvida:</label>
								 <textarea class="form-control" rows="3" placeholder="Dúvida (Máximo 500 caracteres)" id="duvida" name="duvida" required></textarea>
							  </div>
							  <div style="text-align: center;"><button type="submit" class="btn btn-default">Enviar</button>
							  <button type="reset" class="btn btn-default">Limpar Campos</button></div>
						 </form>
						 <br>
						 <p style="margin-top: 2%"><b>Importante!</b></p>
						 <p style="font-size:15px">Resposta será enviada por Email o mais breve possível pela equipe de Suporte.</p>
					</div>
				</div>	
            </div>	
		</div>
		
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
	</body>
</html>