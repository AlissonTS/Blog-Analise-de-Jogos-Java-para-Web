<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Recuperar Senha - WE Games</title>
		<%@ include file="imports/head.jsp" %>
	</head>
	<body>
		<%@ include file="imports/menu.jsp" %>
		
		<div class="container-fluid">
			<!-- <%@ include file="imports/header.jsp" %> -->
			
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<h3 class="page-header text-center">Recuperar Senha:</h3>	
						 <form role="form" action="mandarSenha.html" method="POST">
							  <div class="form-group">
								<label for="email">Email de Contato:</label>
								<input type="email" class="form-control" placeholder="Email@Email.com" id="email" name="email" required>
							  </div>
							  <div style="text-align: center;"><button type="submit" class="btn btn-default">Enviar</button></div>
						 </form>
						 <br>
						 <p style="margin-top: 2%"><b>Importante!</b></p>
						 <p style="font-size:15px">Será mandada uma senha gerada, assim você poderá acessar sua conta e alterá-la.</p>
					</div>
				</div>	
            </div>	
		</div>
		
		<%@ include file="imports/footer.jsp" %>
		
		<%@ include file="imports/script.jsp" %>
	</body>
</html>