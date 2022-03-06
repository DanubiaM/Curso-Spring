package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.alura.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
	
	private Long PedidoId;
	
	private String valor;
	
	private String dataDeEntrega;
	
	private String comentario;

	public Long getPedidoId() {
		return PedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		PedidoId = pedidoId;
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
		
		return null;
	}
	
	
}
