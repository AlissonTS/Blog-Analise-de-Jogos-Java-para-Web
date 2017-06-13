package br.csi.util;

import java.sql.Connection;
import java.sql.DriverManager;

import br.csi.util.ConectaBD;

public class ConectaBD {

		public static void main(String args[]){
			
			ConectaBD.getConexao();
			System.out.println("conexão Aberta");
			
		}
		
		public static Connection getConexao(){
			
			Connection c = null;
			
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5432/internetb_aplicacao";
				String user ="postgres";
				String password="1234";
				
				c = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return c;
			
		}
	
}
	
