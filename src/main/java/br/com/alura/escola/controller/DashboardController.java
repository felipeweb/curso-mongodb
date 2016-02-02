package br.com.alura.escola.controller;

import br.com.alura.escola.dao.AlunoDao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import javax.inject.Inject;

@Controller
public class DashboardController {
    private final Result result;
    private final AlunoDao alunoDao;

    /**
     * @deprecated CDI eyes only
     */
    protected DashboardController() {
        this(null, null);
    }

    @Inject
    public DashboardController(Result result, AlunoDao alunoDao) {
        this.result = result;
        this.alunoDao = alunoDao;
    }

    @Get("/")
    public void index() {
        result.include("alunos",  alunoDao.lista());
    }
}
