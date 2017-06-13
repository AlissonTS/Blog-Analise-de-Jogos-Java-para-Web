package br.csi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.csi.dao.DataDao;
import br.csi.dao.UsuarioDao;
import br.csi.model.Usuario;

@Controller
public class UsuarioController {
	
	@RequestMapping("cadastrarUsuario.html")
	public ModelAndView cadastrarUsuario(Usuario u, HttpServletRequest rq){ // CERTO
		System.out.println("-------------------------------");
		System.out.println("Entrou no Cadastrar Usu�rio...");
		
		String email = rq.getParameter("email");
		
		ModelAndView mv  = new ModelAndView("cadastroConta");
		
		if(email!=null){
			u.setEmail(rq.getParameter("email"));
			u.setNome(rq.getParameter("nome"));
			u.setSenha(rq.getParameter("senha"));
			u.setDataNasc(rq.getParameter("dataNasc"));
			u.setOcupacao(rq.getParameter("ocupacao"));
			u.setDescricao(rq.getParameter("descricao"));
			
			System.out.println();
			System.out.println("Dados de Cadastro:");
			System.out.println("Email: "+u.getEmail());
			System.out.println("Nome: "+u.getNome());
			System.out.println("Senha: "+u.getSenha());
			System.out.println("Data de Nascimento: "+u.getDataNasc());
			System.out.println("Ocupa��o/Escolaridade: "+u.getOcupacao());
			System.out.println("Descri��o: "+u.getDescricao());
			
			DataDao d = new DataDao();
			
			d.dataUsuarioCadastro(u);
			
			System.out.println("Data da Cria��o: "+u.getDataCriacao());
			System.out.println("Hora da Cria��o: "+u.getHoraCriacao());
			System.out.println("Data da Modifica��o: "+u.getDataModific());
			System.out.println("Hora da Modifica��o: "+u.getHoraModific());
			
			UsuarioDao uD = new UsuarioDao();
			
			try{
				boolean retorno = uD.cadastrarUsuario(u);
				
				if(retorno){
					mv = new ModelAndView("cadastroConcluido");
					mv.addObject("conta", u);
					mv.addObject("msg", "Cadastro feito com sucesso!");
					System.out.println("Cadastro Conclu�do!");
				}else{
					mv.addObject("msg", "Erro ao Cadastrar! Email j� Cadastrado!");
					System.out.println("Erro ao Cadastrar!");
				}
				
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Cadastrar! Email j� Cadastrado!");
				System.out.println("Erro ao Cadastrar!");	
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		
		// return "forward:cadastroConta.html"; // ou return "login.html"
	}
	
	@RequestMapping("cadastroConcluido.html")
	public String cadastroConcluido(){
		return "cadastroConcluido";
	}
	
	@RequestMapping("logar.html")
	public ModelAndView logar(Usuario u, HttpSession session){
		UsuarioDao uD = new UsuarioDao();
		
		boolean retorno = uD.verificarUsuario(u);
		
		ModelAndView mv  = new ModelAndView("login");
		
		if(retorno){
			System.out.println("-------------------------------");
			System.out.println("Entrou no Logar Usu�rio...");
			
			System.out.println();
			System.out.println("Dados de Login:");
			System.out.println("Email: "+u.getEmail());
			System.out.println("Senha: "+u.getSenha());
			
			u = uD.logar(u);
			
			session.setAttribute("usuarioLogado", u);
			
			System.out.println("Nome do Usu�rio: "+u.getNome());
			
			if(u.getCodigo()==1){
				mv = new ModelAndView("/WEB-INF/views/principalAdm");
			}
			else{
				mv = new ModelAndView("/WEB-INF/views/principal");
			}
			mv.addObject("conta", u);
			mv.addObject("msg", "Login Feito!!");
			System.out.println("Login efetuado!");	
			
		}else{
			System.out.println("Login n�o efetuado!");	
			mv.addObject("msg", "Erro ao Logar!");
			mv  = new ModelAndView("login");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		///WEB-INF/views/
		
		// return "forward:principal.html"; // ou return "forward:cadastroConta.html" ou "forward : principalAdm.html"
	}
	
	@RequestMapping("logout.html")
	public String logout(HttpSession session){
		
		session.invalidate();
		
		return "forward:paginaInicial.html";
	}
	
	@RequestMapping("principal.html")
	public String principal(){	
		return "/WEB-INF/views/principal";
	}
	
	@RequestMapping("principalAdm.html")
	public String principalAdm(){
		return "/WEB-INF/views/principalAdm";
	}
	
	@RequestMapping("recuperarSenha.html")
	public String recuperarSenha(){
		return "recuperarSenha";
	}
	
	@RequestMapping("mandarSenha.html")
	public String mandarSenha(Usuario u){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Recuperar Senha...");
		
		
		System.out.println("Email: "+u.getEmail());
		int s = (int) (Math.random() * 1000);
		String senha = Integer.toString(s);
		System.out.println(senha);
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return "forward:recuperarSenha.html";
	}
	
	@RequestMapping("gerenciarConta.html")
	public String gerenciarConta(){
		return "/WEB-INF/views/gerenciarConta";
	}
	
	@RequestMapping("alterarConta.html")
	public String alterarConta(){
		return "/WEB-INF/views/alterarConta";
	}
	
	@RequestMapping("alterarContaU.html")
	public ModelAndView alterarContaU(Usuario u, HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Alterar Usu�rio...");
		
		String email = rq.getParameter("email");
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/alterarConta");
		
		if(email!=null){
			System.out.println();
			System.out.println("Dados de Cadastro:");
			System.out.println("C�digo do Usu�rio: "+u.getCodigo());
			System.out.println("Email: "+u.getEmail());
			System.out.println("Nome: "+u.getNome());
			System.out.println("Senha: "+u.getSenha());
			System.out.println("Data de Nascimento: "+u.getDataNasc());
			System.out.println("Ocupa��o/Escolaridade: "+u.getOcupacao());
			System.out.println("Descri��o: "+u.getDescricao());
			
			
			DataDao d = new DataDao();
			
			d.dataUsuarioAlterar(u);
			
			System.out.println("Data da Modifica��o: "+u.getDataModific());
			System.out.println("Hora da Modifica��o: "+u.getHoraModific());
			
			UsuarioDao uD = new UsuarioDao();
			
			try{
				boolean retorno = uD.alterarUsuario(u);
				
				if(retorno){
					mv  = new ModelAndView("forward:setarSessao.html");
				}else{
					mv.addObject("msg", "Erro ao Alterar! Email j� Cadastrado!");
				}
				
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Alterar! Email j� Cadastrado!");
			}
			
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		
		///WEB-INF/views/
		
		// return "forward:alterarConta.html";
	}
	
	@RequestMapping("setarSessao.html")
	public ModelAndView setarSessao(Usuario u, HttpSession session){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Setar Sessao Usu�rio...");
		
		System.out.println();
		System.out.println("Dados de Login:");
		System.out.println("Email: "+u.getEmail());
		System.out.println("Senha: "+u.getSenha());
		
		UsuarioDao uD = new UsuarioDao();
		
		boolean retorno = uD.verificarUsuario(u);
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/gerenciarConta");
		
		if(retorno){
			u = uD.logar(u);
			
			session.setAttribute("usuarioLogado", u);
			
			mv.addObject("msg", "Altera��o feita com sucesso!");
			
			System.out.println("Nome do Usu�rio: "+u.getNome());
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		///WEB-INF/views/
		
		// return "forward:principal.html"; // ou return "forward:cadastroConta.html" ou "forward : principalAdm.html"
	}
	
	@RequestMapping("usuariosPesquisar.html")
	public ModelAndView usuariosPesquisar(HttpServletRequest rq){ // CERTO
		System.out.println("-------------------------------");
		System.out.println("Entrou no Pesquisar Usu�rio...");
		
		ModelAndView mv  = new ModelAndView("usuariosPagina");
		
		// System.out.println("Nome do Usu�rio: "+u.getNome());
		
		UsuarioDao uD = new UsuarioDao();
		
		ArrayList<Usuario> uA = new ArrayList<Usuario>();
		Usuario us = new Usuario();
		
		String u = rq.getParameter("nome");
		
		System.out.println("Nome: "+u);
		
		if(u!=null){
			us.setNome(u);
			
			boolean retorno = uD.verificadorNome(us);
			
			if(retorno){
				try{
					uA = uD.usuariosPesquisar(us);
					
					mv.addObject("pesquisaAviso", "Quantidade de Usu�rios Buscados: "+uA.size());
					mv.addObject("u", uA);
					
				}catch(Exception e){
					e.printStackTrace();
					mv.addObject("pesquisaAviso", "Erro ao Procurar Usu�rio!");
					System.out.println("Erro ao Procurar Usu�rio!");
				}	
			}else{
				mv  = new ModelAndView("usuariosPagina");
				mv.addObject("pesquisa", "Usu�rio n�o Encontrado!");
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("verUsuario.html")
	public ModelAndView verUsuario(Usuario u){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Visualizar Usuario...");
		
		ModelAndView mv  = new ModelAndView("verUsuario");
		
		System.out.println("C�digo do Usu�rio: "+u.getCodigo());
		
		UsuarioDao uD = new UsuarioDao();
		
		boolean retorno = uD.verificador(u);
		
		if(retorno){
			try{
				u = uD.visualizarUsuario(u);
				
				mv.addObject("usuario", u);
				System.out.println("Usu�rio Procurado com Sucesso!");
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Erro ao Procurar Usu�rio!");
				mv  = new ModelAndView("index");
			}
		}
		else{
			mv  = new ModelAndView("usuariosPagina");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
}
