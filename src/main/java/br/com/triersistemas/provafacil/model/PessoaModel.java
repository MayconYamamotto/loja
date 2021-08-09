package br.com.triersistemas.provafacil.model;

public abstract class PessoaModel {

	private static long count = 0;

	private Long id;
	private String nome;
	private String documento;
	
	public PessoaModel() {
		this.id = ++count;
		this.nome = nome;
		this.documento = documento;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

}
