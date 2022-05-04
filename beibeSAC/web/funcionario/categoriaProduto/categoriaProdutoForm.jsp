

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "/erro.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Categoria de Produto</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg" value="Você deve fazer login para acessar o sistema." scope="request"/>
            <jsp:forward page="/index.jsp"/>
        </c:if> 
        <div class='wrapper page-extra'>
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
            <a href="${pageContext.request.contextPath}/CategoriaProdutoServlet?action=listarCategorias" class="float-right btn btn-danger rounded">Voltar</a>
          </nav>  
        <div class="container">
           <div class="col-md-12"> <br>
            <h2>Categoria de Produto </h2>
            <form class="needs-validation shadow-lg p-3 mb-5 bg-body rounded mt-4" action="${pageContext.request.contextPath}/CategoriaProdutoServlet?action=${empty categoria ? "new" : "update"}" method="post">
                <c:if test="${!empty categoria}">
                    <div class="form-group">
                        <label for="id">Id: </label>
                        <input type="text" class="form-control" name="idCategoria" placeholder="${categoria.idCategoria}" value="${categoria.idCategoria}" readonly>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="nome">Nome: </label>
                    <input type="text" maxlength="100" class="form-control" name="nome" placeholder="${categoria.nome}" value="${categoria.nome}" required>
                </div>
                <button type="submit" class="btn btn-success btn-lg ">${empty categoria ? "Salvar" : "Alterar"}</button>
            </form>
            </br>
        </div>  
    </body>
</html>