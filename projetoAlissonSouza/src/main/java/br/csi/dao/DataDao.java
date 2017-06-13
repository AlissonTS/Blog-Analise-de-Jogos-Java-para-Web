package br.csi.dao;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import br.csi.model.Data;
import br.csi.model.Postagem;
import br.csi.model.Usuario;

public class DataDao {
		
		public Data Cadastro(Data d){
			
			Locale locale = new Locale("pt","BR");
	        GregorianCalendar calendar = new GregorianCalendar();
	        
	        SimpleDateFormat formatador = new SimpleDateFormat("HH':'mm':'ss",locale);
	        // System.out.println("HORA: "+formatador.format(calendar.getTime()));

	        String hc = formatador.format(calendar.getTime());
	        String hm = formatador.format(calendar.getTime());
	        
	        d.setHoraC(hc);
	        d.setHoraM(hm);
	        
	        formatador = new SimpleDateFormat("dd'/'MM'/'yyyy",locale);
	        // System.out.println("DATA: "+formatador.format(calendar.getTime()));
	        
	        String dc = formatador.format(calendar.getTime());
	        d.setDataC(dc);
	        String dm = formatador.format(calendar.getTime());
			d.setDataM(dm);
	        
			return d;
		}
		
		public Data Alterar(Data d){
			
			Locale locale = new Locale("pt","BR");
	        GregorianCalendar calendar = new GregorianCalendar();
	        
	        SimpleDateFormat formatador = new SimpleDateFormat("HH':'mm':'ss",locale);
	        // System.out.println("HORA: "+formatador.format(calendar.getTime()));

	        String hm = formatador.format(calendar.getTime());
	        
	        d.setHoraM(hm);
	        
	        formatador = new SimpleDateFormat("dd'/'MM'/'yyyy",locale);
	        // System.out.println("DATA: "+formatador.format(calendar.getTime()));
	        
	        String dm = formatador.format(calendar.getTime());
			d.setDataM(dm);
	        
			return d;
		}
	
		public Usuario dataUsuarioCadastro(Usuario u){
			
			Data d = new Data();
			
			Cadastro(d);
			
	        u.setDataCriacao(d.getDataC());
	        u.setDataModific(d.getDataM());
	        u.setHoraCriacao(d.getHoraC());
	        u.setHoraModific(d.getHoraM());
			
			return u;
		}
		
		public Usuario dataUsuarioAlterar(Usuario u){
			
			Data d = new Data();
			
			Alterar(d);
			
	        u.setDataModific(d.getDataM());
	        u.setHoraModific(d.getHoraM());
			
			return u;
		}
		
		public Postagem dataPostagemAdicionar(Postagem p){
			
			Data d = new Data();
			
			Cadastro(d);
	        
	        p.setDataC(d.getDataC());
	        p.setHorarioC(d.getHoraC());
	        p.setDataM(d.getDataM());
	        p.setHorarioM(d.getHoraM());
			
			return p;
		}
		
		public Postagem dataPostagemAlterar(Postagem p){
			
			Data d = new Data();
			
			Alterar(d);
	        
	        p.setDataM(d.getDataM());
	        p.setHorarioM(d.getHoraM());
			
			return p;
		}
}
