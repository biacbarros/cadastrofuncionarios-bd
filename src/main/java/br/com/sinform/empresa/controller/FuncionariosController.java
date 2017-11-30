package br.com.sinform.empresa.controller;

import java.util.Arrays;
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
import br.com.sinform.empresa.model.Funcionario;
import br.com.sinform.empresa.model.StatusFuncionario;
import br.com.sinform.empresa.repository.CargosRepository;
import br.com.sinform.empresa.repository.FuncionariosRepository;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

	@Autowired
	private CargosRepository cargosRepository;
	
	@Autowired
	private FuncionariosRepository funcionariosRepository;
	
	@GetMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView ("CadastroFuncionario");
		
		mv.addObject(new Funcionario());
	
		return mv; 
	}
	
	@GetMapping
	public ModelAndView listar(){
		List<Funcionario> funcionarios = funcionariosRepository.findAll();
		ModelAndView mv = new ModelAndView("ListaFuncionarios");
		mv.addObject("funcionarios", funcionarios);
		
		return mv;
	}
	
	@ModelAttribute(name="cargos")
	public List<Cargo> cargos(){
		return cargosRepository.findAll();
	}

	
	@ModelAttribute(name="statusFuncionarioList")
	public List<StatusFuncionario> statusFuncionarioList(){
		return Arrays.asList(StatusFuncionario.values());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(Funcionario funcionario) {
		funcionariosRepository.save(funcionario);
		return "redirect:/funcionarios/novo";
	}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("CadastroFuncionario");
		mv.addObject(funcionario);
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
		funcionariosRepository.delete(id);
		return "redirect:/funcionarios";
	}

}
