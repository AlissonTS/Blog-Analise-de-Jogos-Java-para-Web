package br.csi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.csi.dao.DataDao;
import br.csi.dao.PostagemDao;
import br.csi.dao.TipoJogoDao;
import br.csi.dao.TipoPlataformaDao;
import br.csi.dao.UsuarioDao;
import br.csi.model.Postagem;
import br.csi.model.Usuario;
import br.csi.model.tipoJogo;
import br.csi.model.tipoPlataforma;

@Controller
public class PostagemController {
		
	@RequestMapping("adicionarPostagem.html")
	public ModelAndView adicionarPostagem(Postagem p, HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Adicionar Postagem...");
		
		String titulo = rq.getParameter("titulo");
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/cadastrarPostagem");
		
		if(titulo!=null){
			System.out.println();
			System.out.println("Dados da Postagem:");
			System.out.println("Código do Usuário: "+p.getCodUsuario());
			System.out.println("Título: "+p.getTitulo());
			System.out.println("Nota: "+p.getNota());
			System.out.println("Descrição: "+p.getDescricao());
			
			if(p.getCategoria()!=null){
				System.out.println("Lista de Categorias: "+p.getCategoria().size());
				for(Long tJ : p.getCategoria()){
					System.out.println("Código: "+tJ);
				}
			}
			if(p.getPlataforma()!=null){
				System.out.println("Lista de Plataformas: "+p.getPlataforma().size());
				for(Long tP : p.getPlataforma()){
					System.out.println("Código: "+tP);
				}	
			}
			
			DataDao d = new DataDao();
			
			p = d.dataPostagemAdicionar(p);
			
			System.out.println("Data da Criação: "+p.getDataC());
			System.out.println("Hora da Criação: "+p.getHorarioC());
			System.out.println("Data da Modificação: "+p.getDataM());
			System.out.println("Hora da Modificação: "+p.getHorarioM());
			
			PostagemDao pD = new PostagemDao();
			
			try{
				boolean retorno = pD.adicionarPostagem(p);
				
				if(retorno){
					mv.addObject("msg", "Postagem Cadastrada com Sucesso!");
					System.out.println("Postagem Cadastrada com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Cadastrar Postagem!");
					System.out.println("Erro ao Cadastrar Postagem!");
				}
				
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Cadastrar Postagem!");
				System.out.println("Erro ao Cadastrar Postagem!");	
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		
		///WEB-INF/views/
		
		// return "forward:cadastrarPostagem.html"; // ou return "forward:gerenciarPostagens.html"
	}
	
	@RequestMapping("alterarPostagem.html")
	public ModelAndView alterarPostagem(Postagem p){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Alterar Postagem...");
		
		System.out.println();
		System.out.println("Código da Postagem: "+p.getCodPost());
		
		PostagemDao pD = new PostagemDao();
		TipoJogoDao tjD = new TipoJogoDao();
		TipoPlataformaDao tpD = new TipoPlataformaDao();
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/alterarPostagem");
		
		try{
			p = pD.visualizarPostagem(p);
			
			System.out.println("Título da Postagem: "+p.getTitulo());
			System.out.println("Nota: "+p.getNota());
			
			ArrayList<tipoJogo> tJ = new ArrayList<tipoJogo>();
			ArrayList<tipoPlataforma> tP = new ArrayList<tipoPlataforma>();
			
			tJ = tjD.visualizarCategorias(p);
			tP = tpD.visualizarPlataformas(p);
			
			mv.addObject("postagem", p);
			mv.addObject("categorias", tJ);
			mv.addObject("plataformas", tP);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Postagem não Cadastrada!");
			System.out.println("Postagem não Cadastrada!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		// return "forward:gerenciarPostagens.html";
	}
	
	@RequestMapping("concluirAlterarPostagem.html")
	public ModelAndView concluirAlterarPostagem(Postagem p, HttpServletRequest rq){	
		
		System.out.println("-------------------------------");
		System.out.println("Entrou no Concluir Alterar Postagem...");
		
		String titulo = rq.getParameter("titulo");
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/gerenciarPostagens");
		
		if(titulo!=null){
			System.out.println();
			System.out.println("Dados da Postagem:");
			System.out.println("Título: "+p.getTitulo());
			System.out.println("Nota: "+p.getNota());
			System.out.println("Descrição: "+p.getDescricao());
			
			DataDao d = new DataDao();
			
			p = d.dataPostagemAlterar(p);
			
			if(p.getCategoria()!=null){
				System.out.println("Lista de Categorias: "+p.getCategoria().size());
				for(Long tJ : p.getCategoria()){
					System.out.println("Código: "+tJ);
				}
			}
			if(p.getPlataforma()!=null){
				System.out.println("Lista de Plataformas: "+p.getPlataforma().size());
				for(Long tP : p.getPlataforma()){
					System.out.println("Código: "+tP);
				}	
			}
			
			PostagemDao pD = new PostagemDao();
			
			System.out.println("Data da Modificação: "+p.getDataM());
			System.out.println("Hora da Modificação: "+p.getHorarioM());
			
			try{
				boolean retorno = pD.alterarPostagem(p);
				
				if(retorno){
					mv.addObject("msg", "Postagem Alterada com Sucesso!");
					System.out.println("Postagem Alterada com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Alterar Postagem!");
					System.out.println("Erro ao Alterar Postagem!");
				}
				
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Alterar Postagem!");
				System.out.println("Erro ao Alterar Postagem!");	
			}
		}
		
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		
		// return "forward:gerenciarPostagens.html";
	}
	
	@RequestMapping("visualizarPostagem.html")
	public ModelAndView visualizarPostagem(Postagem p){	
		
		System.out.println("-------------------------------");
		System.out.println("Entrou no Visualizar Postagem...");
		
		System.out.println();
		System.out.println("Dado da Postagem:");
		System.out.println("Código: "+p.getCodPost());
		
		PostagemDao pD = new PostagemDao();
		TipoJogoDao tjD = new TipoJogoDao();
		TipoPlataformaDao tpD = new TipoPlataformaDao();
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/visualizarPostagem");
		
		try{
			p = pD.visualizarPostagem(p);
			
			ArrayList<tipoJogo> tJ = new ArrayList<tipoJogo>();
			ArrayList<tipoPlataforma> tP = new ArrayList<tipoPlataforma>();
			
			tJ = tjD.visualizarCategorias(p);
			tP = tpD.visualizarPlataformas(p);
			
			System.out.println("Código da Postagem: "+p.getCodPost());
			System.out.println("Título: "+p.getTitulo());
			
			mv.addObject("postagem", p);
			mv.addObject("categorias", tJ);
			mv.addObject("plataformas", tP);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Erro ao Visualizar Postagem!");
			System.out.println("Erro ao Visualizar Postagem!");	
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		// return "forward:gerenciarPostagens.html";
	}
	
	@RequestMapping("excluirPostagem.html")
	public ModelAndView excluirPostagem(Postagem p){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Excluir Postagem...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarPostagens");
		
		System.out.println("Código da Postagem: "+p.getCodPost());
		
		PostagemDao pD = new PostagemDao();
		
		try{
			boolean retorno = pD.excluirPostagem(p);
			
			if(retorno){
				mv.addObject("msg", "Postagem Excluída com Sucesso!");
				System.out.println("Postagem Excluída com Sucesso!");
			}else{
				mv.addObject("msg", "Erro ao Excluir Postagem!");
				System.out.println("Erro ao Excluir Postagem!");
			}
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Erro ao Excluir Postagem!");
			System.out.println("Erro ao Excluir Postagem!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("gerenciarPostagensPesquisar.html")
	public ModelAndView gerenciarPostagensPesquisar(HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Pesquisar Postagem do Gerenciar Postagens...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarPostagens");
		
		String titulo = rq.getParameter("titulo");
		
		Usuario u = (Usuario) rq.getSession().getAttribute("usuarioLogado");
		
		System.out.println("Código do Usuário: "+u.getCodigo());
		
		if(u.getCodigo()>1){
			System.out.println("Título da Postagem: "+titulo);
			System.out.println("Código do Usuário: "+u.getCodigo());
			
			PostagemDao pD = new PostagemDao();
			
			ArrayList<Postagem> pA = new ArrayList<Postagem>();
			
			Postagem pt = new Postagem();
			
			if(titulo!=null){
				titulo = titulo.toUpperCase();
				pt.setTitulo(titulo);
				pt.setCodUsuario(u.getCodigo());
				
				boolean retorno = pD.verificadorNome(pt);
				
				if(retorno){
					try{
						pA = pD.gerenciarPostagensPesquisar(pt);
						
						if(pA.size()>0){
							mv.addObject("pesquisaAviso", "Quantidade de Postagens Buscadas: "+pA.size());
							System.out.println("Quantidade de Postagens Buscadas: "+pA.size());
						}
						else{
							mv.addObject("pesquisaAviso", "Nenhuma Postagem Encontrada!");
						}
						mv.addObject("p", pA);
						
					}catch(Exception e){
						e.printStackTrace();
						mv.addObject("pesquisaAviso", "Erro ao Procurar Postagem!");
						System.out.println("Erro ao Procurar Postagem!");
					}
				}else{
					mv  = new ModelAndView("WEB-INF/views/gerenciarPostagens");
					mv.addObject("pesquisaAviso", "Nenhuma Postagem Encontrada!");
				}
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("verPost.html")
	public ModelAndView verPostagem(Postagem p){	
		
		System.out.println("-------------------------------");
		System.out.println("Entrou no Ver Postagem...");
		
		System.out.println();
		System.out.println("Dado da Postagem:");
		System.out.println("Código da Postagem: "+p.getCodPost());
		
		PostagemDao pD = new PostagemDao();
		TipoJogoDao tjD = new TipoJogoDao();
		TipoPlataformaDao tpD = new TipoPlataformaDao();
		
		ModelAndView mv  = new ModelAndView("verPostagem");
		
		try{
			p = pD.visualizarPostagem(p);
			
			ArrayList<tipoJogo> tJ = new ArrayList<tipoJogo>();
			ArrayList<tipoPlataforma> tP = new ArrayList<tipoPlataforma>();
			
			tJ = tjD.visualizarCategorias(p);
			tP = tpD.visualizarPlataformas(p);
			
			System.out.println("Código da Postagem: "+p.getCodPost());
			System.out.println("Título: "+p.getTitulo());
			System.out.println("Retorno...");
			
			mv.addObject("post", p);
			mv.addObject("cat", tJ);
			mv.addObject("plat", tP);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Erro ao Visualizar Postagem!");
			System.out.println("Erro ao Visualizar Postagem!");
			mv = new ModelAndView("index");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		System.out.println("Voltando por verPostagem");
		return mv;
		// return "index";
	}
	
	@RequestMapping("buscarPostagensCategoria.html") // CERTO
	public ModelAndView buscarPostagensCategoria(tipoJogo t){
		System.out.println("-------------------------------");
		System.out.println("Entrou no buscar Postagens Categoria...");
		
		ModelAndView mv  = new ModelAndView("postagensCategoria");
		
		System.out.println("Código da Categoria: "+t.getCod());
		
		PostagemDao pD = new PostagemDao();
		TipoJogoDao tD = new TipoJogoDao();
		
		ArrayList<Postagem> pA = new ArrayList<Postagem>();
		
		try{
			t = tD.buscarNome(t);
			System.out.println("Nome da Categoria:"+t.getNome());
			
			pA = pD.buscarPostagensCategoria(t);
			
			if(pA.size()>0){
				mv.addObject("pesquisaAviso", "Quantidade de Postagens Buscadas: "+pA.size());
			}
			else{
				mv.addObject("pesquisaAviso", "Nenhuma Postagem Encontrada!");
			}
			mv.addObject("categoria", t);
			mv.addObject("p", pA);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("pesquisaAviso", "Erro!");
			System.out.println("Erro!");
			mv = new ModelAndView("index");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("buscarPostagensPlataforma.html") // CERTO
	public ModelAndView buscarPostagensPlataforma(tipoPlataforma t){
		System.out.println("-------------------------------");
		System.out.println("Entrou no buscar Postagens Plataforma...");
		
		ModelAndView mv  = new ModelAndView("postagensPlataforma");
		
		System.out.println("Código da Plataforma: "+t.getCod());
		
		PostagemDao pD = new PostagemDao();
		TipoPlataformaDao tD = new TipoPlataformaDao();
		
		ArrayList<Postagem> pA = new ArrayList<Postagem>();
		
		try{
			t = tD.buscarNome(t);
			System.out.println("Nome da Plataforma:"+t.getNome());
			pA = pD.buscarPostagensPlataforma(t);
			
			if(pA.size()>0){
				mv.addObject("pesquisaAviso", "Quantidade de Postagens Buscadas: "+pA.size());
			}
			else{
				mv.addObject("pesquisaAviso", "Nenhuma Postagem Encontrada!");
			}
			mv.addObject("plataforma", t);
			mv.addObject("p", pA);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("pesquisaAviso", "Erro ao Procurar Postagem!");
			System.out.println("Erro ao Procurar Postagem!");
			mv = new ModelAndView("index");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("visualizarPostagensUsuario.html") //CERTO
	public ModelAndView visualizarPostagensUsuario(Usuario u){	
		
		System.out.println("-------------------------------");
		System.out.println("Entrou no Visualizar Postagens do Usuário...");
		
		System.out.println();
		System.out.println("Dados do Usuário:");
		System.out.println("Código: "+u.getCodigo());
		
		PostagemDao pD = new PostagemDao();
		UsuarioDao uD = new UsuarioDao();
		
		ModelAndView mv  = new ModelAndView("postagensUsuario");
		
		ArrayList<Postagem> p = new ArrayList<Postagem>();
		
		boolean retorno = uD.verificador(u);
		
		if(retorno){
			try{
				p = pD.visualizarPostagensUsuario(u);
				
				u = uD.nomeUsuario(u.getCodigo());
				
				mv.addObject("postagens", p);
				mv.addObject("usuario", u);
				
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Visualizar Postagens do Usuário!");
				System.out.println("Erro ao Visualizar Postagens do Usuário!");	
			}
		}else{
			mv  = new ModelAndView("usuariosPagina");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	/*
	@RequestMapping("pesquisaAutor.html") 
	public ModelAndView pesquisaAutor(String u, HttpServletRequest rq){	
		
		System.out.println("-------------------------------");
		System.out.println("Entrou no Visualizar Postagens Pesquisar Usuário...");
		
		u = rq.getParameter("nome");
		u = u.toUpperCase();
		
		UsuarioDao uD = new UsuarioDao();
		Usuario usu = new Usuario();
		
		ModelAndView mv  = new ModelAndView("buscaAvancada");
		
		if(u!=null){
			boolean retorno = uD.verificadorNome(u);
			
			System.out.println();
			System.out.println("Dados do Usuário:");
			System.out.println("Nome: "+u);
			
			PostagemDao pD = new PostagemDao();
			
			ArrayList<Postagem> p = new ArrayList<Postagem>();
			
			if(retorno){
				usu.setNome(u);
				
				try{
					p = pD.visualizarPostagensAutor(u);
					
					if(p.size()>0){
						mv.addObject("postagens", p);
					}
					mv.addObject("usuario", u);
					mv  = new ModelAndView("postagensAutor");
					
				}catch(Exception e){
					e.printStackTrace();
					mv.addObject("msg", "Erro ao Visualizar Postagens do Usuário!");
					System.out.println("Erro ao Visualizar Postagens do Usuário!");
					mv  = new ModelAndView("buscaAvancada");
				}
			}else{
				mv.addObject("msg", "Usuário Não Cadastrado!");
				System.out.println("Usuário Não Cadastrado!");
				mv  = new ModelAndView("buscaAvancada");
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	*/
}
