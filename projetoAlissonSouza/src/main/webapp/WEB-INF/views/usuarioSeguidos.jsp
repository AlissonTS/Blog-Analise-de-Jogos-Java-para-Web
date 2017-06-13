<%@ include file="/imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Usuários Seguidos - WE Games</title>
		<%@ include file="/imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="/imports/menuPrincipal.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
						<h3 class="page-header text-center">
	                        Usuários Seguidos:
	                    </h3>
	                    <div class="table-responsive">
		                    <table class="text-center table table-bordered">
								<thead>
									<tr>
										<th class="text-center">Nome do Autor</th>
										<th class="text-center">Quantidade de Postagens </th>
										<th class="text-center">Usuário Desde </th>		
										<th class="text-center">Seguir/Deixar de Seguir </th>
										<th class="text-center">Visualizar Usuário </th>
									</tr>
								</thead>
								<tbody>
										<tr>
											<td>Alisson</td>
											<td>10</td>
											<td>02/05/2016</td>
											
											<td><a class="btn btn-success"
														href="#"
														title="Seguir"><i class="fa fa-thumbs-up"></i></a><i
														class="fa fa-arrows-h"></i><a class="btn btn-danger"
														href="#"
														title="Deixar de Seguir"><i class="fa fa-thumbs-down"></i></a></td>
											<td><a class="btn btn-success"
														href="#"
														title="Visualizar Usuário"><i class="fa fa-eye"></i></a></td>						
										</tr>	
								</tbody>
							</table>
						</div>
				</div>
			</div>
		</div>
		
		<%@ include file="/imports/footer.jsp" %>
				
		<%@ include file="/imports/script.jsp" %>
	</body>
</html>