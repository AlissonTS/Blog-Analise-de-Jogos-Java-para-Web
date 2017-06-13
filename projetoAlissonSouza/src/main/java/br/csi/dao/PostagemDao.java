package br.csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.csi.model.Postagem;
import br.csi.model.Usuario;
import br.csi.model.postagemJogo;
import br.csi.model.tipoJogo;
import br.csi.model.tipoPlataforma;
import br.csi.util.ConectaBD;

public class PostagemDao {
	
		public boolean adicionarPostagem(Postagem p){
			boolean retorno = false;
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do adicionarPostagem DAO...");
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = " INSERT INTO POSTAGEM (codPost, codUsuario, titulo, nota, descricao, dataC, horarioC, dataM, horarioM)"
						+ " VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)"; 
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, p.getCodUsuario());
				stmt.setString(2, p.getTitulo());
				stmt.setFloat(3, p.getNota());
				stmt.setString(4, p.getDescricao());
				stmt.setString(5, p.getDataC());
				stmt.setString(6, p.getHorarioC());
				stmt.setString(7, p.getDataM());
				stmt.setString(8, p.getHorarioM());
				
				stmt.execute();	
				stmt.close();
				retorno = true;
				
				if(retorno){
					
					Long idPost = pesquisaPostagem();
					p.setCodPost(idPost);
					
					boolean cP = adicionarCategoriasPlataformas(p);
					
					if(cP){
						AcessosDao aD = new AcessosDao();
						
						boolean aC = aD.adicionarAcessosPost(p);
						
						return aC;
					}
					
					// cP = true;
					
					// return cP;
				}
				
			}catch(Exception e){
				e.printStackTrace();
				retorno = false;
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return retorno;
		}
		
		public boolean alterarPostagem(Postagem p){
			boolean retorno = false;
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do alterarPostagem DAO...");
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = " UPDATE POSTAGEM SET titulo=?, nota=?, descricao=?, dataM=?, horarioM=? WHERE CODPOST=?";
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, p.getTitulo());
				stmt.setFloat(2, p.getNota());
				stmt.setString(3, p.getDescricao());
				stmt.setString(4, p.getDataM());
				stmt.setString(5, p.getHorarioM());
				stmt.setLong(6, p.getCodPost());
				
				stmt.execute();	
				stmt.close();
				retorno = true;
				
				if(retorno){
					
					boolean cP = alterarCategoriasPlataformas(p);
					
					cP = true;
					
					return cP;
				}
				
			}catch(Exception e){
				e.printStackTrace();
				retorno = false;
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return retorno;
		}
		
		
		public long pesquisaPostagem() throws ClassNotFoundException, SQLException{
			Connection c = null;
			c = ConectaBD.getConexao();
			
			String sql = "SELECT MAX(codPost) AS ID FROM POSTAGEM";
			PreparedStatement stmtPre = c.prepareStatement(sql);
			ResultSet rs= stmtPre.executeQuery();
			
			rs.next();
			long idPost = rs.getInt("id");
			
			return idPost;
		}
		
		public boolean adicionarCategoriasPlataformas(Postagem p){
			boolean retorno = false;
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do adicionarCategoriasPlataformas DAO...");
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				if(p.getCategoria()!=null){
					
					for(Long tJ : p.getCategoria()){
						sql = " INSERT INTO POSTAGEM_JOGO (codPost, codTipoJogo)"
							+ " VALUES(?, ?)"; 
						stmt = c.prepareStatement(sql);	
						stmt.setLong(1, p.getCodPost());
						stmt.setLong(2, tJ);
					
						stmt.execute();	
						stmt.close();
					}
					
				}
				
				if(p.getPlataforma()!=null){
					
					for(Long tP : p.getPlataforma()){
						sql = " INSERT INTO POSTAGEM_PLATAFORMA (codPost, codTipoPlataforma)"
							+ " VALUES(?, ?)"; 
						stmt = c.prepareStatement(sql);	
						stmt.setLong(1, p.getCodPost());
						stmt.setLong(2, tP);
					
						stmt.execute();	
						stmt.close();
					}
					
				}
				
				retorno = true;
				
			}catch(Exception e){
				e.printStackTrace();
				retorno = false;
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return retorno;
		}
		
		public boolean alterarCategoriasPlataformas(Postagem p){
			boolean retorno = false;
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do alterarCategoriasPlataformas DAO...");
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				if(p.getCategoria()!=null){
					
					sql = "DELETE FROM POSTAGEM_JOGO WHERE CODPOST=?";
					
					stmt = c.prepareStatement(sql);	
					stmt.setLong(1, p.getCodPost());
					
					stmt.execute();	
					stmt.close();
					
					for(Long tJ : p.getCategoria()){
						sql = " INSERT INTO POSTAGEM_JOGO (codPost, codTipoJogo)"
							+ " VALUES(?, ?)"; 
						stmt = c.prepareStatement(sql);	
						stmt.setLong(1, p.getCodPost());
						stmt.setLong(2, tJ);
					
						stmt.execute();	
						stmt.close();
					}
					
				}
				
				if(p.getPlataforma()!=null){
					
					sql = "DELETE FROM POSTAGEM_PLATAFORMA WHERE CODPOST=?";
					
					stmt = c.prepareStatement(sql);	
					stmt.setLong(1, p.getCodPost());

					stmt.execute();	
					stmt.close();
					
					
					for(Long tP : p.getPlataforma()){
						sql = " INSERT INTO POSTAGEM_PLATAFORMA (codPost, codTipoPlataforma)"
							+ " VALUES(?, ?)"; 
						stmt = c.prepareStatement(sql);	
						stmt.setLong(1, p.getCodPost());
						stmt.setLong(2, tP);
					
						stmt.execute();	
						stmt.close();
					}
					
				}
				
				retorno = true;
				
			}catch(Exception e){
				e.printStackTrace();
				retorno = false;
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return retorno;
		}
		
		public ArrayList<Postagem> listaPostagens(long codUsuario){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do listaPostagens DAO...");
			
			ArrayList<Postagem> list = new ArrayList<Postagem>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM WHERE CODUSUARIO=? ORDER BY CODPOST DESC;";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, codUsuario);
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					Postagem p = new Postagem();
					
					p.setCodPost(valor.getLong("codPost"));
					p.setTitulo(valor.getString("titulo"));
					p.setDataC(valor.getString("dataC"));
					p.setDataM(valor.getString("dataM"));
					
					list.add(p);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public Postagem visualizarPostagem(Postagem p){
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM WHERE CODPOST=?";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, p.getCodPost());
				
				ResultSet valor = stmt.executeQuery();	
				
				while(valor.next()){
					p.setCodPost(valor.getLong("codPost"));
					p.setCodUsuario(valor.getLong("codUsuario"));
					p.setTitulo(valor.getString("titulo"));
					p.setNota(valor.getFloat("nota"));	
					p.setDescricao(valor.getString("descricao"));
					p.setDataC(valor.getString("dataC"));
					p.setHorarioC(valor.getString("horarioC"));
					p.setDataM(valor.getString("dataM"));
					p.setHorarioM(valor.getString("horarioM"));
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return p;
	   }
		
		public boolean excluirPostagem(Postagem p){
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ExcluirPostagem DAO...");
			
			boolean retorno = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "DELETE FROM ACESSOS_POST WHERE CODPOST=?";
				
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, p.getCodPost());
				
				stmt.execute();	
				stmt.close();
				
				
				sql = "DELETE FROM POSTAGEM_JOGO WHERE CODPOST=?";
				
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, p.getCodPost());
				
				stmt.execute();	
				stmt.close();
				
				sql = "DELETE FROM POSTAGEM_PLATAFORMA WHERE CODPOST=?";
				
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, p.getCodPost());

				stmt.execute();	
				stmt.close();

				sql = "DELETE FROM POSTAGEM WHERE CODPOST=?"; 
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
		
		public ArrayList<Postagem> gerenciarPostagensPesquisar(Postagem p){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou no Pesquisar Postagem do Gerenciar Postagens DAO...");
			
			ArrayList<Postagem> list = new ArrayList<Postagem>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM WHERE CODUSUARIO=? AND TITULO LIKE ? ORDER BY CODPOST DESC;";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, p.getCodUsuario());
				stmt.setString(2, '%'+p.getTitulo()+'%');
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					Postagem po = new Postagem();
					
					po.setCodPost(valor.getLong("codPost"));
					po.setTitulo(valor.getString("titulo"));
					po.setDataC(valor.getString("dataC"));
					po.setDataM(valor.getString("dataM"));
					
					list.add(po);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public ArrayList<Postagem> listaPostagens(){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ListaPostagens DAO...");
			
			ArrayList<Postagem> list = new ArrayList<Postagem>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM ORDER BY CODPOST DESC;";
				stmt = c.prepareStatement(sql);	
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					Postagem p = new Postagem();
					
					p.setCodPost(valor.getLong("codPost"));
					p.setCodUsuario(valor.getLong("codUsuario"));
					p.setTitulo(valor.getString("titulo"));
					p.setDataC(valor.getString("dataC"));
					p.setDescricao(valor.getString("descricao"));
					
					list.add(p);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public ArrayList<Postagem> buscarPostagensCategoria(tipoJogo t){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou no buscar Postagens Categoria DAO...");
			
			ArrayList<Postagem> list = new ArrayList<Postagem>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM_JOGO WHERE CODTIPOJOGO=? ORDER BY CODPOST DESC";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, t.getCod());
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					Postagem po = new Postagem();
					
					po = pesquisarPostagemMenu(valor.getLong("codPost"));
					
					list.add(po);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public Postagem pesquisarPostagemMenu(long p){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou no Pesquisar Postagem Categoria...");
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			Postagem po = new Postagem();
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM WHERE CODPOST=?";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, p);
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					po.setCodPost(valor.getLong("codPost"));
					po.setCodUsuario(valor.getLong("codUsuario"));
					po.setTitulo(valor.getString("titulo"));
					po.setNota(valor.getFloat("nota"));	
					po.setDescricao(valor.getString("descricao"));
					po.setDataC(valor.getString("dataC"));
					po.setHorarioC(valor.getString("horarioC"));
					po.setDataM(valor.getString("dataM"));
					po.setHorarioM(valor.getString("horarioM"));
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return po;
		}
		
		public ArrayList<Postagem> buscarPostagensPlataforma(tipoPlataforma t){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou no buscar Postagens Plataforma DAO...");
			
			ArrayList<Postagem> list = new ArrayList<Postagem>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM_PLATAFORMA WHERE CODTIPOPLATAFORMA=? ORDER BY CODPOST DESC";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, t.getCod());
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					Postagem po = new Postagem();
					
					po = pesquisarPostagemMenu(valor.getLong("codPost"));
					
					list.add(po);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		public ArrayList<Postagem> visualizarPostagensUsuario(Usuario u){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ListaPostagens DAO...");
			
			ArrayList<Postagem> list = new ArrayList<Postagem>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM POSTAGEM WHERE CODUSUARIO=? ORDER BY CODPOST DESC;";
				stmt = c.prepareStatement(sql);	
				stmt.setLong(1, u.getCodigo());
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					Postagem p = new Postagem();
					
					p.setCodPost(valor.getLong("codPost"));
					p.setCodUsuario(valor.getLong("codUsuario"));
					p.setTitulo(valor.getString("titulo"));
					p.setDataC(valor.getString("dataC"));
					p.setDescricao(valor.getString("descricao"));
					
					list.add(p);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		/*
		
		public ArrayList<Postagem> visualizarPostagensAutor(String u){
			
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Entrou dentro do ListaPostagens DAO...");
			
			ArrayList<Postagem> list = new ArrayList<Postagem>();
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			try{
				c = ConectaBD.getConexao();
				String sql = "";
				
				sql = "SELECT * FROM USUARIO, POSTAGEM WHERE COD=CODUSUARIO AND NOME=? ORDER BY CODPOST DESC;";
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, u);
				
				ResultSet valor = stmt.executeQuery();

				while(valor.next()){
					Postagem p = new Postagem();
					
					p.setCodPost(valor.getLong("codPost"));
					p.setCodUsuario(valor.getLong("codUsuario"));
					p.setTitulo(valor.getString("titulo"));
					p.setDataC(valor.getString("dataC"));
					p.setDescricao(valor.getString("descricao"));
					
					list.add(p);
				}
				
				stmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("-------------------------------");
			
			return list;
		}
		
		*/
		
		public boolean verificadorNome(Postagem p){
			
			Connection c = null;
			PreparedStatement stmt = null;
			
			boolean autenticado = false;
			
			if(p.getTitulo()!=null){
				try{
					c = ConectaBD.getConexao();
					String sql = "";
					
					sql = "SELECT * FROM POSTAGEM WHERE TITULO=?;";
					stmt = c.prepareStatement(sql);	
					stmt.setString(1, p.getTitulo());
					
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
