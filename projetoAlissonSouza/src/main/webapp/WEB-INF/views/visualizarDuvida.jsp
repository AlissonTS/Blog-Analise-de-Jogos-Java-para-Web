<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Visualizar Dúvida - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuAdmin.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<h3 class="page-header text-center">Visualizar Dúvida:</h3>
					
					<c:if test="${not empty msg}">
						<h4 class="page-header text-center">${msg}</h4>
					</c:if>
					
					<c:if test="${empty msg}">
						<c:if test="${not empty duvida}">
							<div class="table-responsive">
								<table class="display table text-center table table-bordered">
										<thead>
											<tr>
												<th class="text-center">Dúvida </th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><b>Email:</b> ${duvida.email}</td>
											</tr>	
											<tr>
												<td><b>Dúvida:</b> ${duvida.duvida}</td>
											</tr>
											<tr>
												<td><b>Resposta:</b>
													<c:if test="${not empty duvida.resposta}">
														${duvida.resposta}
													</c:if>
													<c:if test="${empty duvida.resposta}">
															Dúvida não respondida!
													</c:if>		
												</td>
											</tr>							
										</tbody>
								</table>
							</div>
							<c:if test="${empty duvida.resposta}">
								<p style="text-align: center"><a href="responderDuvida.html?codDuvida=${duvida.codDuvida}" title="Responder Dúvida">Responder Dúvida</a></p>
							</c:if>
						</c:if>	
						
						<c:if test="${empty duvida}">
							<h4 class="page-header text-center">Nenhuma Dúvida Visualizada</h4>
						</c:if>			
					</c:if>
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
		
	</body>
</html>