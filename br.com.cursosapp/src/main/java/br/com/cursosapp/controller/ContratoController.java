package br.com.cursosapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cursosapp.model.Contrato;
import br.com.cursosapp.repository.ContratoRepository;

@Controller
public class ContratoController {
	
	@Autowired
	private ContratoRepository cr;
	
	@RequestMapping(value="/contrato/cadastrarContrato", method=RequestMethod.GET)
	public String form(){
		return "/contrato/contratoAdd.html";
	}
	
	@RequestMapping(value="/contrato/cadastrarContrato", method=RequestMethod.POST)
	public String form(Contrato contrato){
		
		cr.save(contrato);
		return "redirect:/contratos";
	}
	
	@RequestMapping("/contratos")
	public ModelAndView listaContratos() {
		ModelAndView mv = new ModelAndView("/contrato/listaContrato");
		Iterable<Contrato> contratos = cr.findAll();
		mv.addObject("contratos", contratos);		
		return mv;		
	}
	
	@RequestMapping("/idContrato={id}")
	public ModelAndView detalhesContrato(@PathVariable("id") long id){
		Contrato contrato = cr.findById(id);
		ModelAndView mv = new ModelAndView("/contrato/detalhesContrato");
		mv.addObject("contrato", contrato);
		return mv;
	}
}
