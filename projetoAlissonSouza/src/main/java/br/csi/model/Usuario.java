package br.csi.model;

public class Usuario {
		
		private Long codigo;
		private String email;
		private String nome;
		private String senha;
		private String dataNasc;
		private String ocupacao;
		private String descricao;
		private String dataCriacao;
		private String dataModific;
		private String horaCriacao;
		private String horaModific;
		
		public String getHoraCriacao() {
			return horaCriacao;
		}
		public void setHoraCriacao(String horaCriacao) {
			this.horaCriacao = horaCriacao;
		}
		public String getHoraModific() {
			return horaModific;
		}
		public void setHoraModific(String horaModific) {
			this.horaModific = horaModific;
		}
		public Long getCodigo() {
			return codigo;
		}
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		public String getEmail() {
			return email.toUpperCase();
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getNome() {
			return nome.toUpperCase();
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getSenha() {
			return senha.toUpperCase();
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public String getOcupacao() {
			return ocupacao.toUpperCase();
		}
		public void setOcupacao(String ocupacao) {
			this.ocupacao = ocupacao;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getDataCriacao() {
			return dataCriacao;
		}
		public void setDataCriacao(String dataCriacao) {
			this.dataCriacao = dataCriacao;
		}
		public String getDataModific() {
			return dataModific;
		}
		public void setDataModific(String dataModific) {
			this.dataModific = dataModific;
		}
		public String getDataNasc() {
			return dataNasc;
		}
		public void setDataNasc(String dataNasc) {
			this.dataNasc = dataNasc;
		}
}
