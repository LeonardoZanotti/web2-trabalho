<%-- 
    Document   : visualizarAtendimentos
    Created on : 30/07/2021, 17:05:18
    Author     : jessi
--%>

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
        <title> Atendimento</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
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
        <div class='wrapper page-extra'>
          <nav class='top-section navbar'>
            <h3> Atendimento </h3>
            <a href="${pageContext.request.contextPath}/ClienteServlet?action=portal" class="float-right btn btn-danger rounded">Voltar</a>
          </nav>  
        <div class="container">
          <div class="row login">
              <div class="col-md-12"> <br>
            <h2>Detalhes Atendimento </h2>
            <c:if test="${!empty atendimento}">
                <form  class="form shadow"action="${pageContext.request.contextPath}/ClienteServlet?action=mostraAtendimento&idAtendimento=${atendimento.idAtendimento}" method="post">
                    <div class="form-group">
                        <label for="produto">Produto: </label>
                        <input type="text" class="form-control" id="produto" placeholder="${atendimento.produto.nome}" value="${atendimento.produto.nome}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="tipoAtendimento">Tipo de Atendimento: </label>
                        <input type="text" class="form-control" id="tipoAtendimento" placeholder="${atendimento.tipoAtendimento.nome}" value="${atendimento.tipoAtendimento.nome}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="situacao">Situação: </label>
                        <input type="text" class="form-control" id="situacao" placeholder="${atendimento.situacao.estado}" value="${atendimento.situacao.estado}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="dataHoraInicio">Data/Hora Início: </label>
                        <fmt:formatDate value="${atendimento.dataHoraInicio.getTime()}" pattern="dd/MM/yyyy HH:mm" var="dataHoraInicio"/>
                        <input class="form-control" id="dataHoraInicio" placeholder="${dataHoraInicio}" value="${dataHoraInicio}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="reclamacao">Descrição atendimento: </label>
                        <input type="text" class="form-control" id="reclamacao" placeholder="${atendimento.reclamacao}" value="${atendimento.reclamacao}" readonly>
                    </div>
                </form>
                </br>
            </c:if>
        </div>  
    </body>
</html>