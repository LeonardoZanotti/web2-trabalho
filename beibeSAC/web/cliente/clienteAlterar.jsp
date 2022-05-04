

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
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Autocadastro</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" /> 
    </head>
    <body>
        <c:if test="${empty sessionScope.logado}">
            <c:set var="msg" value="Você deve fazer login para acessar o sistema." scope="request"/>
            <jsp:forward page="index.jsp"/>
        </c:if>
        <div class='wrapper page-extra'>
           <nav class="top-section navbar">
              <div class="logo">
                <img
                  src="./img/coroa-logo.png"
                  width="20%"
                  height="20%"
                  background="#777"
                  color="#777"
                  text=" "
                  title=" "
                />
              </div>
          <a href="${pageContext.request.contextPath}/ClienteServlet?action=portal" class="float-right btn btn-danger rounded">Voltar</a>
        </nav>  
        <div class="container">
              <div class="col-md-16">
               <h1 class="title h1 m-0 mt-4 text-center">Insira seus dados</h1><br>
                <form class="needs-validation shadow-lg p-3 mb-5 bg-body rounded mt-4" action="${pageContext.request.contextPath}/ClienteServlet?action=modificaCliente&idCliente=${cliente.getIdCliente()}"" method="post">     
                    <div class="form-group">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                          <label for="fistName">Primeiro nome</label>
                            <div class="input-group">
                              <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroupPrepend">
                                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                                    <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                  </svg>
                                </span>
                              </div>
                                <input 
                                type="text" 
                                class="form-control" 
                                id="primeiroNome" 
                                name="primeiroNome" 
                                minlength="2" 
                                maxlength="50" 
                                value="${cliente.primeiroNome}"
                                required>
                              <div class="invalid-feedback">
                                Por favor, informe o seu nome.
                              </div>
                            </div>
                        </div> 

                        <div class="col-md-6 mb-3">
                            <label for="lastName">Sobrenome</label>
                              <div class="input-group">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroupPrepend">
                                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
                                        <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
                                      </svg>
                                    </span>
                                  </div>
                                    <input 
                                    type="text" 
                                    class="form-control" 
                                    id="sobreNome" 
                                    name="sobreNome" 
                                    minlength="2"
                                    maxlength="50" 
                                    value="${cliente.sobreNome}"
                                    required>
                                  <div class="invalid-feedback">
                                    Por favor, informe o seu sobrenome.
                                  </div>
                              </div>           
                        </div>

                         <div class="col-md-12 mb-3">
                            <label for="cpf">Logradouro</label>
                              <div class="input-group">
                                <div class="input-group-prepend">
                                  <span class="input-group-text" id="inputGroupPrepend">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                                      <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                                    </svg>
                                  </span>
                                </div>
                              <input
                                type="text"
                                class="form-control"
                                id="rua" 
                                name="rua"
                                required="true" 
                                autocomplete="off"  
                                maxlength="50" 
                                value="${cliente.endereco.rua}"
                              />
                              <div class="invalid-feedback">
                                Por favor, informe um logradouro válido.
                              </div>
                           </div>
                      </div>
                              
                      <div class="col-md-6 mb-3">
                        <label for="number">Nº</label>
                          <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroupPrepend">
                                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-123" viewBox="0 0 16 16">
                                    <path d="M2.873 11.297V4.142H1.699L0 5.379v1.137l1.64-1.18h.06v5.961h1.174Zm3.213-5.09v-.063c0-.618.44-1.169 1.196-1.169.676 0 1.174.44 1.174 1.106 0 .624-.42 1.101-.807 1.526L4.99 10.553v.744h4.78v-.99H6.643v-.069L8.41 8.252c.65-.724 1.237-1.332 1.237-2.27C9.646 4.849 8.723 4 7.308 4c-1.573 0-2.36 1.064-2.36 2.15v.057h1.138Zm6.559 1.883h.786c.823 0 1.374.481 1.379 1.179.01.707-.55 1.216-1.421 1.21-.77-.005-1.326-.419-1.379-.953h-1.095c.042 1.053.938 1.918 2.464 1.918 1.478 0 2.642-.839 2.62-2.144-.02-1.143-.922-1.651-1.551-1.714v-.063c.535-.09 1.347-.66 1.326-1.678-.026-1.053-.933-1.855-2.359-1.845-1.5.005-2.317.88-2.348 1.898h1.116c.032-.498.498-.944 1.206-.944.703 0 1.206.435 1.206 1.07.005.64-.504 1.106-1.2 1.106h-.75v.96Z"/>
                                  </svg>
                                </span>
                              </div>
                            <input
                              type="number"
                              class="form-control"
                              id="numero" 
                              name="numero" 
                              required="true"
                              minlength="8" 
                              autocomplete="off" 
                              maxlength="15" 
                              value="${cliente.endereco.numero}"
                            />
                            <div class="invalid-feedback">
                              Por favor, informe um número válido.
                            </div>
                          </div>
                      </div>


                       <div class="col-md-6 mb-3">
                        <label for="neigborhood">Bairro</label>
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text" id="inputGroupPrepend">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                                  <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5z"/>
                                </svg>
                              </span>
                            </div>
                              <input
                                type="text"
                                class="form-control"
                                id="bairro" 
                                name="bairro" 
                                required="true"  
                                minlength="2"  
                                maxlength="20" 
                                value="${cliente.endereco.bairro}"
                              />
                            <div class="invalid-feedback">
                              Por favor, informe um Bairro válido.
                            </div>
                          </div>
                      </div>

                      <div class="col-md-6 mb-3">
                        <label for="complement">Complemento</label>
                          <div class="input-group">
                              <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroupPrepend">
                                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z"/>
                                  </svg>
                                </span>
                                </div>
                                <input 
                                  type="text" 
                                  class="form-control" 
                                   id="complemento" name="complemento" 
                                   required="true" 
                                   maxlength="50" 
                                   value="${cliente.endereco.complemento}"
                                >
                              <div class="invalid-feedback">
                                Por favor, informe um complemento.
                              </div>
                          </div>
                      </div>

                          <div class="col-md-6 mb-3">
                        <label for="cep">CEP</label>
                        <div class="input-group">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroupPrepend">
                              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-123" viewBox="0 0 16 16">
                                <path d="M2.873 11.297V4.142H1.699L0 5.379v1.137l1.64-1.18h.06v5.961h1.174Zm3.213-5.09v-.063c0-.618.44-1.169 1.196-1.169.676 0 1.174.44 1.174 1.106 0 .624-.42 1.101-.807 1.526L4.99 10.553v.744h4.78v-.99H6.643v-.069L8.41 8.252c.65-.724 1.237-1.332 1.237-2.27C9.646 4.849 8.723 4 7.308 4c-1.573 0-2.36 1.064-2.36 2.15v.057h1.138Zm6.559 1.883h.786c.823 0 1.374.481 1.379 1.179.01.707-.55 1.216-1.421 1.21-.77-.005-1.326-.419-1.379-.953h-1.095c.042 1.053.938 1.918 2.464 1.918 1.478 0 2.642-.839 2.62-2.144-.02-1.143-.922-1.651-1.551-1.714v-.063c.535-.09 1.347-.66 1.326-1.678-.026-1.053-.933-1.855-2.359-1.845-1.5.005-2.317.88-2.348 1.898h1.116c.032-.498.498-.944 1.206-.944.703 0 1.206.435 1.206 1.07.005.64-.504 1.106-1.2 1.106h-.75v.96Z"/>
                              </svg>
                            </span>
                          </div>
                            <input
                              type="text"
                              class="form-control"
                              id="cep" 
                              name="cep"
                              data-mask="00.000-000" 
                              data-lbkey="cep"  
                              required="true" 
                              maxlength="10" 
                              value="${cliente.endereco.cep}"
                            />
                          <div class="invalid-feedback">
                            Por favor, informe um CEP válido.
                          </div>
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
                              
                         <div class="col-md-6 mb-3">
                      <label for="password">Senha</label>
                        <div class="input-group">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroupPrepend">***</span>
                          </div>
                            <input
                              type="password"
                              class="form-control"
                              id="senha" 
                              name="senha" 
                              required="true"  
                              minlength="6" 
                              autocomplete="off"
                              value="${cliente.senha}"
                            />
                          <div class="invalid-feedback">
                            Por favor, informe uma senha válida.
                          </div>
                        </div> 
                    </div> 
                    
                         <div class="col-md-6 mb-3">
                          <label for="phone1">Telefone</label>
                            <div class="input-group">
                              <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroupPrepend">
                                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone-fill" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                                  </svg>
                                </span>
                              </div>
                                <input
                                  type="tel"
                                  class="form-control"
                                  id="telefone" 
                                  name="telefone" 
                                  data-mask="(00) 00000-0009"  
                                  minlength="8" 
                                  autocomplete="off" maxlength="15"
                                  value="${cliente.telefone}"
                                  required="required"
                                />
                              <div class="invalid-feedback">
                                Por favor, informe um número para contato.
                              </div>
                            </div>
                        </div>
                     </div>
                     <div class="col-sm-6">
                        <div class="form-group">
                            <div class="row align-items-center">
                                <div class="col-sm-6 mt-3 mt-sm-0"><br>
                                    <button
                                     type="submit"
                                     class="btn btn-success btn-lg btn-block">
                                     Salvar
                                    </button>
                                </div>
                            </div>
                        </div>
                   </div> 
                       <div class="footer">
                        Em caso de problemas contactar o administrador:
                        <a href="mailto:${configuracao.email}">
                        <c:out value="${configuracao.email}" /> </a>
                       </div><br> 
                    </div>
                    </div>
                   </div>   
                  </div> 
                </form>
                <br>
                <br>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
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
          </div>          
        </div>   
        </div>
    </body>
 </html>