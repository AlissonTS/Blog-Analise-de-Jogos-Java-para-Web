<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gerenciar Dúvidas - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuAdmin.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<h3 class="page-header text-center">Gerenciar Dúvidas:</h3>
					
					<c:if test="${not empty msg}">
						<h4 class="page-header text-center">${msg}</h4>
					</c:if>
					
					<jsp:useBean id="duvidas" class="br.csi.dao.DuvidaDao"/>
					<c:if test="${empty d}">
						<c:set value="${duvidas.listaDuvida()}" var="d"/>	
						<c:if test="${not empty d}">
			  				<h4 class="page-header text-center">${d.size()} Dúvida(s) Enviada(s)</h4>
			  			</c:if>
			  			<c:if test="${empty d}">
			  				<h4 class="page-header text-center">Nenhuma Dúvida Enviada</h4>
			  			</c:if>
					</c:if>
					
		  			<c:if test="${not empty d}">
						
						<div>
							<form action="duvidasNaoRespondidas.html" style="padding: 15px; display: inline;">
		  						<button type="submit" class="btn btn-default">Dúvidas Não Respondidas</button>
		  					</form>
		  					<form action="duvidasRespondidas.html" style="padding: 15px; display: inline;">
		  						<button type="submit" class="btn btn-default">Dúvidas Respondidas</button>
		  					</form>
						</div>
						
						<br>
						
						<c:if test="${not empty pesquisaAviso}">
			            	<form action="gerenciarDuvidas.html" style="padding: 15px">
		  						<button type="submit" class="btn btn-default">Todas as Dúvidas</button>
		  					</form>
			  				<h4 class="page-header text-center">${pesquisaAviso}</h4>
			  			</c:if>
						
						<div class="table-responsive" style="height:500px; overflow:auto;">
							<table class="display table text-center table table-bordered">
								<thead>
									<tr>
										<th class="text-center">Email </th>
										<th class="text-center">Responder </th>
										<th class="text-center">Excluir </th>
										<th class="text-center">Visualizar </th>
									</tr>
								</thead>
								<tbody>
					  				<c:forEach var="duvida" items="${d}">
										<tr>
											<td>${duvida.email}</td>
											<c:if test="${not empty duvida.resposta}">
												<td>Dúvida Respondida</td>
											</c:if>
											<c:if test="${empty duvida.resposta}">
												<td><a href="responderDuvida.html?codDuvida=${duvida.codDuvida}" title="Responder Dúvida">Responder Dúvida</a></td>
											</c:if>
											<td><a class="btn btn-danger"
														href="excluirDuvida.html?codDuvida=${duvida.codDuvida}"
														title="Excluir Dúvida"><i class="fa fa-trash"></i></a></td>
											<td><a class="btn btn-success"
														href="visualizarDuvida.html?codDuvida=${duvida.codDuvida}"
														title="Visualizar Dúvida"><i class="fa fa-eye"></i></a></td>			
										</tr>
									</c:forEach>										
								</tbody>
							</table>
						</div>
					</c:if>
					<c:if test="${empty d}">
						<h4 class="page-header text-center">Nenhuma Dúvida Listada</h4>
					</c:if>			
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
		
	</body>
</html>