package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {
	private static final DateTimeFormatter formatter = DateTimeFormatter
														.ofPattern("dd/MM/yyy");
	
	
	private Long pedidoId;
	
	//^d+ significa diversos numeros. 
	//(.d{2}) <- O parenteses demostra ser opcional o que esta contido nele. 
	//É opicional um ponto e 2 casas após. 
	@Pattern (regexp = "^\\d+(\\.\\d{2})?$")
	@NotNull
	private String valor;
	
	@Pattern (regexp = "\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String dataDeEntrega;
	
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(String dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setDataDeEntrega(LocalDate.parse(this.dataDeEntrega, formatter));
		oferta.setValor(new BigDecimal(this.valor));
		
		return oferta;
	}
	
	
}
