package br.com.fiap.ckp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.ckp1.models.Clientes;
import br.com.fiap.ckp1.repositories.ClientesRepository;

@Controller
@RequestMapping("/clientes")
public class controllerClientes {
	
	@Autowired //injeção de dependências
	private ClientesRepository clientesRepository;

	@GetMapping("")
	public ModelAndView get() {
		
		ModelAndView model = new ModelAndView("clientes/index");
		List<Clientes> listaClientes = clientesRepository.findAll();
		
		model.addObject("clientes", listaClientes);
		return model;

	}

	@GetMapping("/create")
	public String create() {		
		return "clientes/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("clientes") Clientes objClientes) {
		//enviar para base de dados
		clientesRepository.save(objClientes);
		
		System.out.println(objClientes.getNome());
		System.out.println(objClientes.getEndereco());
		System.out.println(objClientes.getTelefone());
		System.out.println(objClientes.getId());
		
		return "redirect:/clientes";
	}
	
}
