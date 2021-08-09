package br.com.triersistemas.provafacil.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.provafacil.armazenamento.SalvaDados;
import br.com.triersistemas.provafacil.model.VendedorModel;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
    
    @GetMapping("/cadastrar")
    public VendedorModel cadastrarProduto(@RequestParam String razaoSocial,
    @RequestParam String cnpj,
    @RequestParam String email,
    @RequestParam String contato,
    @RequestParam String endereco) {
        VendedorModel v = new VendedorModel(razaoSocial, cnpj, email, contato, endereco);
        SalvaDados.vendedores.add(v);
        return v;
    }

    @GetMapping("/alterar")
    public VendedorModel alterarProduto(@RequestParam Long id,
    @RequestParam String razaoSocial,
    @RequestParam String cnpj,
    @RequestParam String email,
    @RequestParam String contato,
    @RequestParam String endereco) {
        for (VendedorModel v : SalvaDados.vendedores) {
            if (id.equals(v.getId())) {
                v.alterar(razaoSocial, cnpj, email, contato, endereco);
                return v;
            }
        }
        return null;
    }

    @GetMapping("/listar")
    public List<VendedorModel> listarProduto() {
        return SalvaDados.vendedores;
    }

    @GetMapping("/excluir")
    public VendedorModel excluirVendedor(@RequestParam Long id) {
        for (VendedorModel vendedores : SalvaDados.vendedores) {
            if (id.equals(vendedores.getId())) {
                SalvaDados.vendedores.remove(vendedores);
                return vendedores;
            }
        }
        return null;
    }
}
