<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Responder Dúvida - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuAdmin.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<h3 class="page-header text-center">Responder Dúvida:</h3>
						
						<c:if test="${not empty msg}">
								<h4 class="page-header text-center">${msg}</h4>
						</c:if>
						
						<c:if test="${empty msg}">
							<c:if test="${not empty duvida}">
								 <form role="form" action="duvidaRespondida.html?codDuvida=${duvida.codDuvida}" method="POST">	
								  <div class="form-group">
									<label for="email">Email do Usuário:</label>
									<input type="email" class="form-control" placeholder="Email do Membro" id="email" name="email" value="${duvida.email}" readonly>
								  </div>
								  <div class="form-group">
									<label for="duvida">Dúvida do Usuário:</label>
									<textarea class="form-control" rows="3" placeholder="Dúvida do Usuário" id="duvida" name="duvida" readonly>${duvida.duvida}</textarea>
								  </div>	
								  <div class="form-group">
									<label for="resposta">Resposta ao Usuário:</label>
									<textarea class="form-control" rows="3" placeholder="Dúvida do Usuário" id="resposta" name="resposta" required></textarea>
								  </div> 
								  <button type="submit" class="btn btn-default">Responder</button>
								</form>
							</c:if>
							<c:if test="${empty duvida}">
								<h4 class="page-header text-center">Nenhuma Dúvida Selecionada para Responder</h4>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
		
	</body>
</html>