package br.csi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.csi.dao.TipoJogoDao;
import br.csi.model.tipoJogo;

@Controller
public class TipoJogoController {
	
	@RequestMapping("adicionarCategoria.html")
	public ModelAndView enviarDuvida(tipoJogo t, HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Adicionar Categoria...");
		
		String nome = rq.getParameter("nome");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarCategorias");
		
		if(nome!=null){
			System.out.println();
			System.out.println("Dados da Categoria:");
			System.out.println("Nome: "+t.getNome());
			
			TipoJogoDao tD = new TipoJogoDao();
			
			try{
				boolean retorno = tD.cadastrarTipo(t);
				
				if(retorno){
					mv.addObject("msg", "Categoria Cadastrada com Sucesso!");
					System.out.println("Categoria Cadastrada com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Cadastrar Categoria!");
					System.out.println("Erro ao Cadastrar Categoria!");
				}
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Cadastrar Categoria!");
				System.out.println("Erro ao Cadastrar Categoria!");
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		// return "forward:gerenciarCategorias.html";
		
		return mv;
	}
	
	@RequestMapping("alterarCategoria.html")
	public ModelAndView alterarCategoria(HttpServletRequest rq, Long cod, String nome){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Alterar Categoria...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarCategorias");
		
		tipoJogo t = new tipoJogo();
		
		if(cod!=null && nome!=null){
			t.setCod(cod);
			t.setNome(nome);
		
			System.out.println("Código da Categoria: "+t.getCod());
			System.out.println("Nome da Categoria: "+t.getNome());
		
			mv.addObject("categoria", t);
		}
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}	
	
	@RequestMapping("concluirAlterarCategoria.html")
	public ModelAndView concluirAlterarCategoria(tipoJogo t, HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Concluir Alterar Categoria...");
		
		String nome = rq.getParameter("nome");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarCategorias");
		
		if(nome!=null){
			System.out.println("Código da Categoria: "+t.getCod());
			System.out.println("Nome da Categoria: "+t.getNome());
			
			TipoJogoDao tD = new TipoJogoDao();
			
			try{
				boolean retorno = tD.alterarTipo(t);
				
				if(retorno){
					mv.addObject("msg", "Categoria Alterada com Sucesso!");
					System.out.println("Categoria Alterada com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Alterar Categoria!");
					System.out.println("Erro ao Alterar Categoria!");
				}
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Alterar Categoria!");
				System.out.println("Erro ao Alterar Categoria!");
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println();
		}
		
		return mv;
	}	
	
	@RequestMapping("excluirCategoria.html")
	public ModelAndView excluirCategoria(HttpServletRequest rq, Long cod, String nome){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Excluir Categoria...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarCategorias");
		tipoJogo t = new tipoJogo();
		
		if(cod!=null && nome!=null){
			t.setCod(cod);
			t.setNome(nome);
			
			System.out.println("Código da Categoria: "+t.getCod());
			System.out.println("Nome da Categoria: "+t.getNome());
			
			TipoJogoDao tD = new TipoJogoDao();
			
			try{
				boolean retorno = tD.excluirTipo(t);
				
				if(retorno){
					mv.addObject("msg", "Categoria Excluída com Sucesso!");
					System.out.println("Categoria Excluída com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Excluir Categoria!");
					System.out.println("Erro ao Excluir Categoria!");
				}
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Excluir Categoria!");
				System.out.println("Erro ao Excluir Categoria!");
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("gerenciarCategoriasPesquisar.html")
	public ModelAndView gerenciarCategoriasPesquisar(HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Pesquisar Categoria do Gerenciar Categorias...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarCategorias");
		
		String u = rq.getParameter("nome");
		
		System.out.println("Nome da Categoria: "+u);
		
		TipoJogoDao tD = new TipoJogoDao();
		
		ArrayList<tipoJogo> tA = new ArrayList<tipoJogo>();
		
		tipoJogo tj = new tipoJogo();
		
		if(u!=null){
			tj.setNome(u);
			
			boolean retorno = tD.verificadorNome(tj);
			
			if(retorno){	
				try{
					tA = tD.gerenciarCategoriasPesquisar(tj);
					
					mv.addObject("pesquisaAviso", "Quantidade de Categorias Buscadas: "+tA.size());
					mv.addObject("t", tA);
					
				}catch(Exception e){
					e.printStackTrace();
					mv.addObject("pesquisaAviso", "Erro ao Procurar Categoria!");
					System.out.println("Erro ao Procurar Categoria!");
				}
				
			}else{
				mv  = new ModelAndView("WEB-INF/views/gerenciarCategorias");
				mv.addObject("pesquisaAviso", "Categoria não Encontrada!");
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
		
}
