package br.csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.csi.model.Postagem;
import br.csi.model.tipoJogo;
import br.csi.util.ConectaBD;

public class TipoJogoDao {
		
		public ArrayList<tipoJogo> listaTipo(){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ListaTipo DAO...");
			
			ArrayList<tipoJogo> list = new ArrayList<tipoJogo>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM TIPO_JOGO;";
				stmt = c.prepareStatement(sql);	
				
				ResultSet valor = stmt.executeQuery();
				
				while(valor.next()){
					tipoJogo t = new tipoJogo();
					
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
		
		public boolean cadastrarTipo(tipoJogo t){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do CadastrarTipo DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = " INSERT INTO TIPO_JOGO(cod, nome)"
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
		
		public boolean alterarTipo(tipoJogo t){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do AlterarTipo DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "UPDATE TIPO_JOGO SET NOME=? WHERE COD=?"; 
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
		
		public boolean excluirTipo(tipoJogo t){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ExcluirTipo DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "DELETE FROM POSTAGEM_JOGO WHERE CODTIPOJOGO=?";
				
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, t.getCod());
				
				stmt.execute();	
				stmt.close();
				
				sql = "DELETE FROM TIPO_JOGO WHERE COD=?"; 
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
		
		public ArrayList<tipoJogo> visualizarCategorias(Postagem p){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do visualizarCategorias DAO...");
			
			ArrayList<tipoJogo> list = new ArrayList<tipoJogo>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM_JOGO, TIPO_JOGO WHERE codTipoJogo=cod AND CODPOST=?;";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, p.getCodPost());				

				ResultSet valor = stmt.executeQuery();
				
				while(valor.next()){
					tipoJogo t = new tipoJogo();
					
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
		
		public ArrayList<tipoJogo> gerenciarCategoriasPesquisar(tipoJogo t){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou no Pesquisar Categoria do Gerenciar Categorias DAO...");
			
			ArrayList<tipoJogo> list = new ArrayList<tipoJogo>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM TIPO_JOGO WHERE NOME LIKE ?;";
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, '%'+t.getNome()+'%');
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					tipoJogo tj = new tipoJogo();
					
					tj.setCod(valor.getLong("cod"));
					tj.setNome(valor.getString("nome"));
					
					list.add(tj);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public tipoJogo buscarNome(tipoJogo t){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou no BuscarNome Categoria DAO...");
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM TIPO_JOGO WHERE COD=?;";
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
		
		public boolean verificadorNome(tipoJogo t){
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			boolean autenticado = false;
			
			if(t.getNome()!=null){
				try{
					c = ConectaBD.getConexao();
					String sql = "";
					
					sql = "SELECT * FROM TIPO_JOGO WHERE NOME LIKE ?;";
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
