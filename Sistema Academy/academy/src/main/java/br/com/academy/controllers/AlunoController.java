package br.com.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.DAO.AlunoDAO;
import br.com.academy.model.Aluno;

@Controller
public class AlunoController {

	//@Autowired é a injeção de dependencia
	@Autowired
	private AlunoDAO alunorepositorio;
	
	@GetMapping("/inserirAlunos")
	public ModelAndView InsertAlunos(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunos/formAluno");	//View de retorno	
		mv.addObject("aluno",new Aluno()); //retorna a variavel aluno e instancia um novo objeto aluno 
	
		return mv;
	}
	//Dois teste: - Trocar post por get. 
	//			- Trocar o endereço do postMapping para umm  nome diferente do método anterior.
	@PostMapping("InsertAlunos")
	public ModelAndView inserirAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirec:/alunos/listAlunos");
		alunorepositorio.save(aluno);
		return mv;
	}
}
