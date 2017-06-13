package br.csi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.csi.dao.DuvidaDao;
import br.csi.model.Duvida;

@Controller
public class DuvidaController {
	
	@RequestMapping("enviarDuvida.html")
	public ModelAndView enviarDuvida(Duvida d, HttpServletRequest rq){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Enviar Dúvida...");
		
		System.out.println();
		System.out.println("Dados da Dúvida:");
		String email = rq.getParameter("email");
		String duvida = rq.getParameter("duvida");
		System.out.println("Email: "+email);
		System.out.println("Dúvida: "+duvida);
		
		/* System.out.println("Email: "+d.getEmail());
		System.out.println("Dúvida: "+d.getDuvida()); */
		
		DuvidaDao dD = new DuvidaDao();
		ModelAndView mv  = new ModelAndView("duvida");
		
		if(email!=null && duvida!=null){
			d.setDuvida(duvida);
			d.setEmail(email);
			
			try{
				boolean retorno = dD.enviarDuvida(d);
				
				if(retorno){
					mv.addObject("msg", "Dúvida Enviada com Sucesso!");
					System.out.println("Dúvida Enviada com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Enviar Dúvida!");
					System.out.println("Erro ao Enviar Dúvida!");
				}
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Enviar Dúvida!");
				System.out.println("Erro ao Enviar Dúvida!");
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println();
		}
		
		return mv;
		
		// return "forward:mandeDuvida.html";
	}

	@RequestMapping("duvidaRespondida.html")
	public ModelAndView duvidaRespondida(Duvida d){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Dúvida Respondida...");
		
		System.out.println();
		System.out.println("Dados da Dúvida e Resposta:");
		System.out.println("Email do Usuário: "+d.getEmail());
		System.out.println("Dúvida do Usuário: "+d.getDuvida());
		System.out.println("Resposta: "+d.getResposta());
		
		DuvidaDao dD = new DuvidaDao();
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/responderDuvida");
		
		try{
			boolean retorno = dD.duvidaRespondida(d);
			
			if(retorno){
				mv = new ModelAndView("/WEB-INF/views/gerenciarDuvidas");
				mv.addObject("msg", "Dúvida Respondida com Sucesso!");
				System.out.println("Dúvida Respondida com Sucesso!");
			}else{
				mv.addObject("msg", "Erro ao Responder Dúvida!");
				System.out.println("Erro ao Responder Dúvida!");
			}
		}catch(Exception e){
			e.printStackTrace();
			new ModelAndView("/WEB-INF/views/gerenciarDuvidas");
			
			mv.addObject("msg", "Erro ao Responder Dúvida!");
			System.out.println("Erro ao Responder Dúvida!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		// return "forward:gerenciarDuvidas.html";
		
		return mv;
	}
	
	@RequestMapping("visualizarDuvida.html")
	public ModelAndView visualizarDuvida(Duvida d){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Visualizar Dúvida...");
		
		System.out.println();
		System.out.println("Código da Dúvida: "+d.getCodDuvida());
		
		DuvidaDao dD = new DuvidaDao();
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/visualizarDuvida");
		
		try{
			d = dD.visualizarDuvida(d);
			System.out.println("Email do usuário: "+d.getEmail());
			System.out.println("Dúvida: "+d.getDuvida());
			System.out.println("Resposta da Dúvida: "+d.getResposta());
			
			mv.addObject("duvida", d);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Dúvida não Cadastrada!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		// return "forward:gerenciarDuvidas.html";
	}
	
	@RequestMapping("excluirDuvida.html")
	public ModelAndView excluirDuvida(Duvida d){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Excluir Duvida...");
		
		ModelAndView mv  = new ModelAndView("WEB-INF/views/gerenciarDuvidas");
		
		System.out.println("Código da Dúvida: "+d.getCodDuvida());
		
		DuvidaDao dD = new DuvidaDao();
		
		try{
			boolean retorno = dD.excluirDuvida(d);
			
			if(retorno){
				mv.addObject("msg", "Duvida Excluída com Sucesso!");
				System.out.println("Dúvida Excluída com Sucesso!");
			}else{
				mv.addObject("msg", "Erro ao Excluir Dúvida!");
				System.out.println("Erro ao Excluir Dúvida!");
			}
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Erro ao Excluir Dúvida!");
			System.out.println("Erro ao Excluir Dúvida!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("responderDuvida.html")
	public ModelAndView responderDuvida(Duvida d){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Responder Dúvida...");
		
		System.out.println();
		System.out.println("Código da Dúvida: "+d.getCodDuvida());
		
		DuvidaDao dD = new DuvidaDao();
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/responderDuvida");
		
		try{
			d = dD.visualizarDuvida(d);
			
			System.out.println("Email do usuário: "+d.getEmail());
			System.out.println("Dúvida: "+d.getDuvida());
			System.out.println("Resposta da Dúvida: "+d.getResposta());
			
			mv.addObject("duvida", d);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Dúvida não Cadastrada!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
		// return "forward:gerenciarDuvidas.html";
	}
	
	@RequestMapping("duvidasRespondidas.html")
	public ModelAndView duvidasRespondidas(){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Buscar Dúvidas Respondidas...");
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/gerenciarDuvidas");
		DuvidaDao dD = new DuvidaDao();
		
		ArrayList<Duvida> dA = new ArrayList<Duvida>();
		
		try{
			dA = dD.duvidasRespondidas();
			
			if(dA.size()>0){
				mv.addObject("pesquisaAviso", "Quantidade de Dúvidas Respondidas: "+dA.size());
			}
			else{
				mv.addObject("pesquisaAviso", "Nenhuma Dúvida Respondida!");
			}
			mv.addObject("d", dA);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("pesquisaAviso", "Erro ao Procurar Dúvidas Respondidas!");
			System.out.println("Erro ao Procurar Dúvidas Respondidas!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("duvidasNaoRespondidas.html")
	public ModelAndView duvidasNaoRespondidas(){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Buscar Dúvidas não Respondidas...");
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/gerenciarDuvidas");
		DuvidaDao dD = new DuvidaDao();
		
		ArrayList<Duvida> dA = new ArrayList<Duvida>();
		
		try{
			dA = dD.duvidasNaoRespondidas();
			
			if(dA.size()>0){
				mv.addObject("pesquisaAviso", "Quantidade de Dúvidas Não Respondidas: "+dA.size());
			}
			else{
				mv.addObject("pesquisaAviso", "Nenhuma Dúvida Não Respondida!");
			}
			mv.addObject("d", dA);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("pesquisaAviso", "Erro ao Procurar Dúvidas Respondidas!");
			System.out.println("Erro ao Procurar Dúvidas Respondidas!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
}
