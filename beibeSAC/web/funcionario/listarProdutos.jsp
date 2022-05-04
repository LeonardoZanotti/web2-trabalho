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
        <title>Listar Produtos</title>
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
            <c:set var="msg" value="Você deve fazer login para acessar o sistema."
                   scope="request"/>
            <jsp:forward page="/index.jsp"/>
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
            <div class="row align-items-start">
                <div class="col-9"><br>
              <h1>Produtos</h1>
              </div>
                <div class="col-3 d-flex justify-content-end">
              <a href="${pageContext.request.contextPath}/ProdutoServlet?action=formProduto">
                <br> <button type="button" class="btn btn-secondary">Novo</button>
              </a>
            </div>

            </div><br>  
            </br>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Peso</th>
                        <th>Preço</th>
                        <th>Categoria do Produto</th>
                        <th>Ações</th>
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
                               <a class="btn btn-info" href="${pageContext.request.contextPath}/ProdutoServlet?action=show&idProduto=${produto.idProduto}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
                                        <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
                                        <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
                                    </svg>
                                </a>
                                <a class="btn btn-success"  href="${pageContext.request.contextPath}/ProdutoServlet?action=formProduto&idProduto=${produto.idProduto}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen-fill" viewBox="0 0 16 16">
                                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z"/>
                                    </svg>
                                </a>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ProdutoServlet?action=delete&idProduto=${produto.idProduto}" onclick="return confirm('Confirma a exclusão da categoria ${produto.nome}?')">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                                    </svg>
                                 </a>
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
