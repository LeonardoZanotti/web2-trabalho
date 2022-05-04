
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="/jsp/erro.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Login</title>

         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index.css" />
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page-login.css" />
    </head>
            <body class="login">
                <div class="wrapper fadeInDown">
                    <div id="formContent">
                        <!-- Icon -->
                         <div class="fadeIn first">
                             <img src="./img/user.png" id="icon" alt="User Icon" />
                         </div>
                        <form action="${pageContext.request.contextPath}/LoginServlet?action=logar" method="POST">
                            <div class="flex-row">
                                <input id="login" name="login" class="lf--input" placeholder="Usuário" type="text">
                            </div>
                            <div class="flex-row">
                                <input id="senha" class="lf--input" placeholder="Senha" name="senha" type="password">
                            </div>
                            <input class="fadeIn second" type="submit" value="Login">
                            <c:if test="${msg != null}">
                                <div class="alert alert-danger" role="alert">
                                    <c:out value="${msg}" />
                                </div>
                            </c:if>
                            <div id="formFooter">
                                 Não possui conta?
                                <a class="underlineHover" href="${pageContext.request.contextPath}/LoginServlet?action=autoCadastro" >Registre-se!</a>
                            </div>
                        </form>
                        <div class="footer">
                            Em caso de problemas contactar o administrador:<br>
                            <a href="mailto:${configuracao.email}">
                                <c:out value="${configuracao.email}" /> </a>
                        </div>
                    </div> 
                </div>  
            </div>          
        </div>
    </body>
</html>