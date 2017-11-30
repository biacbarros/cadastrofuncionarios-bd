package br.com.sinform.empresa.model;

public enum StatusFuncionario {
	ATIVO("Ativo"), INATIVO("Inativo"), PENDENTE("Pendente");
	
	private String descricao;
	
	StatusFuncionario(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
