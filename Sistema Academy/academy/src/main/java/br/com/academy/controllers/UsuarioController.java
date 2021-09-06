package br.com.academy.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.DAO.UsuarioDAO;
import br.com.academy.exceptions.ServiceExcp;
import br.com.academy.model.Aluno;
import br.com.academy.model.Usuario;
import br.com.academy.service.ServiceUsuario;
import br.com.util.Util;

@Controller
public class UsuarioController {

	@GetMapping("/index")
	public ModelAndView index(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home/index");
		mv.addObject("aluno", new Aluno());
		
		
		
		
		return mv;
	}
	
	@GetMapping("/")
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		mv.addObject("usuario", new Usuario());
		
		return mv;
	}
	@Autowired
	private ServiceUsuario serviceUsuario;
	
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
	public ModelAndView cadastrar(Usuario user) throws Exception{
		ModelAndView mv = new ModelAndView();
		serviceUsuario.salvarUsuario(user);
		mv.setViewName("redirect:/");
		
		
		return mv;
		
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExcp{
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		
		if (br.hasErrors()) {
			mv.setViewName("Login/login");
		}
		
		Usuario userLogin = serviceUsuario.longinUser(usuario.getUser(), Util.md5(usuario.getSenha()));
		
		if( userLogin == null) {
			mv.addObject("msg", "Usuario não encontrado. Tente novamente!");
			
		
		}else {
			session.setAttribute("usuarioLogado", userLogin);
			
	
			//mv.setViewName("redirect:/index");
			mv.addObject("msg", "Seja Bem vindo!"+userLogin.getUser());
			return index(session);
					
		}
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/logout");
		
		return mv;
	}
}
