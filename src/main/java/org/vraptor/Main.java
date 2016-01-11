package org.vraptor;

import br.com.alura.escola.dao.AlunoDao;
import br.com.alura.escola.model.Aluno;
import br.com.alura.escola.model.Curso;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws Exception {
        String webappDirLocation = getWebAppDir();

        String webXmlLocation = getWebXmlLocation(webappDirLocation);

        VRaptorServer vraptor = new VRaptorServer(webappDirLocation, webXmlLocation);

        vraptor.start();
    }

    private static String getWebXmlLocation(String webappDirLocation) {
        String webxml = System.getenv("VRAPTOR_WEBXML");
        webxml = webxml == null ? webappDirLocation + "/WEB-INF/web.xml" : webxml;
        return webxml;
    }

    private static String getWebAppDir() {
        return System.getProperty("vraptor.webappdir", "src/main/webapp/");
    }

}
