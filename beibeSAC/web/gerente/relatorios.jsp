<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.Atendimento"%>
<%@page errorPage = "/erro.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Relatórios</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" /> 
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg" value="Você deve fazer login para acessar o sistema." scope="request"/>
            <jsp:forward page="index.jsp"/>
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
            </br>
            <h2>Relatórios</h2>
            </br>

            <div class="row">
                <div class="row">
                    <div class="col-sm">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Relatório de Funcionários</h5>
                                <p class="card-text">Funcionários e seus dados.</p>
                                <a href="${pageContext.request.contextPath}/GeradorRelatorioServlet?action=relatorioFuncionarios" target="_blank" class="btn btn-success btn-lg btn-block">Exportar</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Relatório de Reclamações</h5>
                                <p class="card-text">Reclamações dos produtos.</p>
                                <a href="${pageContext.request.contextPath}/GeradorRelatorioServlet?action=relatorioReclamacoes" target="_blank" class="btn btn-success btn-lg btn-block">Exportar</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Relatório de Produtos Mais Reclamados</h5>
                                <p class="card-text">Três produtos da empresa com mais reclamações.</p>
                                <a href="${pageContext.request.contextPath}/GeradorRelatorioServlet?action=relatorioMaisReclamados" target="_blank" class="btn btn-success btn-lg btn-block">Exportar</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Relatório de Atendimentos em Aberto Por Data</h5>
                                <p class="card-text">Todos os atendimentos em aberto com cliente e dados do atendimento.</p>
                                <a href="${pageContext.request.contextPath}/GeradorRelatorioServlet?action=relatorioAtendimentosAbertos" target="_blank" class="btn btn-success btn-lg btn-block">Exportar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
            <div class="footer">
        Em caso de problemas contactar o administrador:
        <a href="mailto:${configuracao.email}">
        <c:out value="${configuracao.email}" /> </a>               
        </div> 
    </div><br> 
    </body> 
</html>
