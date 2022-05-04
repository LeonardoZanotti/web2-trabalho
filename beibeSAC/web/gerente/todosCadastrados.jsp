

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.CategoriaProduto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "/erro.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrados</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg" value="Usuário deve se autenticar para acessar o sistema."
                   scope="request"/>
            <jsp:forward page="/index.jsp"/>
        </c:if> 
        
        <c:if test="${!empty requestScope.msg}">
            <div class="container">
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <c:out value="${requestScope.msg}"/>
                </div>
            </div>
        </c:if> 
                <nav class="top-section navbar navbar-expand-sm  justify-content-center navbar-dark">
            <div class="logo">
                <img
                 src="./img/coroa-logo.png"
                 width="25%"
                 height="25%"
                 background="#777"
                 color="#777"
                 text=" "
                 title=" "
                />
            </div>
            <ul class="navbar-nav">
                <li class="nav-item">
                     <a class="nav-link" href="${pageContext.request.contextPath}/GerenteServlet?action=portal">Home</a>
                </li>
                <li class="nav-item">
                   <a class="nav-link" href="${pageContext.request.contextPath}/GerenteServlet?action=todosCadastrados">Colaboradores</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/GerenteServlet?action=telaRelatorios">Relatórios</a>
                </li>
            </ul>
        </nav>
        <div class="container">
            <div class="row align-items-start">
                <div class="col-9"><br>
              <h1>Colaboradores</h1>
              </div>
                <div class="col-3 d-flex justify-content-end">
              <a href="${pageContext.request.contextPath}/GerenteServlet?action=formNovo">
                <br> <button type="button" class="btn btn-secondary">Novo</button>
              </a>
            </div>

            </div><br>  
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Telefone</th>
                        <th>Email</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="funcionario" items="${listaFuncionarios}">  
                        <tr>
                            <td><c:out value="${funcionario.primeiroNome} ${funcionario.sobreNome}"/></td>
                            <td  data-mask="000.000.000-00"><c:out value="${funcionario.cpf}"/></td>
                            <td data-mask="(00) 00000-0009"><c:out value="${funcionario.telefone}"/></td>
                            <td><c:out value="${funcionario.email}"/></td>
                            <td>
                                <a class="btn btn-info" href="${pageContext.request.contextPath}/GerenteServlet?action=visualizarCadastro&idCadastrado=${funcionario.idFuncionario}&tipo=funcionario">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
                                        <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
                                        <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
                                    </svg>
                                </a>
                                <a class="btn btn-success"  href="${pageContext.request.contextPath}/GerenteServlet?action=formAlterarFuncionario&idCadastrado=${funcionario.idFuncionario}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen-fill" viewBox="0 0 16 16">
                                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z"/>
                                    </svg>
                                </a>
                                <a class="btn btn-danger"  href="${pageContext.request.contextPath}/GerenteServlet?action=removerFuncionario&idFuncionario=${funcionario.idFuncionario}" 
                                   onclick="return confirm('Confirma a exclusão do Funcionário ${funcionario.primeiroNome} ${funcionario.sobreNome}?')">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                                    </svg>
                                 </a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:forEach var="gerente" items="${listaGerentes}">  
                        <tr>
                            <td><c:out value="${gerente.primeiroNome} ${gerente.sobreNome}"/></td>
                            <td  data-mask="000.000.000-00"><c:out value="${gerente.cpf}"/></td>
                            <td  data-mask="(00) 00000-0009"><c:out value="${gerente.telefone}"/></td>
                            <td><c:out value="${gerente.email}"/></td>
                            <td>
                                <a class="btn btn-info" href="${pageContext.request.contextPath}/GerenteServlet?action=visualizarCadastro&idCadastrado=${gerente.idGerente}&tipo=gerente">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
                                        <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
                                        <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
                                    </svg>
                                </a>
                                <a class="btn btn-success"  href="${pageContext.request.contextPath}/GerenteServlet?action=formAlterarGerente&idCadastrado=${gerente.idGerente}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen-fill" viewBox="0 0 16 16">
                                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z"/>
                                    </svg>
                                </a>
                                <a class="btn btn-danger"  href="${pageContext.request.contextPath}/GerenteServlet?action=removerGerente&idGerente=${gerente.idGerente}" 
                                   onclick="return confirm('Confirma a exclusão do Gerente ${gerente.primeiroNome} ${gerente.sobreNome}?')">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                                    </svg>
                                 </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
              <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
            <div class="footer">
                Em caso de problemas contactar o administrador:
                <a href="mailto:${configuracao.email}">
                 <c:out value="${configuracao.email}" /> </a>
            </div><br>
        </div>    
    </body>
</html>
