package br.com.alura.escola.controller;

import br.com.alura.escola.dao.AlunoDao;
import br.com.alura.escola.model.Aluno;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import javax.inject.Inject;

/**
 * Created by felipeweb on 1/19/16.
 */
@Controller
public class AlunoController {
	private final Result result;
	private final AlunoDao alunoDao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected AlunoController() {
		this(null, null);
	}

	@Inject
	public AlunoController(Result result, AlunoDao alunoDao) {
		this.result = result;
		this.alunoDao = alunoDao;
	}

	@Get("/aluno/atualizaNotas")
	public void atualizaNotas(String id, Integer nota) {
		alunoDao.atualizaNota(id, nota);
		result.redirectTo("/aluno/atualiza?id=" + id);
	}

	@Get
	public void adiciona() {
	}

	@Get
	public void atualiza(String id) {
		result.include("aluno", alunoDao.listaPorId(id));
	}

	@Post
	public void save(Aluno aluno) {
		if (aluno.getId() == null) {
			alunoDao.insere(aluno);
		} else {
			alunoDao.atualiza(aluno);
		}
		result.redirectTo(DashboardController.class).index();
	}

	@Get
	public void remove(String id) {
		alunoDao.remove(id);
		result.redirectTo(DashboardController.class).index();
	}
}
