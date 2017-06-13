package br.csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.csi.model.Duvida;
import br.csi.util.ConectaBD;

public class DuvidaDao {
	
		public boolean enviarDuvida(Duvida d){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do Enviar Dúvida DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = " INSERT INTO DUVIDA(codDuvida, email, duvida)"
						+ " VALUES(DEFAULT, ?, ?)"; 
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, d.getEmail());
				stmt.setString(2, d.getDuvida());				
	
				stmt.execute();	
				stmt.close();
				retorno = true;
				
			}catch(Exception e){
				e.printStackTrace();
				retorno = false;
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return retorno;
		}
		
		public ArrayList<Duvida> listaDuvida(){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ListaDuvidaDAO...");
			
			ArrayList<Duvida> list = new ArrayList<Duvida>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM DUVIDA;";
				stmt = c.prepareStatement(sql);	
				
				ResultSet valor = stmt.executeQuery();
				
				while(valor.next()){
					Duvida d = new Duvida();
					
					d.setCodDuvida(valor.getLong("codDuvida"));
					d.setEmail(valor.getString("email"));
					d.setDuvida(valor.getString("duvida"));
					d.setResposta(valor.getString("resposta"));
					
					list.add(d);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public ArrayList<Duvida> duvidasRespondidas(){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do Dúvidas Respondidas DAO...");
			
			ArrayList<Duvida> list = new ArrayList<Duvida>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM DUVIDA WHERE RESPOSTA IS NOT NULL;";
				stmt = c.prepareStatement(sql);	
				
				ResultSet valor = stmt.executeQuery();
				
				while(valor.next()){
					Duvida d = new Duvida();
					
					d.setCodDuvida(valor.getLong("codDuvida"));
					d.setEmail(valor.getString("email"));
					d.setDuvida(valor.getString("duvida"));
					d.setResposta(valor.getString("resposta"));
					
					list.add(d);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public ArrayList<Duvida> duvidasNaoRespondidas(){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do Dúvidas Não Respondidas DAO...");
			
			ArrayList<Duvida> list = new ArrayList<Duvida>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM DUVIDA WHERE RESPOSTA IS NULL;";
				stmt = c.prepareStatement(sql);	
				
				ResultSet valor = stmt.executeQuery();
				
				while(valor.next()){
					Duvida d = new Duvida();
					
					d.setCodDuvida(valor.getLong("codDuvida"));
					d.setEmail(valor.getString("email"));
					d.setDuvida(valor.getString("duvida"));
					d.setResposta(valor.getString("resposta"));
					
					list.add(d);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}

		public Duvida visualizarDuvida(Duvida d){
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM DUVIDA WHERE CODDUVIDA=?";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, d.getCodDuvida());
				
				ResultSet valor = stmt.executeQuery();	
				
				while(valor.next()){
					d.setCodDuvida(valor.getLong("codDuvida"));
					d.setEmail(valor.getString("email"));
					d.setDuvida(valor.getString("duvida"));
					d.setResposta(valor.getString("resposta"));
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return d;
	   }
		
		public boolean excluirDuvida(Duvida d){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ExcluirDuvida DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "DELETE FROM DUVIDA WHERE CODDUVIDA=?"; 
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, d.getCodDuvida());
				
				stmt.execute();	
				stmt.close();
				retorno = true;
				
			}catch(Exception e){
				e.printStackTrace();
				retorno = false;
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return retorno;
		}
		
		public boolean duvidaRespondida(Duvida d){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do DuvidaRespondida DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "UPDATE DUVIDA SET RESPOSTA=? WHERE CODDUVIDA=?"; 
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, d.getResposta());
				stmt.setLong(2, d.getCodDuvida());
				
				stmt.execute();	
				stmt.close();
				retorno = true;
				
			}catch(Exception e){
				e.printStackTrace();
				retorno = false;
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return retorno;
		}
}
