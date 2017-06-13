<%@ include file="imports/docType.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Busca Avançada - WE Games</title>
		<%@ include file="imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		
		<div class="container-fluid">
			<!-- <%@ include file="imports/header.jsp" %> -->
			
			<div class="row" style="margin-top: 1%">
                <div class="col-md-10 col-md-offset-1">
                    <h3 class="page-header text-center">
                        Busca Avançada:
                    </h3>
                </div>
            </div>
            <div class="row" style="margin-top: 1%">
                <div class="col-md-10 col-md-offset-1">
                	<div class="table-responsive">
	                    <table class="text-center table table-bordered">
							<thead>
								<tr>
									<th class="text-center" colspan="5" scope="row">Pesquisar por:</th>
								</tr>
							</thead>
							<tbody>
									<tr>
										<td><button data-toggle="modal" data-target="#modalT" class="btn btn-default">Título</button></td>
										<td><button data-toggle="modal" data-target="#modalN" class="btn btn-default">Nota</button></td>
										<td><button data-toggle="modal" data-target="#modalA" class="btn btn-default">Autor</button></td>			
									</tr>	
							</tbody>
						</table>
					</div>
                </div>
            </div>
			
		</div>
		
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="modals/modalBusca.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
	</body>
</html>