package br.com.alura.escola.controllers;

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
    }
}
