package br.com.triersistemas.provafacil.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoModel {

	private static long count = 0;

	private Long id;
	private EnumStatusPedidoModel status;
	private LocalDateTime dataPagamento;
	private LocalDateTime dataPedido;
	private List<ItemPedidoModel> itens;
	
	public PedidoModel(EnumStatusPedidoModel status, LocalDateTime dataPedido) {
		this.id = ++count;
		this.status = status;
		this.dataPagamento = dataPagamento;
		this.dataPedido = dataPedido;
		this.itens = new ArrayList<ItemPedidoModel>();
	}
	
	public void adicionarProduto(ProdutoModel produto, Integer qtd) {
		if (EnumStatusPedidoModel.PAGO.equals(this.status)) {
			throw new RuntimeException("Pedido finalizado");
		}
		this.itens.add(new ItemPedidoModel(produto, qtd));
	}
	

	public void pagar() {
		if (EnumStatusPedidoModel.PAGO.equals(this.status)) {
			throw new RuntimeException("Pedido já está pago");
		}
		this.dataPagamento = LocalDateTime.now();
		this.status = EnumStatusPedidoModel.PAGO;
	}

    public void removeItem(ItemPedidoModel item){
        itens.remove(item);
    }

	public Long getId() {
		return id;
	}

	public EnumStatusPedidoModel getStatus() {
		return status;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public List<ItemPedidoModel> getItens() {
		return itens;
	}
	
	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemPedidoModel i : itens) {
			soma = soma.add(i.getValorTotal());
		}
		return soma;
	}

   

}
