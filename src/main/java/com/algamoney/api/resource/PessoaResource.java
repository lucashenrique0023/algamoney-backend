package com.algamoney.api.resource;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algamoney.api.Repository.PessoaRepository;
import com.algamoney.api.model.Pessoa;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> listarPorCodigo(@PathVariable Long codigo){
		try {
			Pessoa pessoa = pessoaRepository.findById(codigo).orElseThrow();
			return ResponseEntity.ok(pessoa);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(pessoaSalva.getCodigo()).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	

}
