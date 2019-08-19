package br.com.cursosapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cursosapp.model.Aluno;
import br.com.cursosapp.model.Contrato;
import br.com.cursosapp.model.Curso;
import br.com.cursosapp.repository.AlunoRepository;
import br.com.cursosapp.repository.ContratoRepository;
import br.com.cursosapp.repository.CursoRepository;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRepository ar;
	
	@Autowired
	private CursoRepository cr;
	
	@Autowired
	private ContratoRepository cor;
	
	@RequestMapping(value="/aluno/cadastrarAluno", method=RequestMethod.GET)
	public String form(){
		return "/aluno/alunoAdd.html";
	}
	
	@RequestMapping(value="/aluno/cadastrarAluno", method=RequestMethod.POST)
	public String form(Aluno aluno){
		
		ar.save(aluno);
		return "redirect:/alunos";
	}
	
	@RequestMapping("/alunos")
	public ModelAndView listaAlunos() {
		ModelAndView mv = new ModelAndView("/aluno/listaAluno");
		Iterable<Aluno> alunos = ar.findAll();
		mv.addObject("alunos", alunos);		
		return mv;		
	}
	
	@RequestMapping(value="/idAluno={id}", method=RequestMethod.GET)
	public ModelAndView detalhesAluno(@PathVariable("id") long id){
		Aluno aluno = ar.findById(id);
		ModelAndView mv = new ModelAndView("/aluno/detalhesAluno");
		mv.addObject("aluno", aluno);
		
		Iterable<Curso> cursos = cr.findAll();
		mv.addObject("cursos", cursos);
				
		Iterable<Contrato> contratos = cor.findByAluno(aluno);
		mv.addObject("contratos", contratos);
		return mv;		
	}
	
	@RequestMapping(value="/idAluno={id}", method=RequestMethod.POST)
	public String detalhesAlunoContrato(@PathVariable("id") long id, Contrato contrato){
		Aluno aluno = ar.findById(id);
		contrato.setAluno(aluno);
		cor.save(contrato);		
		return "redirect:/idAluno={id}";
	}
	
	
	
	
	
	
	
}
