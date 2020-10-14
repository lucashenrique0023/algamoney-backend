package com.algamoney.api.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoney.api.Repository.CategoriaRepository;
import com.algamoney.api.model.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		try {
			Categoria categoriaSalva = categoriaRepository.findById(codigo).orElseThrow();
			BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
			categoriaRepository.save(categoriaSalva);
			return categoriaSalva;
			
		} catch (NoSuchElementException ex) {
			throw new EmptyResultDataAccessException(1);
		}
		
	}

}
