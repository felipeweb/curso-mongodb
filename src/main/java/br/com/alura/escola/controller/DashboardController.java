package br.com.alura.escola.controller;

import br.com.alura.escola.dao.AlunoDao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

import javax.inject.Inject;

@Controller
public class DashboardController {
    private final Result result;

    /**
     * @deprecated CDI eyes only
     */
    protected DashboardController() {
        this(null);
    }

    @Inject
    public DashboardController(Result result) {
        this.result = result;
    }

    @Get("/")
    public void index() {
        result.include("alunos",  new AlunoDao().listaTudo());
    }
}
