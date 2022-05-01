

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.Atendimento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "/erro.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Resolução de Atendimento</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
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
        <div class="container">
            <h2>Resolução de Atendimento</h2>
            <c:if test="${!empty atendimento}">
                <form action="${pageContext.request.contextPath}/FuncionarioServlet?action=resolverAtendimento&idAtendimento=${atendimento.idAtendimento}" method="post">
                    <div class="form-group">
                        <label for="nomeCliente">Cliente: </label>
                        <input type="text" class="form-control" name="nomeCliente" placeholder="${atendimento.cliente.primeiroNome} ${atendimento.cliente.sobreNome}" value="${atendimento.cliente.primeiroNome} ${atendimento.cliente.sobreNome}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="produto">Produto: </label>
                        <input type="text" class="form-control" name="produto" placeholder="${atendimento.produto.nome}" value="${atendimento.produto.nome}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="tipoAtendimento">Tipo de Atendimento: </label>
                        <input type="text" class="form-control" name="tipoAtendimento" placeholder="${atendimento.tipoAtendimento.nome}" value="${atendimento.tipoAtendimento.nome}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="situacao">Situação: </label>
                        <input type="text" class="form-control" name="situacao" placeholder="${atendimento.situacao.estado}" value="${atendimento.situacao.estado}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="dataHoraInicio">Data/Hora Início: </label>
                        <fmt:formatDate value="${atendimento.dataHoraInicio.getTime()}" pattern="dd/MM/yyyy HH:mm" var="dataHoraInicio"/>
                        <input class="form-control" name="dataHoraInicio" placeholder="${dataHoraInicio}" value="${dataHoraInicio}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="reclamacao">Reclamação: </label>
                        <textarea type="text" class="form-control" rows="10" name="reclamacao" placeholder="${atendimento.reclamacao}" value="${atendimento.reclamacao}" readonly></textarea>
                    </div>
                    <div class="form-group">
                        <label for="solucao">Solução: </label>
                        <c:if test="${atendimento.situacao.idSituacao == 1}">
                            <textarea class="form-control" rows="10" type="text" maxlength="200" name="solucao" placeholder="${atendimento.solucao}" required></textarea>
                        </c:if>
                        <c:if test="${atendimento.situacao.idSituacao == 2}">
                            <textarea class="form-control" rows="10" type="text" maxlength="200" name="solucao" placeholder="${atendimento.solucao}" readonly></textarea>
                        </c:if>
                    </div>
                    <c:if test="${atendimento.situacao.idSituacao == 1}">
                        <button type="submit" class="btn btn-primary">Resolver</button>
                    </c:if>
                </form>
                </br>
                <form action="${pageContext.request.contextPath}/FuncionarioServlet?action=${atendimento.situacao.idSituacao == 1 ? "portal" : "todosAtendimentos"}" method="post">
                    <input type="submit" value="${atendimento.situacao.idSituacao == 1 ? "Cancelar" : "Voltar"}" class="btn btn-primary active"/>
                </form>
            </c:if>
        </div>  
    </body>
</html>