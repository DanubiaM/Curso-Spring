package br.com.alura.mvc.mudi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public enum StatusPedido {

	AGUARDANDO, APROVADO, ENTREGUE;
	
}
