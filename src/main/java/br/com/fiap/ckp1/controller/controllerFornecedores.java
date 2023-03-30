package br.com.fiap.ckp1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.ckp1.models.Fornecedores;

import br.com.fiap.ckp1.repositories.FornecedoresRepository;

@Controller
@RequestMapping("/fornecedores")
public class controllerFornecedores {
	
	@Autowired //injeção de dependências
	private FornecedoresRepository fornecedoresRepository;

	@GetMapping("")
	public ModelAndView get() {
		
		ModelAndView model = new ModelAndView("fornecedores/index");
		List<Fornecedores> listaFornecedores = fornecedoresRepository.findAll();
		
		model.addObject("fornecedores", listaFornecedores);
		return model;

	}
	
	@GetMapping("/create")
	public String create() {		
		return "fornecedores/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("fornecedores") Fornecedores objFornecedores) {
		//enviar para base de dados
		fornecedoresRepository.save(objFornecedores);
		
		System.out.println(objFornecedores.getNome());
		System.out.println(objFornecedores.getEndereco());
		System.out.println(objFornecedores.getTelefone());
		System.out.println(objFornecedores.getId());
		
		return "redirect:/fornecedores";
	}
	
}