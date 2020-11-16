package com.algamoney.api.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static SingularAttribute<Categoria, Long> codigo ;
	public static SingularAttribute<Categoria, String> nome ;
}
