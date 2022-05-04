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
        <title>Gerente</title>
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
            <a href="${pageContext.request.contextPath}/LogoutServlet">
                <br> <button type="button" class="btn btn-danger">Sair</button>
            </a>
            <div class="container">
                </br>
                <h3> Tipo de Atendimentos</h3>
                <hr>
                <div class="row">
                    <div class="col-sm">
                        <div class="card text-center">
                            <div class="card-header">
                                <h5>${elogio.nome}</h5>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title"><c:out value="${qtdAtendimentosAbertosElogio}"/>/<c:out value="${qtdAtendimentosElogio}"/></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="card text-center">
                            <div class="card-header">
                                <h5>${reclamacao.nome}</h5>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title"><c:out value="${qtdAtendimentosAbertosReclamacao}"/>/<c:out value="${qtdAtendimentosReclamacao}"/></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="card text-center">
                            <div class="card-header">
                                <h5>${sugestao.nome}</h5>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title"><c:out value="${qtdAtendimentosAbertosSugestao}"/>/<c:out value="${qtdAtendimentosSugestao}"/></h5>
                            </div>
                        </div>
                    </div>
                </div><br>
                <h4> Visão Geral</h4>
                <hr>

                <div class="row">
                    <div class="col-sm">
                        <div class="card text-center">
                            <div class="card-header">
                                <h5>Atendimentos efetuados (total):</h5>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title"><c:out value="${qtdAtendimentos}"/></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="card text-center">
                            <div class="card-header">
                                <h5>Atendimentos em Aberto:</h5>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title"><c:out value="${qtdAtendimentosAbertos}"/></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="card text-center">
                            <div class="card-header">
                                <h5>Porcentagem em Relação ao Total:</h5>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title"><c:out value="${percentualAtendimentosAbertos}"/>%</h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
            <div class="footer">
                Em caso de problemas contactar o administrador:
                <a href="mailto:${configuracao.email}">
                <c:out value="${configuracao.email}" /> </a>
            </div><br>              
        </div>  
    </body>
</html>
