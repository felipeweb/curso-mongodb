package br.com.alura.escola.model;

import java.util.Date;

/**
 * Created by felipeweb on 11/25/15.
 */
public class Aluno {
	private final String id;
	private final String nome;
	private final Date dataDeNascimento;
	private final Curso curso;

	public Aluno(String id, String nome, Date dataDeNascimento, Curso curso) {
		this.id = id;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.curso = curso;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public Curso getCurso() {
		return curso;
	}
}
