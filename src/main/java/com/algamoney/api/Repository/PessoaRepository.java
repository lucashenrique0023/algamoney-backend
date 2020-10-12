package com.algamoney.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algamoney.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
