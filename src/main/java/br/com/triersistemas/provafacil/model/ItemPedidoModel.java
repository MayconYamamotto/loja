package br.com.triersistemas.provafacil.model;

import java.math.BigDecimal;

public class ItemPedidoModel {

    private static long count = 0;

    private Long id;
    private Integer qtd;
    private ProdutoModel produto;
    private BigDecimal valorTotal;

    public ItemPedidoModel(ProdutoModel produto, Integer qtd) {
        this.id = ++count;
        this.qtd = qtd;
        this.produto = produto;
        this.valorTotal = produto.getValor().multiply(BigDecimal.valueOf(qtd)).add(produto.getFrete());
    }

    public void alterar(Integer qtd) {
        this.qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

}
