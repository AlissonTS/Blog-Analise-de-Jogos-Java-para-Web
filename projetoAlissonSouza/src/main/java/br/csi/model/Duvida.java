package br.csi.model;

public class Duvida {

		private Long codDuvida;
		private String email;
		private String duvida;
		private String resposta;
		
		public Long getCodDuvida() {
			return codDuvida;
		}
		public void setCodDuvida(Long codDuvida) {
			this.codDuvida = codDuvida;
		}
		public String getEmail() {
			return email.toUpperCase();
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDuvida() {
			return duvida;
		}
		public void setDuvida(String duvida) {
			this.duvida = duvida;
		}
		public String getResposta() {
			return resposta;
		}
		public void setResposta(String resposta) {
			this.resposta = resposta;
		}	
}
