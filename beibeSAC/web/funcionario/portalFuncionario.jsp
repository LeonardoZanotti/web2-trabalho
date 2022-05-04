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
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Portal Corporativo </title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" /> 
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg"  value="Você deve fazer login para acessar o sistema." scope="request"/>
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
                    <a class="nav-link" href="${pageContext.request.contextPath}/FuncionarioServlet?action=todosAtendimentos">Todos os Atendimentos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/CategoriaProdutoServlet?action=listarCategorias">Categorias de Produto</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ProdutoServlet?action=listarProdutos ">Produtos</a>
                </li>
            </ul>
        </nav>
          <div class="container"><br>
            <h1>Olá! ${logado.getNome()}!</h1>
            <a href="${pageContext.request.contextPath}/LogoutServlet" class="float-right btn btn-danger rounded">Sair</a>
            </br>
            <h2>Atendimentos Abertos</h2>
            </br>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Cliente</th>
                        <th>Produto</th>
                        <th>Tipo de Atendimento</th>
                        <th>Situação</th>
                        <th>Data/Hora Início</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="atendimento" items="${listaAtendimentosAbertos}"> 
                        <jsp:useBean id="now" class="java.util.Date" />
                        <fmt:setLocale value="en_US" />
                        <fmt:formatDate value="${now}" pattern="yyyyMMdd" var="agora"/> 
                        <fmt:formatDate value="${atendimento.dataHoraInicio.getTime()}" var="dataInicial" pattern="yyyyMMdd" />
                        <c:if test="${(agora - dataInicial) >= 7}">
                            <c:set value="#FF0000" var="color"/>
                        </c:if>
                        <c:if test="${(agora - dataInicial) < 7}">
                            <c:set value="#bfa95a" var="color"/>
                        </c:if>
                        
                    <tr>
                        <td><c:out value="${atendimento.idAtendimento}"/></td>
                        <td><c:out value="${atendimento.cliente.primeiroNome} ${atendimento.cliente.sobreNome}"/></td>
                        <td><c:out value="${atendimento.produto.nome}"/></td>
                        <td><c:out value="${atendimento.tipoAtendimento.nome}"/></td>
                        <td style="background-color: ${color}"><c:out value="${atendimento.situacao.estado}"/></td>
                        <td><fmt:formatDate value="${atendimento.dataHoraInicio.getTime()}" pattern="dd/MM/yyyy HH:mm"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/FuncionarioServlet?action=formResolverAtendimento&idAtendimento=${atendimento.idAtendimento}"><button class="btn btn-success btn btn-block">Resolver</button></a>
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
