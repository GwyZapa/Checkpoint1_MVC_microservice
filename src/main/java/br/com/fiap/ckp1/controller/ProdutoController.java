package br.com.fiap.ckp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.ckp1.models.Categorias;
import br.com.fiap.ckp1.models.Fornecedores;
import br.com.fiap.ckp1.models.Produto;
import br.com.fiap.ckp1.repositories.CategoriasRepository;
import br.com.fiap.ckp1.repositories.FornecedoresRepository;
import br.com.fiap.ckp1.repositories.ProdutoRepository;


@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired //injeção de dependências
	private ProdutoRepository produtoRepository;
	@Autowired
    private FornecedoresRepository fornecedoresRepository;
	@Autowired
    private CategoriasRepository categoriasRepository;
	@GetMapping("")
	public ModelAndView get() {
		
		ModelAndView model = new ModelAndView("produto/index");
		List<Produto> listaProdutos = produtoRepository.findAll();
		model.addObject("produto", listaProdutos);
		
		
		List<Fornecedores> fornecedores = fornecedoresRepository.findAll();
		    model.addObject("fornecedores", fornecedores);

		 
		 List<Categorias> categorias = categoriasRepository.findAll();
		 model.addObject("categorias", categorias);
		return model;

	}

	@GetMapping("/create")
	public String create() {		
		return "produto/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("produto") Produto objProduto) {
		//enviar para base de dados
		produtoRepository.save(objProduto);
		
	
		    
		return "redirect:/produto";
	
		
		
	}



	

}
