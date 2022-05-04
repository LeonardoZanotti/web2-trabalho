

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
        <title>Atendimento</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" /> 
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg" value="Usuário deve se autenticar para acessar o sistema." scope="request"/>
            <jsp:forward page="index.jsp"/>
        </c:if>
        <div class="wrapper page-extra">
            <nav class="top-section navbar">
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
            <a href="${pageContext.request.contextPath}/ClienteServlet?action=portal" class="float-right btn btn-danger rounded">Voltar</a>
          </nav>   
            <div class="container">
                <div class="row login">
                    <div class="col-md-12"><br>
                        <h1 class="title h1 m-0 mt-4 text-center">Novo Atendimento</h1><br>
                        <form class="needs-validation shadow-lg p-3 mb-5 bg-body rounded mt-4" method="post" action="${pageContext.request.contextPath}/ClienteServlet?action=novoAtendimento">     
                            <input type="hidden" name="cliente" value="${cliente.id}"><br>
                            <div class="form-group">
                                <div class="col-sm-12">

                                    <div class="form-group">
                                        <label for="attendance">Tipo de atendimento</label>
                                        <select class="custom-select" id="tipoAtendimento" name="idTipoAtendimento" required>
                                            <c:forEach var="tipoAtendimento" items="${listaTipoAtendimento}">
                                                <option value="${tipoAtendimento.idTipo}"}>
                                                    <c:out value="${tipoAtendimento.nome}"/> 
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>     

                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="attendance">Produto</label>
                                    <select class="custom-select" id="produto" name="idProduto" required>
                                        <c:forEach var="produto" items="${listaProdutos}">
                                            <option value="${produto.idProduto}"}>
                                                <c:out value="${produto.nome}"/> 
                                            </option>
                                        </c:forEach>
                                    </select>             
                                </div>
                            </div>
                            <div class="col-sm-12">
                                <label for="descAtendimento">Descrição do atendimento</label>
                                <textarea id="descAtendimento" class="form-control" rows="10" name="reclamacao" minlength="1" maxlength="200" required="true"></textarea>
                            </div><br>
                             <div class="footer col-sm-12">
                                Em caso de problemas contactar o administrador:
                                <a href="mailto:${configuracao.email}">
                                <c:out value="${configuracao.email}" /> </a>
                            </div><br>
                            <br>
                            <a href="${pageContext.request.contextPath}/ClienteServlet?action=novoAtendimento"><button type="submit" class="btn btn-success "> Cadastrar </button>
                        </form></div>
                </div>   
            </div>          
        </div>
    </body>
</html>