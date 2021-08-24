package br.com.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.DAO.UsuarioDAO;
import br.com.academy.model.Usuario;

@Controller
public class UsuarioController {

	@GetMapping("/")
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		
		return mv;
	}
	@Autowired
	private UsuarioDAO usuariorepositorio;
	
	@GetMapping("/cadastro")
	public ModelAndView cadastrar() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario",new Usuario());

		mv.setViewName("Login/cadastro");
		
		return mv;
	}
	

	
	@PostMapping("salvarUsuario")
	public ModelAndView cadastrar(Usuario user) {
		ModelAndView mv = new ModelAndView();
		usuariorepositorio.save(user);
		mv.setViewName("redirect:/");
		
		
		
		return mv;
		
	}

}
