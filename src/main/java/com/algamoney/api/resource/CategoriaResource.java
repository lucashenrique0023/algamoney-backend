package com.algamoney.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algamoney.api.Repository.CategoriaRepository;
import com.algamoney.api.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar() {
		return  categoriaRepository.findAll();
	}

}
