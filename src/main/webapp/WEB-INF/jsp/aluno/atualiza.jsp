<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="/WEB-INF/includes/header.jsp"/>
<div id="wrapper">
    <c:import url="/WEB-INF/includes/navbar.jsp"/>
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Atualizar aluno</h1>
                    <form role="form" method="post" action="/aluno/save">
                        <div class="form-group">
                            <input type="hidden" name="aluno.id" value="${aluno.id}">
                            <label for="nome">Nome</label>
                            <input class="form-control" type="text" id="nome" name="aluno.nome" value="${aluno.nome}"
                                   placeholder="Nome do aluno">
                        </div>
                        <div class="form-group">
                            <label for="data">Data de nascimento</label>
                            <input class="form-control" type="text" id="data" name="aluno.dataDeNascimento"
                                   value='<fmt:formatDate value="${aluno.dataDeNascimento}" pattern="dd/MM/yyyy"/>'
                                   placeholder="Data de nascimento do aluno (dd/mm/aaaa)">
                        </div>
                        <div class="form-group">
                            <label for="curso">Nome do curso</label>
                            <input class="form-control" type="text" id="curso" name="aluno.curso.nome"
                                   value="${aluno.curso.nome}" placeholder="Nome do curso do aluno">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success btn-block" type="submit">Atualizar</button>
                        </div>
                    </form>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
<c:import url="/WEB-INF/includes/footer.jsp"/>
