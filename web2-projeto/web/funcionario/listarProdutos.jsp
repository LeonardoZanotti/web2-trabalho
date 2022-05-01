

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
        <title>Produtos</title>
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
        
        <c:import url="navegacao.jsp"/>

        <div class="container">
            </br>
            <h2>Produtos:</h2>
            </br>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Peso</th>
                        <th>Preço</th>
                        <th>Categoria do Produto</th>
                        <th>Opções 
                            <a href="${pageContext.request.contextPath}/ProdutoServlet?action=formProduto">
                                <button type="button" class="btn btn-secondary">Novo</button>
                            </a>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${listaProdutos}">  
                        <tr>
                            
                            <td><c:out value="${produto.nome}"/></td>
                            <td><c:out value="${produto.descricao}"/></td>
                            <fmt:setLocale value="pt-BR"/> 
                            <td><fmt:formatNumber value="${produto.peso}" type="currency"/></td>
                            <td><fmt:formatNumber value="${produto.preco}" type="currency"/></td>
                            <td><c:out value="${produto.categoria.nome}"/></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ProdutoServlet?action=show&idProduto=${produto.idProduto}"><img src="<c:url value="/img/visualizar.png"/>" width="30" height="30"/></a>
                                <a href="${pageContext.request.contextPath}/ProdutoServlet?action=formProduto&idProduto=${produto.idProduto}"><img src="<c:url value="/img/alterar.png"/>" width="30" height="30"/></a>
                                <a href="${pageContext.request.contextPath}/ProdutoServlet?action=delete&idProduto=${produto.idProduto}" 
                                   onclick="return confirm('Confirma a exclusão da categoria ${produto.nome}?')">
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
