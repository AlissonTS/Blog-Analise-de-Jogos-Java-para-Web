package br.csi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.csi.dao.TipoPlataformaDao;
import br.csi.model.tipoJogo;
import br.csi.model.tipoPlataforma;

@Controller
public class TipoPlataformaController {

	@RequestMapping("adicionarPlataforma.html")
	public ModelAndView enviarDuvida(tipoPlataforma t, HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Adicionar Plataforma...");
		
		String nome = rq.getParameter("nome");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarPlataformas");
		
		if(nome!=null){
			System.out.println();
			System.out.println("Dados da Plataforma:");
			System.out.println("Nome: "+t.getNome());
			
			TipoPlataformaDao tP = new TipoPlataformaDao();
			
			try{
				boolean retorno = tP.cadastrarPlataforma(t);
				
				if(retorno){
					mv.addObject("msg", "Plataforma Cadastrada com Sucesso!");
					System.out.println("Plataforma Cadastrada com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Cadastrar Plataforma!");
					System.out.println("Erro ao Cadastrar Plataforma!");
				}
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Cadastrar Plataforma!");
				System.out.println("Erro ao Cadastrar Plataforma!");
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		// return "forward:gerenciarPlataformas.html";
		
		return mv;
	}
	
	@RequestMapping("alterarPlataforma.html")
	public ModelAndView alterarPlataforma(HttpServletRequest rq, Long cod, String nome){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Alterar Plataforma...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarPlataformas");
		
		tipoPlataforma t = new tipoPlataforma();
		
		if(cod!=null && nome!=null){
			t.setCod(cod);
			t.setNome(nome);
			
			System.out.println("Código da Plataforma: "+t.getCod());
			System.out.println("Nome da Plataforma: "+t.getNome());
			
			mv.addObject("plataforma", t);
		}	
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("concluirAlterarPlataforma.html")
	public ModelAndView concluirAlterarPlataforma(tipoPlataforma t, HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Concluir Alterar Plataforma...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarPlataformas");
		
		String nome = rq.getParameter("nome");
		
		if(nome!=null){
			
			System.out.println("Código da Plataforma: "+t.getCod());
			System.out.println("Nome da Plataforma: "+t.getNome());
			
			TipoPlataformaDao tD = new TipoPlataformaDao();
			
			try{
				boolean retorno = tD.alterarPlataforma(t);
				
				if(retorno){
					mv.addObject("msg", "Plataforma Alterada com Sucesso!");
					System.out.println("Plataforma Alterada com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Alterar Plataforma!");
					System.out.println("Erro ao Alterar Plataforma!");
				}
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Alterar Plataforma!");
				System.out.println("Erro ao Alterar Plataforma!");
			}
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}	
	
	@RequestMapping("excluirPlataforma.html")
	public ModelAndView excluirPlataforma(HttpServletRequest rq, Long cod, String nome){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Excluir Plataforma...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarPlataformas");
		
		tipoPlataforma t = new tipoPlataforma();
		
		if(cod!=null && nome!=null){
			t.setCod(cod);
			t.setNome(nome);
			
			System.out.println("Código da Plataforma: "+t.getCod());
			System.out.println("Nome da Plataforma: "+t.getNome());
			
			TipoPlataformaDao tD = new TipoPlataformaDao();
			
			try{
				boolean retorno = tD.excluirPlataforma(t);
				
				if(retorno){
					mv.addObject("msg", "Plataforma Excluída com Sucesso!");
					System.out.println("Plataforma Excluída com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Excluir Plataforma!");
					System.out.println("Erro ao Excluir Plataforma!");
				}
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Excluir Plataforma!");
				System.out.println("Erro ao Excluir Plataforma!");
			}
		}	
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("gerenciarPlataformasPesquisar.html")
	public ModelAndView gerenciarPlataformasPesquisar(HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Pesquisar Plataforma do Gerenciar Plataforma...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarPlataformas");
		
		String u = rq.getParameter("nome");
		
		System.out.println("Nome da Plataforma: "+u);
		
		TipoPlataformaDao tD = new TipoPlataformaDao();
		
		ArrayList<tipoPlataforma> tA = new ArrayList<tipoPlataforma>();
		
		tipoPlataforma tp = new tipoPlataforma();
		
		if(u!=null){
			tp.setNome(u);
			
			boolean retorno = tD.verificadorNome(tp);
			
			if(retorno){
				try{
					tA = tD.gerenciarPlataformasPesquisar(tp);
					
					mv.addObject("pesquisaAviso", "Quantidade de Plataformas Buscadas: "+tA.size());
					mv.addObject("t", tA);
					
				}catch(Exception e){
					e.printStackTrace();
					mv.addObject("pesquisaAviso", "Erro ao Procurar Plataforma!");
					System.out.println("Erro ao Procurar Plataforma!");
				}
				
			}else{
				mv  = new ModelAndView("WEB-INF/views/gerenciarPlataformas");
				mv.addObject("pesquisaAviso", "Plataforma não Encontrada!");
			}
			
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
}
