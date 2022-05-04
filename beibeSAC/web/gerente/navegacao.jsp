
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link disabled">Menu</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/GerenteServlet?action=portal">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/GerenteServlet?action=todosCadastrados">Lista de Funcion�rios/Gerentes</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/GerenteServlet?action=telaRelatorios">Relat�rios</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
        </li>
    </ul>
</nav>
        <div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Bem vindo(a), ${logado.getNome()}</h1>
    </div>
</div> 
