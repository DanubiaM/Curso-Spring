package br.com.acaedmy.Enum;

public enum Status {
	ATIVO("Ativos"),
	INATIVO("Inativo"),
	TRANCADO("Trancado"),
	CANCELADO("Cancelado");
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}
}
