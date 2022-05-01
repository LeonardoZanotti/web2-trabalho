

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page errorPage = "/erro.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
  <html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Cadastro</title>
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
        
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg" value="Usuário deve se autenticar para acessar o sistema." scope="request"/>
            <jsp:forward page="index.jsp"/>
        </c:if>
        <div class='wrapper page-extra'>
          <nav class='top-section navbar'>
            <h3> Cadastro </h3>
            <a href="${pageContext.request.contextPath}/ClienteServlet?action=portal" class="float-right btn btn-danger rounded">Voltar</a>
          </nav>   
        <div class="container">
          <div class="row login">
            <div class="col-md-12"> 
               <h1 class="title h1 m-0 mt-4 text-center">Insira seus dados</h1><br>
                <form class="form shadow " action="${pageContext.request.contextPath}/ClienteServlet?action=modificaCliente&idCliente=${cliente.getIdCliente()}"" method="post">     
                    <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="first_name">Nome</label>
                            <input type="text" class="form-control" id="primeiroNome" name="primeiroNome" minlength="2" maxlength="50" value="${cliente.primeiroNome}">
                          </div> 
                        </div> 

                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="first_name">Sobrenome</label>
                            <input type="text" class="form-control" id="sobreNome" name="sobreNome" minlength="2" maxlength="50" value="${cliente.sobreNome}">
                          </div> 
                        </div>

                        <div class="col-12">
                          <div class="form-group">
                            <label for="street">Rua</label>
                            <input type="text" class="form-control" id="rua" name="rua"  autocomplete="off" maxlength="50" value="${cliente.endereco.rua}">
                          </div>
                        </div>

                        <div class="col-sm-6">
                          <div class="form-group">
                              <label for="number">Nº</label>
                              <input type="number"class="form-control" id="numero" name="numero" minlength="8" autocomplete="off" maxlength="15" value="${cliente.endereco.numero}">
                          </div>
                        </div>


                        <div class="col-sm-6">
                          <div class="form-group">
                              <label for="neighborhood">Bairro</label>
                              <input type="text" class="form-control" id="bairro" name="bairro" minlength="2"  maxlength="20" value="${cliente.endereco.bairro}">
                          </div>
                        </div>

                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="addressComplement">Complemento</label>
                            <input type="text" class="form-control"  id="complemento" name="complemento" maxlength="10" value="${cliente.endereco.complemento}">
                          </div> 
                        </div> 

                        <div class="col-sm-6">
                            <div class="form-group">
                              <label for="addressPostcode">CEP</label>
                              <input type="text" class="form-control" id="cep" name="cep" data-mask="00.000-000" data-lbkey="cep"  maxlength="10" value="${cliente.endereco.cep}">
                            </div>
                        </div>

                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="state">Estado</label>
                            <select class="custom-select" id="estado" name="estado" required>
                                <c:forEach var="estado" items="${listaEstados}">
                                    <c:choose>
                                        <c:when test="${estadoCliente.getId() == estado.getId()}">
                                          <option selected value="${estado.getId()}"}>
                                              <c:out value="${estado.nome}"/> 
                                          </option>
                                        </c:when>
                                        <c:otherwise>
                                          <option value="${estado.getId()}"}>
                                              <c:out value="${estado.nome}"/> 
                                          </option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>   
                          </div>
                        </div>

                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="city">Cidade</label>
                            <select class="custom-select" id="cidade" name="cidade" required>
                                <c:forEach var="cidade" items="${listaCidades}">
                                    <c:choose>
                                        <c:when test="${cidadeCliente.getId() == cidade.getId()}">
                                            <option selected var= "cidade" value="${cidade.getId()}">
                                                <c:out value="${cidade.nome}" />
                                            </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option var= "cidade" value="${cidade.getId()}">
                                                <c:out value="${cidade.nome}" />
                                            </option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                          </div>
                        </div>
                              
                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="password">Senha </label>
                            <input type="password" class="form-control" id="senha" name="senha"   minlength="6" autocomplete="off" value="${cliente.senha}">
                          </div>
                        </div>
                    
                        <div class="col-sm-6">
                          <div class="form-group ">
                              <label for="phone">Telefone</label>
                              <input type="tel" class="form-control" id="telefone" name="telefone" data-mask="(00) 00000-0009"  minlength="8" autocomplete="off" maxlength="15" value="${cliente.telefone}">
                          </div>
                        </div>
                     </div>
                     <button type="submit" class="btn btn-info"> Salvar </button>
                    </div>
                    </div>
                   </div>   
                  </div>
                 </div>
                </form>
                          
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-mask.min.js"></script>
        <script type="text/javascript" >
            $(document).ready(function() {
                $( "#estado" ).change(function() {
                  getCidades();
                });
            });

            function getCidades(){
                var idEstado = $("#estado").val();
                var url = "AJAXServlet";
                $.ajax({
                        url : url, // URL da sua Servlet
                        data : {
                            idEstado : idEstado
                        }, // Parâmetro passado para a Servlet
                        dataType : 'json',
                        success : function(data) {
                            // Se sucesso, limpa e preenche a combo de cidade
                            // alert(JSON.stringify(data));
                            // console.log(data);
                            $("#cidade").empty();
                            $.each(data, function(i, obj) {
                                $("#cidade").append('<option value=' + obj.idCidade + '>' + obj.nome + '</option>');
                            });
                        },
                        error : function(request, textStatus, errorThrown) {
                            alert(request.status + ', Error: ' + request.statusText);
                             // Erro
                        }
                    });
            }
        </script>
            </div> 
              <div class= "footer">
                 Em caso de problemas contactar o administrador: <jsp:getProperty name="configuracao" property="email"/>
              </div>                      
          </div>          
        </div>   
        </div>
    </body>
 </html>