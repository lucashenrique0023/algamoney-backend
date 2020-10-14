package com.algamoney.api.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoney.api.Repository.PessoaRepository;
import com.algamoney.api.model.Pessoa;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
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
