package com.algamoney.api.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.PessoaRepository;
import com.algamoney.api.repository.filter.PessoaFilter;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Page<Pessoa> pesquisar(PessoaFilter pessoaFilter, Pageable pageable){
		if (pessoaFilter.getNome() != null) {
			return pessoaRepository.findByNomeContainsAllIgnoreCase(pessoaFilter.getNome(), pageable);
		}
		
		return pessoaRepository.findAll(pageable);
	}
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		
		Pessoa pessoaSalva = encontrarPessoa(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		pessoaRepository.save(pessoaSalva);
		return pessoaSalva;
		
	}
	
	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoa = encontrarPessoa(codigo);
		pessoa.setAtivo(ativo);
		pessoaRepository.save(pessoa);
	}
	
	private Pessoa encontrarPessoa(Long codigo) {
		try {
			Pessoa pessoaSalva = pessoaRepository.findById(codigo).orElseThrow();
			return pessoaSalva;
		} catch (NoSuchElementException e) {
			throw new EmptyResultDataAccessException(1);
		}
	}

}
