package br.com.triersistemas.provafacil.model;

import java.util.ArrayList;
import java.util.List;

public class VendedorModel {

    private static long count = 0;

    private long id;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String contato;
    private String endereco;
    private List<ProdutoModel> produtos;

    public VendedorModel(String razaoSocial, String cnpj, String email, String contato, String endereco) {
        this.id = ++count;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.contato = contato;
        this.endereco = endereco;
        this.produtos = new ArrayList<ProdutoModel>();
    }

    public void alterar(String razaoSocial, String cnpj, String email, String contato, String endereco) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.contato = contato;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getContato() {
        return contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<ProdutoModel> getProdutos() {
        return produtos;
    }

}
