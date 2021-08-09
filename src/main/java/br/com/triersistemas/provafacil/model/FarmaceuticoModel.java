package br.com.triersistemas.provafacil.model;

public class FarmaceuticoModel extends PessoaModel {

	private String pis;
	
	public FarmaceuticoModel(String pis) {
		this.pis = pis;
	}

	public String getPis() {
		return pis;
	}

}
