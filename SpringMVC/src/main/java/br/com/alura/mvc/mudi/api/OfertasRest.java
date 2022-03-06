package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@PostMapping()
	public Oferta criaOferta(RequisicaoNovaOferta requisicao) {
		Optional<Pedido> pedidobuscado = pedidoRepository.findById(requisicao.getPedidoId());
	
		if(!pedidobuscado.isPresent()) {
			return null;
		}
		Pedido pedido = pedidobuscado.get(); //Pega o  pedido, que possui uma lista de ofertas
		Oferta novaOferta = requisicao.toOferta();   // Transformo DTO para Oferta
		novaOferta.setPedido(pedido);				//Set o pedido devido a relação existente.
		pedido.getOfertas().add(novaOferta);		//	Como existe relação entre oferta e pedido, adiciona a oferta a lista de ofertas do pedido.
		
		pedidoRepository.save(pedido); 			//Atualizo o pedido com uma nova oferta.
		
		
		return novaOferta;
	}
}
