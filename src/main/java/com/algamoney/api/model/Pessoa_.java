package com.algamoney.api.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static SingularAttribute<Pessoa, Long> codigo ;
	public static SingularAttribute<Pessoa, String> nome ;
	public static SingularAttribute<Pessoa, Boolean> ativo ;
	public static SingularAttribute<Pessoa, Endereco> endereco ;
}
