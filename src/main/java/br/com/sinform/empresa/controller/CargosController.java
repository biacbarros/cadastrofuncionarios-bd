package br.com.sinform.empresa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sinform.empresa.model.Cargo;

import br.com.sinform.empresa.repository.CargosRepository;


@Controller
@RequestMapping("/cargos")
public class CargosController {

	@Autowired
	private CargosRepository cargosRepository;
	
	
	@GetMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView ("CadastroCargo");
		
		mv.addObject(new Cargo());
	
		return mv; 
	}
	
	@GetMapping
	public ModelAndView listar(){
		List<Cargo> cargos = cargosRepository.findAll();
		ModelAndView mv = new ModelAndView("ListaCargos");
		mv.addObject("cargos", cargos);
		
		return mv;
	}
	
	@ModelAttribute(name="cargos")
	public List<Cargo> cargos(){
		return cargosRepository.findAll();
	}

	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(Cargo cargo) {
		cargosRepository.save(cargo);
		return "redirect:/funcionarios/novo";
	}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Cargo cargo) {
		ModelAndView mv = new ModelAndView("CadastroCargo");
		mv.addObject(cargo);
		return mv;
	}
	@GetMapping("/novo/cargo")
	public ModelAndView Novocargo() {
		ModelAndView mv = new ModelAndView("CadastroCargo");
		mv.addObject(new Cargo());
		return mv;
	}	
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long id) {
		cargosRepository.delete(id);
		return "redirect:/funcionarios/novo";
	}

}
