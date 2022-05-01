

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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg" value="Usuário deve se autenticar para acessar o sistema." scope="request"/>
            <jsp:forward page="index.jsp"/>
        </c:if> 

        <c:import url="navegacao.jsp"/>

        <div class="container">
            <div class="container">
                </br>
                <h2>Informações Gerenciais</h2>
                </br>

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
                </div>
            </div>    
        </div>    
    </body>
    <footer style="position: fixed; bottom: 0;">
        <div class="container" style="background-color: rgba(0, 0, 0, 0.10);">
            <div class="text-center p-0">
                Em caso de problemas contactar o administrador: <jsp:getProperty name="configuracao" property="email"/>
            </div>
        </div>
    </footer>
</html>
