package br.com.triersistemas.provafacil.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.provafacil.armazenamento.SalvaDados;
import br.com.triersistemas.provafacil.model.EnumStatusPedidoModel;
import br.com.triersistemas.provafacil.model.ItemPedidoModel;
import br.com.triersistemas.provafacil.model.PedidoModel;
import br.com.triersistemas.provafacil.model.ProdutoModel;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @GetMapping("/cadastrar")
    public PedidoModel CadastrarPedido() {
        PedidoModel p = new PedidoModel(EnumStatusPedidoModel.AGUARDANDO_PAGAMENTO, LocalDateTime.now());
        SalvaDados.pedidos.add(p);
        return p;
    }

    @GetMapping("/adicionar")
    public PedidoModel adicionarProduto(@RequestParam(value = "id-pedido") Long id_pedido,
            @RequestParam(value = "id-produto") Long id_produto, @RequestParam Integer qtd) {
        for (PedidoModel pedidos : SalvaDados.pedidos) {
            if (id_pedido.equals(pedidos.getId())) {
                for (ProdutoModel produtos : SalvaDados.produtos) {
                    if (id_produto.equals(produtos.getId())) {
                        pedidos.adicionarProduto(produtos, qtd);
                        return pedidos;
                    }

                }
            }
        }
        return null;
    }

    @GetMapping("/retirar")
    public void retirar(@RequestParam Long idItem) {
        for (PedidoModel pedido : SalvaDados.pedidos) {
            for (ItemPedidoModel item : pedido.getItens()) {
                if (idItem.equals(item.getId())) {
                    pedido.removeItem(item);
                }
            }
        }
    }

    @GetMapping("/alterar")
    public PedidoModel alterar(@RequestParam Long idItem, @RequestParam Integer qtd) {
        for (PedidoModel pedido : SalvaDados.pedidos) {
            for (ItemPedidoModel item : pedido.getItens()) {
                if (idItem.equals(item.getId())) {
                    item.alterar(qtd);
                    return pedido;
                }
            }
        }
        return null;
    }

    @GetMapping("/listar")
    public List<PedidoModel> listarPedidos() {
        return SalvaDados.pedidos;
    }

    @GetMapping("/pagar")
    public PedidoModel confirmarPagamento(@RequestParam Long id) {
        for (PedidoModel pedidos : SalvaDados.pedidos) {
            if (id.equals(pedidos.getId())) {
                pedidos.pagar();
                return pedidos;
            }
        }
        return null;
    }

    @GetMapping("/excluir")
    public PedidoModel excluirPedido(@RequestParam Long id) {
        for (PedidoModel pedidos : SalvaDados.pedidos) {
            if (id.equals(pedidos.getId())) {
                if (EnumStatusPedidoModel.PAGO.equals(pedidos.getStatus())) {
                    throw new RuntimeException("Já está pago");
                }
                SalvaDados.pedidos.remove(pedidos);
                return pedidos;
            }
        }
        return null;
    }

}