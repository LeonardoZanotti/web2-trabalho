<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "/erro.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro do Colaborador</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
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
        <c:catch var="exception">${cadastrado.idGerente}</c:catch>
        <c:if test="${not empty exception}">
            <c:set var="idCadastrado" value="${cadastrado.idFuncionario}"/>
            <c:set var="titulo" value="Funcionário"/>
        </c:if>
        <c:if test="${empty exception}">
            <c:set var="idCadastrado" value="${cadastrado.idGerente}"/>
            <c:set var="titulo" value="Gerente"/>
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
            <a href="${pageContext.request.contextPath}/GerenteServlet?action=todosCadastrados"class="float-right btn btn-danger rounded">Voltar</a>
          </nav>    
          <div class="container"><br>
            <h2>Cadastro de ${titulo}</h2>
            <div class="needs-validation shadow-lg p-3 mb-5 bg-body rounded mt-4">
            <div class="form-group">
                <label for="idCadastrado">Id: </label>
                <input type="text" class="form-control" value="${idCadastrado}" readonly>
            </div>
            <div class="form-group">
                <label for="primeiroNome">Primeiro Nome: </label>
                <input type="text" maxlength="50" class="form-control" name="primeiroNome" placeholder="${cadastrado.primeiroNome}" value="${cadastrado.primeiroNome}" readonly>
            </div>
            <div class="form-group">
                <label for="sobreNome">Sobrenome: </label>
                <input type="text" maxlength="50" class="form-control" name="sobreNome" placeholder="${cadastrado.sobreNome}" value="${cadastrado.sobreNome}" readonly>
            </div>
            <div class="form-group">
                <label for="cpf">CPF: </label>
                <c:if test="${empty cadastrado}">
                    <input type="text" class="form-control" name="cpf" data-mask="000.000.000-00" placeholder="${cadastrado.cpf}" value="${cadastrado.cpf}" readonly>
                </c:if>
                <c:if test="${!empty cadastrado}">
                    <input type="text" class="form-control" name="cpf" data-mask="000.000.000-00" placeholder="${cadastrado.cpf}" value="${cadastrado.cpf}" readonly>
                </c:if>
            </div>
            <div class="form-group">
                <label for="telefone">Telefone: </label>
                <input type="text" class="form-control" name="telefone" data-mask="(00) 00000-0009"  placeholder="${cadastrado.telefone}" value="${cadastrado.telefone}" readonly>
            </div>
            <div class="form-group">
                <label for="email">Email: </label>
                <input type="text" class="form-control" name="email" placeholder="${cadastrado.email}" value="${cadastrado.email}" readonly>
            </div>
            <div class="form-group">
                <label for="rua">Rua: </label>
                <input type="text" class="form-control" name="rua" placeholder="${cadastrado.endereco.rua}" value="${cadastrado.endereco.rua}" readonly>
            </div>
            <div class="form-group">
                <label for="numero">Número: </label>
                <input type="text" class="form-control" name="numero" placeholder="${cadastrado.endereco.numero}" value="${cadastrado.endereco.numero}" readonly>
            </div>
            <div class="form-group">
                <label for="complemento">Complemento: </label>
                <input type="text" class="form-control" name="complemento" placeholder="${cadastrado.endereco.complemento}" value="${cadastrado.endereco.complemento}"readonly>
            </div>
            <div class="form-group">
                <label for="bairro">Bairro: </label>
                <input type="text" class="form-control" name="bairro" placeholder="${cadastrado.endereco.bairro}" value="${cadastrado.endereco.bairro}" readonly>
            </div>
            <div class="form-group">
                <label for="cep">CEP: </label>
                <input type="text" class="form-control" name="cep" data-mask="00.000-000"  placeholder="${cadastrado.endereco.cep}" value="${cadastrado.endereco.cep}" readonly>
            </div>
            <div class="form-group">
                <label for="estado">Estado: </label>
                <input type="text" class="form-control" name="estado" value="${cadastrado.endereco.cidade.estado.sigla} - ${cadastrado.endereco.cidade.estado.nome}" readonly>
            </div>
            <div class="form-group">
                <label for="cidade">Cidade: </label>
                <input type="text" class="form-control" name="cidade" value="${cadastrado.endereco.cidade.nome}" readonly>
            </div>
            <div>
                <script>
                        jQuery(function($){
                        $("#phone1").mask("(99) 99999-9999");
                        $("#cpf").mask("999.999.999-99");
                        $("#cep").mask("99.999-999");
                        });
                </script>
        </div>  
    </body>

</html>