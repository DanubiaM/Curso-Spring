package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.interceptor.InterceptadoresDeAcesso;
import br.com.alura.mvc.mudi.interceptor.InterceptadoresDeAcesso.Acesso;

@RequestMapping("acessos")
@RestController
public class AcessoRest {
	@GetMapping
	public List<Acesso> getAcessos(){	
		
		return InterceptadoresDeAcesso.acessos;
	}
}
