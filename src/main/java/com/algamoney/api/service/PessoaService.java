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
		
		try {
			Pessoa pessoaSalva = pessoaRepository.findById(codigo).orElseThrow();
			BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
			pessoaRepository.save(pessoaSalva);
			return pessoaSalva;
			
		} catch (NoSuchElementException e) {
			throw new EmptyResultDataAccessException(1);
		}
		
	}

}
