package br.com.dev.entidades;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {
	private long id;
	private String nome;
	private int idade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
