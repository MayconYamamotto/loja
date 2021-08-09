package br.com.triersistemas.provafacil.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.provafacil.armazenamento.SalvaDados;
import br.com.triersistemas.provafacil.model.EnumTipoProdutoModel;
import br.com.triersistemas.provafacil.model.ProdutoModel;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping("/cadastrar")
    public ProdutoModel cadastrarProduto(@RequestParam String nome, @RequestParam String descricao,
            @RequestParam BigDecimal valor, @RequestParam BigDecimal frete, @RequestParam EnumTipoProdutoModel tipo) {
        ProdutoModel p = new ProdutoModel(nome, descricao, valor, frete, tipo);
        SalvaDados.produtos.add(p);
        return p;

    }

    @GetMapping("/alterar")
    public ProdutoModel alterarProduto(@RequestParam Long id, @RequestParam String nome, @RequestParam String descricao,
            @RequestParam BigDecimal valor, @RequestParam BigDecimal frete, @RequestParam EnumTipoProdutoModel tipo) {
        for (ProdutoModel p : SalvaDados.produtos) {
            if (id.equals(p.getId())) {
                p.alterar(nome, descricao, valor, frete, tipo);
                return p;
            }
        }
        return null;
    }

    @GetMapping("/listar")
    public List<ProdutoModel> listarProduto() {
        return SalvaDados.produtos;
    }

    @GetMapping("/excluir")
    public ProdutoModel excluirProduto(@RequestParam Long id) {
        for (ProdutoModel p : SalvaDados.produtos) {
            if (id.equals(p.getId())) {
                SalvaDados.produtos.remove(p);
                return p;
            }
        }
        return null;
    }

}
