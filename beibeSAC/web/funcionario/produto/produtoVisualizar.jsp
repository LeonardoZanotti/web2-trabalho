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
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Produto</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg" value="Usuário deve se autenticar para acessar o sistema."
                   scope="request"/>
            <jsp:forward page="/index.jsp"/>
        </c:if> 
        <fmt:setLocale value="pt-BR"/> 
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
            <a href="${pageContext.request.contextPath}/ProdutoServlet?action=listarProdutos" class="float-right btn btn-danger rounded">Voltar</a>
         </nav>  <br>
        <div class="container">
            <h2>Produto</h2> <br>          
            <c:if test="${!empty produto}">
              <form class="needs-validation shadow-lg p-3 mb-5 bg-body rounded mt-4">
                <div class="form-group">
                    <label for="id">Id: </label>
                    <input type="text" class="form-control" name="idProduto" value="${produto.idProduto}" readonly>
                </div>
            </c:if>
            <div class="form-group">
                <label for="nome">Nome: </label>
                <input type="text" class="form-control" name="nome" value="${produto.nome}" readonly>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição: </label>
                <input type="text" class="form-control" name="descricao" value="${produto.descricao}"readonly>
            </div>
            <fmt:formatNumber value="${produto.peso}" type="currency" var="pesoFormatado"/>
            <div class="form-group">
                <label for="peso">Peso: </label>
                <input type="text" class="form-control" name="peso" value="${pesoFormatado}" readonly>
            </div>
            <fmt:formatNumber value="${produto.preco}" type="currency"  var="precoFormatado"/>
            <div class="form-group">
                <label for="peso">Preço: </label>
                <input type="text" class="form-control" name="preco" value="${precoFormatado}" readonly>
            </div>
            <div class="form-group">
                <label for="categoria">Categoria do Produto: </label>
                <input type="text" class="form-control" name="categoria" value="${produto.categoria.nome}" readonly>
            </div>
          </form>
        </div>
    </body>
</html>