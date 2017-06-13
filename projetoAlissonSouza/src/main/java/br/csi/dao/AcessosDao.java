package br.csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.csi.model.Acessos;
import br.csi.model.AcessosPost;
import br.csi.model.Postagem;
import br.csi.util.ConectaBD;

public class AcessosDao {
	
	public boolean adicionarAcessosPost(Postagem p){
		boolean retorno = false;
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("Entrou dentro do adicionarAcessos Postagem DAO...");
		
		Connection c = null;
		PreparedStatement stmt = null;
		
		try{
			c = ConectaBD.getConexao();
			String sql = "";
				
			sql = " INSERT INTO ACESSOS_POST (codPost, acessosTotal)"
				+ " VALUES(?, 0)"; 
			stmt = c.prepareStatement(sql);	
			stmt.setLong(1, p.getCodPost());
		
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
	
	public boolean incrementoAcessosPost(Postagem p){
		boolean retorno = false;
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("Entrou dentro do incrementoAcessos Postagem DAO...");
		
		Connection c = null;
		PreparedStatement stmt = null;
		
		try{
			c = ConectaBD.getConexao();
			String sql = "";
				
			sql = " UPDATE ACESSOS_POST SET ACESSOSTOTAL=ACESSOSTOTAL+1 WHERE CODPOST=?";
			
			stmt = c.prepareStatement(sql);	
			stmt.setLong(1, p.getCodPost());
			
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
	
	public boolean adicionarAcessos(){
		boolean retorno = false;
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("Entrou dentro do adicionarAcessos DAO...");
		
		Connection c = null;
		PreparedStatement stmt = null;
		
		try{
			c = ConectaBD.getConexao();
			String sql = "";
				
			sql = "UPDATE ACESSOS SET ACESSOSTOTAL=ACESSOSTOTAL+1 WHERE COD=1"; 
			stmt = c.prepareStatement(sql);	
		
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
	
	public Acessos verAcessos(){
		Connection c = null;
		PreparedStatement stmt = null;
		
		Acessos a = new Acessos();
		
		try{
			c = ConectaBD.getConexao();
			String sql = "";
			
			sql = "SELECT * FROM ACESSOS WHERE COD=1";
			stmt = c.prepareStatement(sql);
			
			ResultSet valor = stmt.executeQuery();	
			
			while(valor.next()){
				a.setCod(valor.getLong("cod"));
				a.setAcessosTotal(valor.getInt("acessosTotal"));
			}
			
			stmt.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return a;
	}
	
	public AcessosPost verAcessosPost(Postagem p){
		Connection c = null;
		PreparedStatement stmt = null;
		
		AcessosPost a = new AcessosPost();	
		try{
			c = ConectaBD.getConexao();
			String sql = "";
			
			sql = "SELECT * FROM ACESSOS_POST WHERE CODPOST=?";
			stmt = c.prepareStatement(sql);
			stmt.setLong(1, p.getCodPost());			

			ResultSet valor = stmt.executeQuery();	
			
			while(valor.next()){
				a.setCodPost(valor.getLong("codPost"));
				a.setAcessosTotal(valor.getInt("acessosTotal"));
			}
			
			stmt.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return a;
	}
}
