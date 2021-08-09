package br.com.triersistemas.provafacil.armazenamento;

import java.util.ArrayList;
import java.util.List;

import br.com.triersistemas.provafacil.model.PedidoModel;
import br.com.triersistemas.provafacil.model.PessoaModel;
import br.com.triersistemas.provafacil.model.ProdutoModel;
import br.com.triersistemas.provafacil.model.VendedorModel;

public class SalvaDados {

	private SalvaDados() {}
	
	public static List<PessoaModel> pessoas = new ArrayList<>();
	public static List<ProdutoModel> produtos = new ArrayList<>();
	public static List<PedidoModel> pedidos = new ArrayList<>(); 
	public static List<VendedorModel> vendedores = new ArrayList<>(); 
	
}
