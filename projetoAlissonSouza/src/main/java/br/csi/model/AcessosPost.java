package br.csi.model;

public class AcessosPost {
	
	private Long codPost;
	private int acessosTotal;
	
	public Long getCodPost() {
		return codPost;
	}
	public void setCodPost(Long cod) {
		this.codPost = cod;
	}
	public int getAcessosTotal() {
		return acessosTotal;
	}
	public void setAcessosTotal(int acessosTotal) {
		this.acessosTotal = acessosTotal;
	}
}
