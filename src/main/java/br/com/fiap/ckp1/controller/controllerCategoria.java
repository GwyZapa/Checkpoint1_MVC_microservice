package br.com.fiap.ckp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.ckp1.models.Categorias;
import br.com.fiap.ckp1.models.Produto;
import br.com.fiap.ckp1.repositories.CategoriasRepository;
import br.com.fiap.ckp1.repositories.ProdutoRepository;


@Controller
@RequestMapping("/categorias")
public class controllerCategoria {
	
	@Autowired //injeção de dependências
	private CategoriasRepository categoriasRepository;

	@GetMapping("")
	public ModelAndView get() {
		
		ModelAndView model = new ModelAndView("categorias/index");
		List<Categorias> listaCategorias = categoriasRepository.findAll();
		
		model.addObject("categorias", listaCategorias);
		return model;

	}

	@GetMapping("/create")
	public String create() {		
		return "categorias/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("categorias") Categorias objCategorias) {
		//enviar para base de dados
		categoriasRepository.save(objCategorias);
		
		System.out.println(objCategorias.getId());
		System.out.println(objCategorias.getDescricao());
		
		return "redirect:/categorias";
	}
	
	
	
}