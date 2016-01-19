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

	/**
	 * @deprecated CDI eyes only
	 */
	protected AlunoController() {
		this(null);
	}

	@Inject
	public AlunoController(Result result) {
		this.result = result;
	}

	@Get
	public void adiciona() {
	}

	@Get
	public void atualiza(String id) {
		result.include("aluno", new AlunoDao().listaPorId(id));
	}

	@Post
	public void save(Aluno aluno) {
		AlunoDao alunoDao = new AlunoDao();
		if (aluno.getId() == null) {
			alunoDao.insert(aluno);
			result.redirectTo(DashboardController.class).index();
		} else {
			alunoDao.update(aluno);
			result.redirectTo(DashboardController.class).index();
		}
	}
}
