package com.algamoney.api.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoney.api.model.Lancamento;
import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.LancamentoRepository;
import com.algamoney.api.repository.PessoaRepository;
import com.algamoney.api.service.exception.PessoaInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElseThrow();
		
		if (pessoa.isInativo()) {
			throw new PessoaInativaException();
		}
		
		return lancamentoRepository.save(lancamento);
	}
	
	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		
		Lancamento lancamentoSalvo = encontrarLancamento(codigo);
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		lancamentoRepository.save(lancamentoSalvo);
		return lancamentoSalvo;
		
	}
	
	private Lancamento encontrarLancamento(Long codigo) {
		try {
			Lancamento lancamentoSalvo = lancamentoRepository.findById(codigo).orElseThrow();
			return lancamentoSalvo;
		} catch (NoSuchElementException e) {
			throw new EmptyResultDataAccessException(1);
		}
	}
}
