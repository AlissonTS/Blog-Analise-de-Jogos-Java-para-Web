package br.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class principalController {
		
		@RequestMapping("gerenciarCategorias.html")
		public String gerenciarCategorias(){
			return "/WEB-INF/views/gerenciarCategorias";
		}
		
		@RequestMapping("gerenciarPlataformas.html")
		public String gerenciarPlataformas(){
			return "/WEB-INF/views/gerenciarPlataformas";
		}
		
		@RequestMapping("gerenciarPostagens.html")
		public String gerenciarPostagens(){
			return "/WEB-INF/views/gerenciarPostagens";
		}
		
		@RequestMapping("gerenciarDuvidas.html")
		public String gerenciarDuvidas(){
			return "/WEB-INF/views/gerenciarDuvidas";
		}
		
		@RequestMapping("cadastrarPostagem.html")
		public String cadastrarPostagem(){
			return "/WEB-INF/views/cadastrarPostagem";
		}
		
		@RequestMapping("usuarioSeguidos.html")
		public String usuarioSeguidos(){
			return "/WEB-INF/views/usuarioSeguidos";
		}
}
