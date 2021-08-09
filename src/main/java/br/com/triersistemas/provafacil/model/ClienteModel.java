package br.com.triersistemas.provafacil.model;

public class ClienteModel extends PessoaModel {

	private String sintoma;
	
	public ClienteModel(String sintoma) {
		this.sintoma = sintoma;
	}

	public String getSintoma() {
		return sintoma;
	}
	
}
