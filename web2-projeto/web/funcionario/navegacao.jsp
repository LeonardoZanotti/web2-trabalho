<%-- 
    Document   : navegacao
    Author     : Giulia
--%>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Bem vindo(a), ${logado.getNome()}</h1>
    </div>
</div> 
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link disabled">Menu</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/FuncionarioServlet?action=portal">Atendimentos em Aberto</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/FuncionarioServlet?action=todosAtendimentos">Todos os Atendimentos</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/CategoriaProdutoServlet?action=listarCategorias">Categorias de Produto</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/ProdutoServlet?action=listarProdutos ">Produtos</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
        </li>
    </ul>
</nav>
