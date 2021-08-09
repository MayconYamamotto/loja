package br.com.triersistemas.provafacil.model;

import java.math.BigDecimal;

public class ProdutoModel {

	private static long count = 0;

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private BigDecimal frete;
	private EnumTipoProdutoModel tipo;
    private VendedorModel p;

	public ProdutoModel(String nome, String descricao, BigDecimal valor, BigDecimal frete, EnumTipoProdutoModel tipo) {
		this.id = ++count;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.frete = frete;
		this.tipo = tipo;
	}

	public void alterar(String nome, String descricao, BigDecimal valor, BigDecimal frete, EnumTipoProdutoModel tipo) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.frete = frete;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getFrete() {
		return frete;
	}

	public EnumTipoProdutoModel getTipo() {
		return tipo;
	}

}
