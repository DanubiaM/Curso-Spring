package edu.ifmt.cobrancaifmt;

public enum StatusTitulo {
	PENDENTE("Pendente"), //metodo para que a enum tenha um valor de iniciacao
	RECEBIDO("Recebido");	
	
	private String descricao;
	
	private StatusTitulo(String descricao){ // nesse caso, é necessário criar um construtor, 	
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
