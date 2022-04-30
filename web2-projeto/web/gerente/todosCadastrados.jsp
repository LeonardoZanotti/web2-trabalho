<%-- 
    Document   : todosCadastrados
    Author     : Giulia
--%>

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

        <c:import url="navegacao.jsp"/>
        
        <div class="container">
            </br>
            <h2>Funcionários e Gerentes cadastrados</h2>
            </br>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Telefone</th>
                        <th>Email</th>
                        <th>Opções 
                            <a href="${pageContext.request.contextPath}/GerenteServlet?action=formNovo">
                                <button type="button" class="btn btn-secondary">Novo</button>
                            </a>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="funcionario" items="${listaFuncionarios}">  
                        <tr>
                            <td><c:out value="${funcionario.primeiroNome} ${funcionario.sobreNome}"/></td>
                            <td><c:out value="${funcionario.cpf}"/></td>
                            <td><c:out value="${funcionario.telefone}"/></td>
                            <td><c:out value="${funcionario.email}"/></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/GerenteServlet?action=visualizarCadastro&idCadastrado=${funcionario.idFuncionario}&tipo=funcionario"><img src="<c:url value="/img/visualizar.png"/>" width="30" height="30"/></a>
                                <a href="${pageContext.request.contextPath}/GerenteServlet?action=formAlterarFuncionario&idCadastrado=${funcionario.idFuncionario}"><img src="<c:url value="/img/alterar.png"/>" width="30" height="30"/></a>
                                <a href="${pageContext.request.contextPath}/GerenteServlet?action=removerFuncionario&idFuncionario=${funcionario.idFuncionario}" 
                                   onclick="return confirm('Confirma a exclusão do Funcionário ${funcionario.primeiroNome} ${funcionario.sobreNome}?')">
                                    <img src="<c:url value="/img/remover.png"/>" width="30" height="30"/>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:forEach var="gerente" items="${listaGerentes}">  
                        <tr>
                            <td><c:out value="${gerente.primeiroNome} ${gerente.sobreNome}"/></td>
                            <td><c:out value="${gerente.cpf}"/></td>
                            <td><c:out value="${gerente.telefone}"/></td>
                            <td><c:out value="${gerente.email}"/></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/GerenteServlet?action=visualizarCadastro&idCadastrado=${gerente.idGerente}&tipo=gerente"><img src="<c:url value="/img/visualizar.png"/>" width="30" height="30"/></a>
                                <a href="${pageContext.request.contextPath}/GerenteServlet?action=formAlterarGerente&idCadastrado=${gerente.idGerente}"><img src="<c:url value="/img/alterar.png"/>" width="30" height="30"/></a>
                                <a href="${pageContext.request.contextPath}/GerenteServlet?action=removerGerente&idGerente=${gerente.idGerente}" 
                                   onclick="return confirm('Confirma a exclusão do Gerente ${gerente.primeiroNome} ${gerente.sobreNome}?')">
                                    <img src="<c:url value="/img/remover.png"/>" width="30" height="30"/>
                                </a>
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
