package edu.ifmt.cobrancaifmt;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/titulos") //tras o mapeamento /titulos para todo o controller
public class CadastroTituloController {

	@RequestMapping("/novo") 	//responsavel por mapear a url, /novo soma com /titulos = /titulos/novo
	public ModelAndView novo() {  	//além de retornar  uma String  com o nome da view 
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject(new Titulo());
		
		return mv; //retorna uma String  
	}
	@ModelAttribute("todosStatusTitulo") //Metodo responsavel por apresentar a lista de status fora do caminho /novo
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
	
	@Autowired //anotacao que injeta dependencia
	private Titulos titulos;

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(@Validated Titulo titulo, Errors errors) { 		//@validated é usada para que possa ser valida pelas regras criada no modelo
																				//Error captura os erros existentes e tras uma mensagem sobre o erro
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		
		if(errors.hasErrors()) {
			return mv;
		}
		titulos.save(titulo);
		mv.addObject("mensagem", "Foi Salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() { //obtenção de todos titulos
		List<Titulo> todosTitulos = titulos.findAll(); //findAll, disponibilizado pelo JpaRepository
		ModelAndView mv = new ModelAndView("PesquisarTitulos");
		mv.addObject("titulos", todosTitulos); //titulos sera o nome utilizado em PesquisarTitulos
		return mv;
	}
}
