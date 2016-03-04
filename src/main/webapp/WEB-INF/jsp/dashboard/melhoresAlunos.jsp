<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="/WEB-INF/includes/header.jsp"/>
<div id="wrapper">
    <c:import url="/WEB-INF/includes/navbar.jsp"/>
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Listagem de Alunos</h1>

                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Curso</th>
                                    <th>Notas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${alunos}" var="aluno">
                                    <tr>
                                        <td>${aluno.id}</td>
                                        <td>${aluno.nome}</td>
                                        <td>${aluno.curso.nome}</td>
                                        <td>
                                           <c:forEach items="${aluno.notas}" var="nota">
                                               ${nota}
                                           </c:forEach>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
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