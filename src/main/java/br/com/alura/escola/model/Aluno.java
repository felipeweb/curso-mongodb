package br.com.alura.escola.model;

import java.util.ArrayList;
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
	private List<Integer> notas = new ArrayList<>();

	public Aluno() {
	}

	public Aluno(String id, String nome, Date dataDeNascimento, Curso curso, List<Integer> notas) {
		this.id = id;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.curso = curso;
		this.notas = notas;
	}

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

	public List<Integer> getNotas() {
		return notas;
	}

	public void setNotas(List<Integer> notas) {
		this.notas = notas;
	}
}
