package br.csi.model;

import java.util.ArrayList;

public class Postagem {

		private Long codPost;
		private Long codUsuario;
		private String titulo;
		private float nota;
		private String descricao;
		private String dataC;
		private String horarioC;
		private String dataM;
		private String horarioM;
		private ArrayList<Long> categoria;
		private ArrayList<Long> plataforma;
		
		public Long getCodPost() {
			return codPost;
		}
		public void setCodPost(Long codPost) {
			this.codPost = codPost;
		}
		public Long getCodUsuario() {
			return codUsuario;
		}
		public void setCodUsuario(Long codUsuario) {
			this.codUsuario = codUsuario;
		}
		public String getTitulo() {
			return titulo.toUpperCase();
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public float getNota() {
			return nota;
		}
		public void setNota(float nota) {
			this.nota = nota;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getDataC() {
			return dataC;
		}
		public void setDataC(String dataC) {
			this.dataC = dataC;
		}
		public String getHorarioC() {
			return horarioC;
		}
		public void setHorarioC(String horarioC) {
			this.horarioC = horarioC;
		}
		public String getDataM() {
			return dataM;
		}
		public void setDataM(String dataM) {
			this.dataM = dataM;
		}
		public String getHorarioM() {
			return horarioM;
		}
		public void setHorarioM(String horarioM) {
			this.horarioM = horarioM;
		}
		public ArrayList<Long> getCategoria() {
			return categoria;
		}
		public void setCategoria(ArrayList<Long> categoria) {
			this.categoria = categoria;
		}
		public ArrayList<Long> getPlataforma() {
			return plataforma;
		}
		public void setPlataforma(ArrayList<Long> plataforma) {
			this.plataforma = plataforma;
		}		
}
