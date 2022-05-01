

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
        <title>Atendimentos Não Resolvidos</title>
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
            </br>
            <h2>Atendimentos:</h2>
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
                    <c:forEach var="atendimento" items="${listaAtendimentosAbertos}"> 
                        <jsp:useBean id="now" class="java.util.Date" />
                        <fmt:setLocale value="en_US" />
                        <fmt:formatDate value="${now}" pattern="yyyyMMdd" var="agora"/> 
                        <fmt:formatDate value="${atendimento.dataHoraInicio.getTime()}" var="dataInicial" pattern="yyyyMMdd" />
                        <c:if test="${(agora - dataInicial) >= 7}">
                            <c:set value="red" var="color"/>
                        </c:if>
                        <c:if test="${(agora - dataInicial) < 7}">
                            <c:set value="light-grey" var="color"/>
                        </c:if>

                    <tr style="background-color: ${color}">
                        <td><c:out value="${atendimento.cliente.primeiroNome} ${atendimento.cliente.sobreNome}"/></td>
                        <td><c:out value="${atendimento.produto.nome}"/></td>
                        <td><c:out value="${atendimento.tipoAtendimento.nome}"/></td>
                        <td><c:out value="${atendimento.situacao.estado}"/></td>
                        <td><fmt:formatDate value="${atendimento.dataHoraInicio.getTime()}" pattern="dd/MM/yyyy HH:mm"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/FuncionarioServlet?action=formResolverAtendimento&idAtendimento=${atendimento.idAtendimento}"><button>Resolver</button></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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
