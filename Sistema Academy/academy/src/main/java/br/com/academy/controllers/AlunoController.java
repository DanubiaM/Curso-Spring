package br.com.academy.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//Duvida: Por que utilizar "InsertAlunos", sendo o mesmo o nome do método anterior?
	//Resposta: observar que a action do formulario é o nome do método e ao enviarmos o formulario estamos fazendo um post
	//logo no postmapping deve conter a action, que no caso é o metodo.
	@PostMapping("/InsertAlunos")
	public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		
		if(br.hasErrors()) {
			mv.setViewName("alunos/formAluno");
			mv.addObject("aluno");
			return mv;
		}
		
		
			mv.setViewName("redirect:/alunos-adicionados");
			alunorepositorio.save(aluno);
			
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunos/alterar");
		Aluno aluno = alunorepositorio.getOne(id);
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	//lembrar que o path deve ser o nome da action no form
	@PostMapping("alterar")
	public ModelAndView alterar(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunorepositorio.save(aluno);
		mv.setViewName("redirect:/alunos-adicionados");
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id) {			
		alunorepositorio.deleteById(id);		
		return "redirect:/alunos-adicionados";
		
	}	
	
	@GetMapping("alunos-adicionados")
	public ModelAndView listagemAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunos/listaAlunos");
		mv.addObject("alunosList", alunorepositorio.findAll());
		return mv;
	}

	@GetMapping("filtro-alunos")
	public ModelAndView filtroAlunos() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunos/filtroAlunos");
		
		return mv;
		
	}
	
	@GetMapping("alunos-ativos")
	public ModelAndView listaAlunosAtivos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunos/alunos-ativos");
		mv.addObject("alunosAtivos",alunorepositorio.findByStatusAtivos());
		
		return mv;
	}
	
	@GetMapping("alunos-inativos")
	public ModelAndView listaAlunosInativos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunos/alunos-inativos");
		mv.addObject("alunosInativos",alunorepositorio.findByStatusInativo());
		
		return mv;
	}
	
	@GetMapping("alunos-trancados")
	public ModelAndView listaAlunosTrancados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunos/alunos-trancados");
		mv.addObject("alunosTrancados",alunorepositorio.findByStatusTrancado());
		
		return mv;
	}
	
	@GetMapping("alunos-cancelados")
	public ModelAndView listaAlunosCancelados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunos/alunos-cancelados");
		mv.addObject("alunosCancelados",alunorepositorio.findByStatusCancelado());
		
		return mv;
	}
	
	@PostMapping("pesquisar-aluno")
	public ModelAndView pesquisarAluno(@RequestParam(required = false) String nome){
		ModelAndView mv = new ModelAndView();
		
		List<Aluno> listaAlunos ;
		
		if (nome == null || nome.trim().isEmpty()) {
			
			listaAlunos = alunorepositorio.findAll();
		}else {
			
			listaAlunos = alunorepositorio.findByNomeContainingIgnoreCase(nome);
		}
		mv.setViewName("alunos/pesquisa-aluno");
		mv.addObject("ListaDeAlunos", listaAlunos);
		
		return mv; 
	}

	
}
