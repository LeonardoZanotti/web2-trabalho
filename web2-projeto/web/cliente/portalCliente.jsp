

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
     <meta charset="UTF-8"/>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Portal Cliente</title>
     <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
 </head>
  <body>    
     <c:if test="${empty sessionScope.logado}">
        <c:set var="msg" value="Usuário deve se autenticar para acessar o sistema." scope="request"/>
        <jsp:forward page="index.jsp"/>
     </c:if> 
    <div class='wrapper page-extra'>
        <nav class='top-section navbar'>
          <a href="#" class=" nav-link buttons rounded"> <h2>Portal do Cliente</h2></a>
          <a href="${pageContext.request.contextPath}/LogoutServlet" class="float-right btn btn-danger rounded">Sair</a>
        </nav>   
        <div class="container">
            <div class="row login">
              <div class="col-md-12"> 
                <hr class="featurette-divider"><br>
                    <h2> Bem-vindo(a), ${logado.getNome()}!</h2>
                <hr class="featurette-divider">
                    <div class="form shadow">     
                        <div class="row">
                            <div class="col-lg-4">
                                <h2>Novo <br> Atendimento</h2>
                                    <p><a  class="btn btn-info"href="${pageContext.request.contextPath}/ClienteServlet?action=formNovoAtendimento">Inserir </a></p>
                            </div>
                            <div class="col-lg-4">
                                <h2>Dados<br>Pessoais</h2>
                                <p><a  class="btn btn-info" href="${pageContext.request.contextPath}/ClienteServlet?action=formVisualizaCliente">Visualizar</a></p>
                            </div>
                        </div>    
                    </div>
                            
                   <div class="form shadow"> 
                       <h2> Meus Atendimentos</h2>
                        <div class="row">
                           <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Produto</th>
                                        <th>Tipo de Atendimento</th>
                                        <th>Situação</th>
                                        <th>Data/Hora Início</th>
                                        <th>Ação</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="atendimento" items="${listaAtendimentos}"> 
                                    <tr>
                                        <td><c:out value="${atendimento.produto.nome}"/></td>
                                        <td><c:out value="${atendimento.tipoAtendimento.nome}"/></td>
                                        <td><c:out value="${atendimento.situacao.estado}"/></td>
                                        <td><fmt:formatDate value="${atendimento.dataHoraInicio.getTime()}" pattern="dd/MM/yyyy HH:mm"/></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ClienteServlet?action=mostraAtendimento&idAtendimento=${atendimento.idAtendimento}" ><button class="btn btn-info">Visualizar</button></a>
                                        </td>
                                        <c:if test="${(atendimento.situacao.estado) == 'Em Aberto'}" >
                                        <td>
                                             <a href="${pageContext.request.contextPath}/ClienteServlet?action=removeAtendimento&idAtendimento=${atendimento.idAtendimento}"
                                                onclick="return confirm('Confirma a exclusão do atendimento ${atendimento.idAtendimento}?')"><button class="float-right btn btn-danger rounded">Excluir</button></a>
                                        </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>    
                    </div>
                  <div class= "footer">
                        Em caso de problemas contactar o administrador: <jsp:getProperty name="configuracao" property="email"/>
                  </div>
              </div>   
            </div>          
        </div> 
    </div>        
  </body>
</html>