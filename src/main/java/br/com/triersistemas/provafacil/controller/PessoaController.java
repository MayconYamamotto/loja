package br.com.triersistemas.provafacil.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.provafacil.armazenamento.SalvaDados;
import br.com.triersistemas.provafacil.model.ClienteModel;
import br.com.triersistemas.provafacil.model.FarmaceuticoModel;
import br.com.triersistemas.provafacil.model.PessoaModel;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@GetMapping("/cadastrar-farmaceutico")
	public FarmaceuticoModel cadastrarFarmaceutico(@RequestParam String nome, @RequestParam String documento, @RequestParam String pis) {
		FarmaceuticoModel f = new FarmaceuticoModel(pis);
		SalvaDados.pessoas.add(f);
		return f;
	}
	
	@GetMapping("/cadastrar-cliente")
	public ClienteModel cadastrarCliente(@RequestParam String sintoma) {
		ClienteModel c = new ClienteModel(sintoma);
		SalvaDados.pessoas.add(c);
		return c;
	}	
	
	@GetMapping("/listar")
	public List<PessoaModel> listarPessoa() {
		return SalvaDados.pessoas;
	}
	
	@GetMapping("/excluir")
	public PessoaModel excluirPessoa(@RequestParam Long id) {
		for (PessoaModel p : SalvaDados.pessoas) {
			if (id.equals(p.getId())) {
				SalvaDados.pessoas.remove(p);
				return p;
			}
		}
		return null;
	}
	
}
