package com.algamoney.api.resource;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response){
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(categoriaSalva.getCodigo()).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(categoriaSalva);	
	}
	
	@GetMapping("/{codigo}")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo) {
		try {
			Categoria categoria = categoriaRepository.findById(codigo).orElseThrow();
			return ResponseEntity.ok(categoria);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
