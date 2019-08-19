package br.com.cursosapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cursosapp.model.Curso;
import br.com.cursosapp.repository.CursoRepository;

@Controller
public class CursoController {
	
	@Autowired
	private CursoRepository cr;
	
	@RequestMapping(value="/curso/cadastrarCurso", method=RequestMethod.GET)
	public String form(){
		return "/curso/cursoAdd.html";
	}
	
	@RequestMapping(value="/curso/cadastrarCurso", method=RequestMethod.POST)
	public String form(Curso curso){
		
		cr.save(curso);
		return "redirect:/cursos";
	}
	
	@RequestMapping("/cursos")
	public ModelAndView listaCursos() {
		ModelAndView mv = new ModelAndView("/curso/listaCurso");
		Iterable<Curso> cursos = cr.findAll();
		mv.addObject("cursos", cursos);		
		return mv;		
	}
	
	@RequestMapping("/idCurso={id}")
	public ModelAndView detalhesCurso(@PathVariable("id") long id){
		Curso curso = cr.findById(id);
		ModelAndView mv = new ModelAndView("/curso/detalhesCurso");
		mv.addObject("curso", curso);
		return mv;
	}
}
