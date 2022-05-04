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
        <title>Todos os Atendimentos</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg" value="Você deve fazer login para acessar o sistema." scope="request"/>
            <jsp:forward page="index.jsp"/>
        </c:if>
          <nav class='top-section navbar'>
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
            <a href="${pageContext.request.contextPath}/FuncionarioServlet?action=portal"class="float-right btn btn-danger rounded">Voltar</a>
          </nav> 
        <div class="container">
            </br>
            <h2>Atendimentos</h2>
            </br>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Cliente</th>
                        <th>Produto</th>
                        <th>Tipo de Atendimento</th>
                        <th>Situação</th>
                        <th>Data/Hora Início</th>
                        <th></th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="atendimento" items="${listaAtendimentos}"> 
                        <jsp:useBean id="now" class="java.util.Date" />
                        <fmt:setLocale value="en_US" />
                        <fmt:formatDate value="${now}" pattern="yyyyMMdd" var="agora"/> 
                        <fmt:formatDate value="${atendimento.dataHoraInicio.getTime()}" var="dataInicial" pattern="yyyyMMdd" />
                        <c:set value=" #5cb85c" var="color"/>
                        <c:if test="${atendimento.situacao.idSituacao == 1 && (agora - dataInicial) >= 7}">
                            <c:set value="#FF0000" var="color"/>
                        </c:if>
                        <c:if test="${atendimento.situacao.idSituacao == 1 && (agora - dataInicial) < 7}">
                            <c:set value="#bfa95a" var="color"/>
                        </c:if>

                        <tr>
                            <td><c:out value="${atendimento.cliente.primeiroNome} ${atendimento.cliente.sobreNome}"/></td>
                            <td><c:out value="${atendimento.produto.nome}"/></td>
                            <td><c:out value="${atendimento.tipoAtendimento.nome}"/></td>
                            <td style="background-color: ${color}"><c:out value="${atendimento.situacao.estado}"/></td>
                            <td><fmt:formatDate value="${atendimento.dataHoraInicio.getTime()}" pattern="dd/MM/yyyy HH:mm"/></td>
                            <td>
                                <c:if test="${atendimento.situacao.idSituacao == 1}">
                                    <a href="${pageContext.request.contextPath}/FuncionarioServlet?action=formResolverAtendimento&idAtendimento=${atendimento.idAtendimento}"><button class="btn btn-success btn btn-block">Resolver</button></a>
                                </c:if>
                                <c:if test="${atendimento.situacao.idSituacao == 2}">
                                    <a href="${pageContext.request.contextPath}/FuncionarioServlet?action=formResolverAtendimento&idAtendimento=${atendimento.idAtendimento}"><button class="btn btn-info btn btn-block">Visualizar</button></a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
                <div class="footer">
                    Em caso de problemas contactar o administrador:
                    <a href="mailto:${configuracao.email}">
                    <c:out value="${configuracao.email}" /> </a>
                </div><br>
        </div>    
    </body>
</html>
