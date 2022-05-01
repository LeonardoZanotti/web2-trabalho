<%-- 
    Document   : cadastro
    Created on : 23/07/2021, 21:48:20
    Author     : jessi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page errorPage = "/erro.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
  <html>
    <head>
     <meta charset="UTF-8"/>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" /> 
        <script>
            $(document).ready(function() {
                // Puxa as cidades
                getCidades();
                
                // Seta o listener no combo estados
                $( "#estado" ).change(function() {
                  getCidades();
                });         
                
            });
            function getCidades(){
                var estadoId = $("#estado").val();
                //alert(estadoId);
                var url = "/AJAXServlet";
                $.ajax({
                        url : url, // URL da sua Servlet
                        data : {
                            estadoId : estadoId
                        }, // Parâmetro passado para a Servlet
                        dataType : 'json',
                        success : function(data) {
                            // Se sucesso, limpa e preenche a combo de cidade
                            // alert(JSON.stringify(data));
                            $("#cidade").empty();
                            $.each(data, function(i, obj) {
                            $("#cidade").append('<option value=' + obj.id + '')+' >' + obj.nome + '</option>');
                            });
                        },
                        error : function(request, textStatus, errorThrown) {
                            alert(request.status + ', Error: ' + request.statusText);
                             // Erro
                        }
                    });
            }
        </script>
        
        <title>Cadastro</title>
    </head>
    <body>
        <div class='wrapper page-extra'>
          <nav class='top-section navbar'>
            <h3> Cadastro </h3>
            <a href="${pageContext.request.contextPath}/LogoutServlet" class="float-right btn btn-danger rounded">Sair</a>
          </nav>   
        <div class="container">
          <div class="row login">
            <div class="col-md-12"> 
               <br><h2> Bem-vinda(o)!</h2>
               <h1 class="title h1 m-0 mt-4 text-center">Insira seus dados</h1><br>
                <form class="form shadow " action="${pageContext.request.contextPath}/AutoCadastroServlet method="post">     
                    <div class="form-group">
                     <div class="row">

                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="first_name">Nome</label>
                            <input type="text" class="form-control" id="primeiroNome" name="primeiroNome" required="true" minlength="2" maxlength="50" value="${cliente.primeiroNome}">
                          </div> 
                        </div> 

                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="first_name">Sobrenome</label>
                            <input type="text" class="form-control" id="sobreNome" name="sobreNome" required="true"  minlength="2" maxlength="50" value="${cliente.sobreNome}">
                          </div> 
                        </div>

                        <div class="col-sm-6">
                          <div class="form-group ">
                              <label for="phone">Telefone</label>
                              <input type="tel" class="form-control" id="telefone" name="telefone" required="true" data-mask="(00) 00000-0009"  minlength="8" autocomplete="off" maxlength="15" value="${cliente.telefone}">
                          </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="form-group">
                              <label for="cpf">CPF</label>
                              <input type="text" class="form-control" id="cpf" name="cpf" required="true" data-mask="000.000.000-00"  autocomplete="off" maxlength="14" value="${cliente.cpf}">
                            </div>
                        </div>

                        <div class="col-12">
                          <div class="form-group">
                            <label for="street">Rua</label>
                            <input type="text" class="form-control" id="rua" name="rua"required="true" autocomplete="off"  maxlength="50" value="${cliente.endereco.rua}">
                          </div>
                        </div>

                        <div class="col-sm-6">
                          <div class="form-group">
                              <label for="number">Nº</label>
                              <input type="number"class="form-control" id="numero" name="numero" required="true" minlength="8" autocomplete="off" maxlength="15" value="${cliente.endereco.numero}">
                          </div>
                        </div>


                        <div class="col-sm-6">
                          <div class="form-group">
                              <label for="neighborhood">Bairro</label>
                              <input type="text" class="form-control" id="bairro" name="bairro" required="true"  minlength="2"  maxlength="20" value="${cliente.endereco.bairro}">
                          </div>
                        </div>

                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="addressComplement">Complemento</label>
                            <input type="text" class="form-control"  id="complemento" name="complemento" required="true" maxlength="10" value="${cliente.endereco.complemento}">
                          </div> 
                        </div> 

                        <div class="col-sm-6">
                            <div class="form-group">
                              <label for="addressPostcode">CEP</label>
                              <input type="text" class="form-control" id="cep" name="cep" data-mask="00.000-000" data-lbkey="cep"  required="true" maxlength="10" value="${cliente.endereco.cep}">
                            </div>
                        </div>

                        <div class="col-sm-6">
                          <div class="form-group">
                              <label for="state">Estado</label>
                              <select class="form-control"  id="estado" name="estado" required><br><br>
                               <c:forEach var="estado" items="${estado.listaEstados}">
                            <option value="${estado.id}" ${estado.id == clienteId.cidade.estado.idEstado ? "selected" : ""}>
                                <c:out value="${estado.sigla} - ${estado.nome}" />
                            </option>
                               </c:forEach>
                             </select>
                          </div>
                        </div>

                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="city">Cidade</label>
                            <select class="form-control"  id="cidade" name="cidade"   required>
                                <c:forEach var="cidade" items="${listaCidades}">
                                    <option value="${cidade.id}">
                                        <c:out value="${cidade.nome}" />
                                    </option>
                                </c:forEach>
                            </select>
                          </div>
                        </div>
                              
                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="password">Senha </label>
                            <input type="password" class="form-control" id="senha" name="senha" required="true"  minlength="6" autocomplete="off" value="${cliente.senha}">
                          </div>
                        </div>
                            
                        <div class="col-12">
                          <div class="form-group">
                            <label for="email">E-mail</label>
                            <input type="email" class="form-control" id="email" name="email" required="true"  maxlength="25" value="${cliente.email}">
                          </div>
                        </div>
                          
                    <div class="col-sm-6">
                        <div class="form-group">
                            <div class="row align-items-center">
                                <div class="col-sm-6 mt-4 mt-sm-0"><br>
                                    <button type="submit"  class="btn btn-info" >Cadastrar</button>
                                </div>
                            </div>
                        </div>
                   </div>   
                  </div>
                 </div>
                </form>                      
            </div> 
            <div class= "footer">
                    Em caso de problemas contactar o administrador: <jsp:getProperty name="configuracao" property="email"/>
            </div>                         
          </div>          
        </div>   
        </div>
    </body>
 </html>