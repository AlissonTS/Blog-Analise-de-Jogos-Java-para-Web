package br.csi.controller;

import java.io.IOException;
import java.util.logging.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.csi.model.Usuario;

public class AutenticacaoInterceptor extends HandlerInterceptorAdapter{

	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception, IOException {
		
		Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogado");
		String uri = request.getRequestURI();
		
		if(u!=null){
			if(u.getCodigo()!=1){
				if(uri.endsWith("gerenciarCategorias.html")
						|| uri.endsWith("gerenciarPlataformas.html")
						// || uri.endsWith("gerenciarDuvidas.html")
						|| uri.endsWith("principalAdm.html")
						|| uri.endsWith("logar.html")
						|| uri.endsWith("adicionarCategoria.html")
						|| uri.endsWith("alterarCategoria.html")
						|| uri.endsWith("concluirAlterarCategoria.html")
						|| uri.endsWith("excluirCategoria.html")
						|| uri.endsWith("gerenciarCategoriasPesquisar.html")
						| uri.endsWith("adicionarPlataforma.html")
						|| uri.endsWith("alterarPlataforma.html")
						|| uri.endsWith("concluirAlterarPlataforma.html")
						|| uri.endsWith("excluirPlataforma.html")
						|| uri.endsWith("gerenciarPlataformaPesquisar.html")
						
						){
					
					response.sendRedirect("principal.html");
					return false;
				}
			}
			if(u.getCodigo()==1){
				if (uri.endsWith("alterarPostagem.html")
					|| uri.endsWith("cadastrarPostagem.html")
					|| uri.endsWith("gerenciarPostagens.html") 
					|| uri.endsWith("principal.html")
					// || uri.endsWith("usuariosSeguidos.html")
					|| uri.endsWith("visualizarPostagem.html")
					|| uri.endsWith("logar.html")
					
					){
					
					response.sendRedirect("principalAdm.html");
					return false;
				}
			}
			if(uri.endsWith("cadastrarUsuario.html")
					|| uri.endsWith("cadastroConta.html")
					|| uri.endsWith("cadastroConcluido.html")){
				
				response.sendRedirect("paginaInicial.html");
				return false;
			}
		}
		
		if(u==null){
			if(uri.endsWith("alterarConta.html")
			|| uri.endsWith("alterarPostagem.html")
			|| uri.endsWith("cadastrarPostagem.html")
			|| uri.endsWith("gerenciarCategorias.html")
			|| uri.endsWith("gerenciarConta.html")
			|| uri.endsWith("gerenciarDuvidas.html")
			|| uri.endsWith("gerenciarPlataformas.html")
			|| uri.endsWith("gerenciarPostagens.html")
			|| uri.endsWith("principal.html")
			|| uri.endsWith("principalAdm.html")
			|| uri.endsWith("responderDuvida.html")
			|| uri.endsWith("usuarioSeguidos.html")
			|| uri.endsWith("visualizarDuvida.html")
			|| uri.endsWith("visualizarPostagem.html")
			|| uri.endsWith("adicionarPostagem.html")
			|| uri.endsWith("concluirAlterarPostagem.html")
			|| uri.endsWith("excluirPostagem.html")
			|| uri.endsWith("gerenciarPostagensPesquisar.html")
			|| uri.endsWith("adicionarCategoria.html")
			|| uri.endsWith("alterarCategoria.html")
			|| uri.endsWith("concluirAlterarCategoria.html")
			|| uri.endsWith("excluirCategoria.html")
			|| uri.endsWith("gerenciarCategoriasPesquisar.html")
			|| uri.endsWith("adicionarPlataforma.html")
			|| uri.endsWith("alterarPlataforma.html")
			|| uri.endsWith("concluirAlterarPlataforma.html")
			|| uri.endsWith("excluirPlataforma.html")
			|| uri.endsWith("gerenciarPlataformaPesquisar.html")
			|| uri.endsWith("alterarContaU.html")
			|| uri.endsWith("setarSessao.html")
			
			){
				response.sendRedirect("paginaInicial.html");
				return false;
			}
		}
		
		if(u!=null || u==null){
			if(uri.endsWith("buscaAvancada.html")
			|| uri.endsWith("duvida.html")
			|| uri.endsWith("recuperarSenha.html")
			|| uri.endsWith("enviarDuvida.html")
			|| uri.endsWith("duvidaRespondida.html")
			|| uri.endsWith("visualizarDuvida.html")
			|| uri.endsWith("excluirDuvida.html")
			|| uri.endsWith("responderDuvida.html")
			|| uri.endsWith("duvidasRespondidas.html")
			|| uri.endsWith("duvidasNaoRespondidas.html")
			|| uri.endsWith("mandeDuvida.html")
			|| uri.endsWith("mandarSenha.html")
			
			){
			
				
				response.sendRedirect("paginaInicial.html");
				return false;
			}
		}
		
		return true;
	}
	
}
