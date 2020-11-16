package com.algamoney.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Lancamento.class)
public abstract class Lancamento_ {

	public static SingularAttribute<Lancamento, Long> codigo ;
	public static SingularAttribute<Lancamento, String> observacao ;
	public static SingularAttribute<Lancamento, TipoPagamento> tipo ;
	public static SingularAttribute<Lancamento, LocalDate> dataPagamento ;
	public static SingularAttribute<Lancamento, Pessoa> pessoa ;
	public static SingularAttribute<Lancamento, LocalDate> dataVencimento ;
	public static SingularAttribute<Lancamento, Categoria> categoria ;
	public static SingularAttribute<Lancamento, BigDecimal> valor ;
	public static SingularAttribute<Lancamento, String> descricao ;
}
