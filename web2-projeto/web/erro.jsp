

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage = "true" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Erro</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
    <c:if test="${!empty msg}">
        <div class="container">
            <h2>${msg}</h2>
        </div>
    </c:if>
    <div class="container">
        <div class="container">
            <p><strong style="color: red;">${pageContext.exception.message}</strong></p>
        </div>
        <div class="container">
            <p>${pageContext.out.flush()}</p>
            <p>${pageContext.exception.printStackTrace(pageContext.response.writer)}</p>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
                <input type="submit" value="Sair" class="btn btn-primary active"/>
            </form>
        </div>
    </div>
</body>
<footer style="position: fixed; bottom: 0;">
    <div class="container" style="background-color: rgba(0, 0, 0, 0.10);">
        <div class="text-center p-0">
            Em caso de problemas contactar o administrador: <jsp:getProperty name="configuracao" property="email"/>
        </div>
    </div>
</footer>
</html>
