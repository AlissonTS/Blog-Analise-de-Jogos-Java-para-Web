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
		System.out.println("Entrou no Enviar D�vida...");
		
		System.out.println();
		System.out.println("Dados da D�vida:");
		String email = rq.getParameter("email");
		String duvida = rq.getParameter("duvida");
		System.out.println("Email: "+email);
		System.out.println("D�vida: "+duvida);
		
		/* System.out.println("Email: "+d.getEmail());
		System.out.println("D�vida: "+d.getDuvida()); */
		
		DuvidaDao dD = new DuvidaDao();
		ModelAndView mv  = new ModelAndView("duvida");
		
		if(email!=null && duvida!=null){
			d.setDuvida(duvida);
			d.setEmail(email);
			
			try{
				boolean retorno = dD.enviarDuvida(d);
				
				if(retorno){
					mv.addObject("msg", "D�vida Enviada com Sucesso!");
					System.out.println("D�vida Enviada com Sucesso!");
				}else{
					mv.addObject("msg", "Erro ao Enviar D�vida!");
					System.out.println("Erro ao Enviar D�vida!");
				}
			}catch(Exception e){
				e.printStackTrace();
				mv.addObject("msg", "Erro ao Enviar D�vida!");
				System.out.println("Erro ao Enviar D�vida!");
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
		System.out.println("Entrou no D�vida Respondida...");
		
		System.out.println();
		System.out.println("Dados da D�vida e Resposta:");
		System.out.println("Email do Usu�rio: "+d.getEmail());
		System.out.println("D�vida do Usu�rio: "+d.getDuvida());
		System.out.println("Resposta: "+d.getResposta());
		
		DuvidaDao dD = new DuvidaDao();
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/responderDuvida");
		
		try{
			boolean retorno = dD.duvidaRespondida(d);
			
			if(retorno){
				mv = new ModelAndView("/WEB-INF/views/gerenciarDuvidas");
				mv.addObject("msg", "D�vida Respondida com Sucesso!");
				System.out.println("D�vida Respondida com Sucesso!");
			}else{
				mv.addObject("msg", "Erro ao Responder D�vida!");
				System.out.println("Erro ao Responder D�vida!");
			}
		}catch(Exception e){
			e.printStackTrace();
			new ModelAndView("/WEB-INF/views/gerenciarDuvidas");
			
			mv.addObject("msg", "Erro ao Responder D�vida!");
			System.out.println("Erro ao Responder D�vida!");
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
		System.out.println("Entrou no Visualizar D�vida...");
		
		System.out.println();
		System.out.println("C�digo da D�vida: "+d.getCodDuvida());
		
		DuvidaDao dD = new DuvidaDao();
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/visualizarDuvida");
		
		try{
			d = dD.visualizarDuvida(d);
			System.out.println("Email do usu�rio: "+d.getEmail());
			System.out.println("D�vida: "+d.getDuvida());
			System.out.println("Resposta da D�vida: "+d.getResposta());
			
			mv.addObject("duvida", d);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "D�vida n�o Cadastrada!");
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
		
		System.out.println("C�digo da D�vida: "+d.getCodDuvida());
		
		DuvidaDao dD = new DuvidaDao();
		
		try{
			boolean retorno = dD.excluirDuvida(d);
			
			if(retorno){
				mv.addObject("msg", "Duvida Exclu�da com Sucesso!");
				System.out.println("D�vida Exclu�da com Sucesso!");
			}else{
				mv.addObject("msg", "Erro ao Excluir D�vida!");
				System.out.println("Erro ao Excluir D�vida!");
			}
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Erro ao Excluir D�vida!");
			System.out.println("Erro ao Excluir D�vida!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("responderDuvida.html")
	public ModelAndView responderDuvida(Duvida d){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Responder D�vida...");
		
		System.out.println();
		System.out.println("C�digo da D�vida: "+d.getCodDuvida());
		
		DuvidaDao dD = new DuvidaDao();
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/responderDuvida");
		
		try{
			d = dD.visualizarDuvida(d);
			
			System.out.println("Email do usu�rio: "+d.getEmail());
			System.out.println("D�vida: "+d.getDuvida());
			System.out.println("Resposta da D�vida: "+d.getResposta());
			
			mv.addObject("duvida", d);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "D�vida n�o Cadastrada!");
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
		System.out.println("Entrou no Buscar D�vidas Respondidas...");
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/gerenciarDuvidas");
		DuvidaDao dD = new DuvidaDao();
		
		ArrayList<Duvida> dA = new ArrayList<Duvida>();
		
		try{
			dA = dD.duvidasRespondidas();
			
			if(dA.size()>0){
				mv.addObject("pesquisaAviso", "Quantidade de D�vidas Respondidas: "+dA.size());
			}
			else{
				mv.addObject("pesquisaAviso", "Nenhuma D�vida Respondida!");
			}
			mv.addObject("d", dA);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("pesquisaAviso", "Erro ao Procurar D�vidas Respondidas!");
			System.out.println("Erro ao Procurar D�vidas Respondidas!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
	
	@RequestMapping("duvidasNaoRespondidas.html")
	public ModelAndView duvidasNaoRespondidas(){
		System.out.println("-------------------------------");
		System.out.println("Entrou no Buscar D�vidas n�o Respondidas...");
		
		ModelAndView mv  = new ModelAndView("/WEB-INF/views/gerenciarDuvidas");
		DuvidaDao dD = new DuvidaDao();
		
		ArrayList<Duvida> dA = new ArrayList<Duvida>();
		
		try{
			dA = dD.duvidasNaoRespondidas();
			
			if(dA.size()>0){
				mv.addObject("pesquisaAviso", "Quantidade de D�vidas N�o Respondidas: "+dA.size());
			}
			else{
				mv.addObject("pesquisaAviso", "Nenhuma D�vida N�o Respondida!");
			}
			mv.addObject("d", dA);
			
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("pesquisaAviso", "Erro ao Procurar D�vidas Respondidas!");
			System.out.println("Erro ao Procurar D�vidas Respondidas!");
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		return mv;
	}
}
