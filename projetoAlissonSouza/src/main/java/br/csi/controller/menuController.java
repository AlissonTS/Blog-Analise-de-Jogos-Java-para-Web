package br.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class menuController {
		
		@RequestMapping("paginaInicial.html")
		public String paginaInicial(){	
			return "index";
		}
		
		@RequestMapping("buscaAvancada.html")
		public String buscaAvancada(){
			return "buscaAvancada";
		}
		
		@RequestMapping("usuariosPagina.html")
		public String usuariosPagina(){
			return "usuariosPagina";
		}
		
		@RequestMapping("sobrePagina.html")
		public String sobrePagina(){
			return "sobrePagina";
		}
		
		@RequestMapping("mandeDuvida.html")
		public String mandeDuvida(){
			return "duvida";
		}
		
		@RequestMapping("cadastroConta.html")
		public String cadastroConta(){
			return "cadastroConta";
		}
		
		@RequestMapping("login.html")
		public String login(){
			return "login";
		}
		
		@RequestMapping("verPostagem.html")
		public String verPostagem(){
			return "verPostagem";
		}
}
