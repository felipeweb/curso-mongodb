package br.com.alura.escola.models;

import java.util.Date;
import java.util.List;

/**
 * Created by felipeweb on 11/25/15.
 */
public class Aluno {
	private String id;
	private String nome;
	private Date dataDeNascimento;
	private Curso curso;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
