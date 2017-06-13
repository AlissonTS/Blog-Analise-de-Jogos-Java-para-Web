		<div class="modal fade" id="modal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h1 class="modal-title" id="myModalLabel" style="text-align: center">Cadastrar:</h1>
                    </div>
                    <div class="modal-body">
                        <div class="row">
							<div class="col-md-10 col-md-offset-1">
								<div class="form-group">
									<h3>Formulário de Cadastro:</h3>
									 <form role="form">
									  <div class="form-group">
										<label for="email">Email de Contato:</label>
										<input type="email" class="form-control" placeholder="Email@Email.com" id="email">
									  </div>	
									  <div class="form-group">
										<label for="nome">Nome para Usuário - Identificação no Sistema:</label>
										<input type="text" class="form-control" placeholder="Nome Usuário" id="nome">
									  </div>	 
									  <div class="form-group">
										<label for="pwd">Senha:</label>
										<input type="password" class="form-control" placeholder="Senha" id="pwd">
									  </div>
									  <div class="form-group">
										<label for="pwd2">Digite novamente a Senha:</label>
										<input type="password" class="form-control" placeholder="Digite novamente a Senha" id="pwd2">
									  </div>
									  <div class="form-group">
										<label for="data">Data de Nascimento:</label>
										<input type="text" class="form-control" name="data" placeholder="Data de Nascimento" id="data" required>
									  </div>	
									  <div class="form-group">
										<label for="ocupacao">Ocupação/Escolaridade do Usuário:</label>
										<input type="text" class="form-control" placeholder="Ocupação/Escolaridade" id="ocupacao">
									  </div>
									  <div class="form-group">
										 <label for="comment">Descrição do Usuário:</label>
										 <textarea class="form-control" rows="3" placeholder="Descrição" id="comment"></textarea>
									  </div>
									  <div class="checkbox">
										<label><input type="checkbox">Lembre-me</label>
									  </div>
									  <button type="submit" class="btn btn-default">Cadastrar</button>
									  <button type="reset" class="btn btn-default">Limpar Campos</button>
									</form>
								</div>
							</div>	
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>