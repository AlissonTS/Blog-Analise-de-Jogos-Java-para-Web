package br.csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.csi.model.Postagem;
import br.csi.model.tipoPlataforma;
import br.csi.util.ConectaBD;

public class TipoPlataformaDao {

		public ArrayList<tipoPlataforma> listaPlataforma(){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ListaPlataforma DAO...");
			
			ArrayList<tipoPlataforma> list = new ArrayList<tipoPlataforma>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM TIPO_PLATAFORMA;";
				stmt = c.prepareStatement(sql);	
				
				ResultSet valor = stmt.executeQuery();
				
				while(valor.next()){
					tipoPlataforma t = new tipoPlataforma();
					t.setCod(valor.getLong("cod"));
					t.setNome(valor.getString("nome"));
					
					list.add(t);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public boolean cadastrarPlataforma(tipoPlataforma t){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do cadastrarPlataforma DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = " INSERT INTO TIPO_PLATAFORMA(cod, nome)"
						+ " VALUES(DEFAULT, ?)"; 
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, t.getNome());
				
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
		
		public boolean alterarPlataforma(tipoPlataforma t){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do AlterarPlataforma DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "UPDATE TIPO_PLATAFORMA SET NOME=? WHERE COD=?"; 
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, t.getNome());
				stmt.setLong(2, t.getCod());
				
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
		
		public boolean excluirPlataforma(tipoPlataforma t){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ExcluirPlataforma DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				
				sql = "DELETE FROM POSTAGEM_PLATAFORMA WHERE CODTIPOPLATAFORMA=?";
				
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, t.getCod());
				
				stmt.execute();	
				stmt.close();
				
				
				sql = "DELETE FROM TIPO_PLATAFORMA WHERE COD=?"; 
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, t.getCod());
				
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
		
		public ArrayList<tipoPlataforma> visualizarPlataformas(Postagem p){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do visualizarPlataformas DAO...");
			
			ArrayList<tipoPlataforma> list = new ArrayList<tipoPlataforma>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM_PLATAFORMA, TIPO_PLATAFORMA WHERE codTipoPlataforma=cod AND CODPOST=?;";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, p.getCodPost());				

				ResultSet valor = stmt.executeQuery();
				
				while(valor.next()){
					tipoPlataforma t = new tipoPlataforma();
					
					t.setCod(valor.getLong("cod"));
					t.setNome(valor.getString("nome"));
					
					list.add(t);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public ArrayList<tipoPlataforma> gerenciarPlataformasPesquisar(tipoPlataforma t){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou no Pesquisar Plataforma do Gerenciar Plataformas DAO...");
			
			ArrayList<tipoPlataforma> list = new ArrayList<tipoPlataforma>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM TIPO_PLATAFORMA WHERE NOME LIKE ?;";
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, '%'+t.getNome()+'%');
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					tipoPlataforma tp = new tipoPlataforma();
					
					tp.setCod(valor.getLong("cod"));
					tp.setNome(valor.getString("nome"));
					
					list.add(tp);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public tipoPlataforma buscarNome(tipoPlataforma t){
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM TIPO_PLATAFORMA WHERE COD=?;";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, t.getCod());
				
				ResultSet valor = stmt.executeQuery();	
				
				while(valor.next()){
					t.setCod(valor.getLong("cod"));
					t.setNome(valor.getString("nome"));
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return t;
		}
		
		public boolean verificadorNome(tipoPlataforma t){
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			boolean autenticado = false;
			
			if(t.getNome()!=null){
				try{
					c = ConectaBD.getConexao();
					String sql = "";
					
					sql = "SELECT * FROM TIPO_PLATAFORMA WHERE NOME LIKE ?;";
					stmt = c.prepareStatement(sql);	
					stmt.setString(1, '%'+t.getNome()+'%');
					
					ResultSet valor = stmt.executeQuery();	
					
					autenticado = valor.next();
					
					stmt.close();
					
				}catch(Exception e){
					e.printStackTrace();
					autenticado = false;
				}
				
			}
			
			return autenticado;
		}
}
