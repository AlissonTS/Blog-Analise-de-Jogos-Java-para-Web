package br.csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.csi.model.Usuario;
import br.csi.util.ConectaBD;

public class UsuarioDao {
	
		public boolean cadastrarUsuario(Usuario u){
			boolean retorno = false;
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do Cadastrar Usuário DAO...");
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = " INSERT INTO USUARIO (cod, email, nome, senha, dataNasc, ocupacao, descricao, dataCriacao, horaCriacao, dataModific, horaModific)"
						+ " VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, u.getEmail());
				stmt.setString(2, u.getNome());
				stmt.setString(3, u.getSenha());
				stmt.setString(4, u.getDataNasc());
				stmt.setString(5, u.getOcupacao());
				stmt.setString(6, u.getDescricao());
				stmt.setString(7, u.getDataCriacao());
				stmt.setString(8, u.getHoraCriacao());
				stmt.setString(9, u.getDataModific());
				stmt.setString(10, u.getHoraModific());
				
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
		
		public boolean alterarUsuario(Usuario u){
			boolean retorno = false;
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do Alterar Usuário DAO...");
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = " UPDATE USUARIO SET EMAIL=?, NOME=?, SENHA=?, DATANASC=?, OCUPACAO=?, DESCRICAO=?, "
						+ "DATAMODIFIC=?, HORAMODIFIC=? WHERE COD=?;"; 
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, u.getEmail());
				stmt.setString(2, u.getNome());
				stmt.setString(3, u.getSenha());
				stmt.setString(4, u.getDataNasc());
				stmt.setString(5, u.getOcupacao());
				stmt.setString(6, u.getDescricao());
				stmt.setString(7, u.getDataModific());
				stmt.setString(8, u.getHoraModific());
				stmt.setLong(9, u.getCodigo());
				
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
		
		public boolean verificarUsuario(Usuario u){
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			boolean autenticado = false;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM USUARIO WHERE EMAIL=? AND SENHA=?;";
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, u.getEmail());
				stmt.setString(2, u.getSenha());
				
				ResultSet valor = stmt.executeQuery();	
				
				autenticado = valor.next();
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return autenticado;
		}
		
		public boolean verificador(Usuario u){
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			boolean autenticado = false;
			
			if(u.getCodigo()!=null){
				try{
					c = ConectaBD.getConexao();
					String sql = "";
					
					sql = "SELECT * FROM USUARIO WHERE COD=?;";
					stmt = c.prepareStatement(sql);	
					stmt.setLong(1, u.getCodigo());
					
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
		
		public boolean verificadorNome(Usuario u){
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			boolean autenticado = false;
			
			if(u.getNome()!=null){
				try{
					c = ConectaBD.getConexao();
					String sql = "";
					
					sql = "SELECT * FROM USUARIO WHERE NOME LIKE ?;";
					stmt = c.prepareStatement(sql);	
					stmt.setString(1, '%'+u.getNome()+'%');
					
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
		
		/*
		public boolean verificadorNome(String u){
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			boolean autenticado = false;
			
			if(u!=null){
				try{
					c = ConectaBD.getConexao();
					String sql = "";
					
					sql = "SELECT * FROM USUARIO WHERE NOME=?;";
					stmt = c.prepareStatement(sql);	
					stmt.setString(1, u);
					
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
		
		/*
		
		public Usuario setarUsuario(Usuario u){
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM USUARIO WHERE NOME=?;";
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, u.getNome());
				
				ResultSet valor = stmt.executeQuery();	
				
				while(valor.next()){
					u.setCodigo(valor.getLong("cod"));
					u.setEmail(valor.getString("email"));
					u.setNome(valor.getString("nome"));
					u.setSenha(valor.getString("senha"));
					u.setDataNasc(valor.getString("dataNasc"));
					u.setOcupacao(valor.getString("ocupacao"));
					u.setDescricao(valor.getString("descricao"));
					u.setDataCriacao(valor.getString("dataCriacao"));
					u.setHoraCriacao(valor.getString("horaCriacao"));
					u.setDataModific(valor.getString("dataModific"));
					u.setHoraModific(valor.getString("horaModific"));
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return u;
		}
		
		*/	
		
		public Usuario logar(Usuario u){
				Connection c = null;
				PreparedStatement stmt = null;
				
				try{
					c = ConectaBD.getConexao();
					String sql = "";
					
					sql = "SELECT * FROM USUARIO WHERE EMAIL=? AND SENHA=?;";
					stmt = c.prepareStatement(sql);	
					stmt.setString(1, u.getEmail());
					stmt.setString(2, u.getSenha());
					
					ResultSet valor = stmt.executeQuery();	
					
					while(valor.next()){
						u.setCodigo(valor.getLong("cod"));
						u.setEmail(valor.getString("email"));
						u.setNome(valor.getString("nome"));
						u.setSenha(valor.getString("senha"));
						u.setDataNasc(valor.getString("dataNasc"));
						u.setOcupacao(valor.getString("ocupacao"));
						u.setDescricao(valor.getString("descricao"));
						u.setDataCriacao(valor.getString("dataCriacao"));
						u.setHoraCriacao(valor.getString("horaCriacao"));
						u.setDataModific(valor.getString("dataModific"));
						u.setHoraModific(valor.getString("horaModific"));
					}
					
					stmt.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
				return u;
		}
		
		public ArrayList<Usuario> listaUsuarios(){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ListaUsuario DAO...");
			
			ArrayList<Usuario> list = new ArrayList<Usuario>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM USUARIO WHERE COD!=1 ORDER BY NOME;";
				stmt = c.prepareStatement(sql);	
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					Usuario u = new Usuario();
					
					u.setCodigo(valor.getLong("cod"));
					u.setNome(valor.getString("nome"));
					u.setDataCriacao(valor.getString("dataCriacao"));
					
					
					list.add(u);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public long quantidadePostagem(long codigo) throws ClassNotFoundException, SQLException{
			Connection c = null;
			c = ConectaBD.getConexao();
			
			String sql = "SELECT Count(codPost) AS cPost FROM POSTAGEM where CodUsuario=?;";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setLong(1, codigo);

			ResultSet rs= stmt.executeQuery();
			
			rs.next();
			long cPost = rs.getInt("cPost");
			
			return cPost;
		}
		
		public ArrayList<Usuario> usuariosPesquisar(Usuario u){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou no Pesquisar Usuário DAO...");
			
			ArrayList<Usuario> list = new ArrayList<Usuario>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM USUARIO WHERE NOME LIKE ? AND COD!=1;";
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, '%'+u.getNome()+'%');
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					Usuario us = new Usuario();
					
					us.setCodigo(valor.getLong("cod"));
					us.setNome(valor.getString("nome"));
					us.setDataCriacao(valor.getString("dataCriacao"));
					
					list.add(us);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public Usuario nomeUsuario(long cod){
			Connection c = null;
			PreparedStatement stmt = null;
			
			Usuario u = new Usuario();
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM USUARIO WHERE COD=? AND COD!=1;";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, cod);
				
				ResultSet valor = stmt.executeQuery();	
				
				while(valor.next()){
					u.setCodigo(valor.getLong("cod"));
					u.setNome(valor.getString("nome"));
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return u;
		}
		
		public Usuario visualizarUsuario(Usuario u){
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM USUARIO WHERE COD=?;";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, u.getCodigo());
				
				ResultSet valor = stmt.executeQuery();	
				
				while(valor.next()){
					u.setCodigo(valor.getLong("cod"));
					u.setEmail(valor.getString("email"));
					u.setNome(valor.getString("nome"));
					u.setSenha(valor.getString("senha"));
					u.setDataNasc(valor.getString("dataNasc"));
					u.setOcupacao(valor.getString("ocupacao"));
					u.setDescricao(valor.getString("descricao"));
					u.setDataCriacao(valor.getString("dataCriacao"));
					u.setHoraCriacao(valor.getString("horaCriacao"));
					u.setDataModific(valor.getString("dataModific"));
					u.setHoraModific(valor.getString("horaModific"));
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return u;
	}	
}
