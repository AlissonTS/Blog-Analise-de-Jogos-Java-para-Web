package br.csi.model;

public class tipoJogo {

		private Long cod;
		private String nome;
		
		public Long getCod() {
			return cod;
		}
		public void setCod(Long cod) {
			this.cod = cod;
		}
		public String getNome() {
			return nome.toUpperCase();
		}
		public void setNome(String nome) {
			this.nome = nome;
		}	
}
