/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.CategoriaProduto;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.facade.CategoriaProdutoException;
import com.ufpr.tads.web2.facade.CategoriaProdutoFacade;
import com.ufpr.tads.web2.facade.ProdutoException;
import com.ufpr.tads.web2.facade.ProdutoFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");
            LoginBean logado = (LoginBean) session.getAttribute("logado");
            String action = request.getParameter("action");
            ServletContext sc = request.getServletContext();

            if (logado.getNome() != null)
            {
                if (action == null || action.equals("listarProdutos"))
                {
                    try
                    {
                        List<Produto> listaProdutos = ProdutoFacade.getLista();
                        if (listaProdutos.size() > 0)
                        {
                            request.setAttribute("listaProdutos", listaProdutos);
                        }
                        RequestDispatcher rd = sc.getRequestDispatcher("/funcionario/listarProdutos.jsp");
                        rd.forward(request, response);
                    }
                    catch (ProdutoException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (action.equals("formProduto"))
                {
                    // Se possuir idProduto é novo cadastro
                    // Se não é alteração
                    try
                    {
                        String idProduto = request.getParameter("idProduto");
                        if (idProduto != null) {
                            Produto produto = ProdutoFacade.retornaProduto(Integer.parseInt(idProduto));
                            request.setAttribute("produto", produto);
                        }
                        List<CategoriaProduto> categorias = CategoriaProdutoFacade.getLista();
                        request.setAttribute("categorias", categorias);
                        RequestDispatcher rd = sc.getRequestDispatcher("/funcionario/produto/produtoForm.jsp");
                        rd.forward(request, response);
                    }
                    catch (CategoriaProdutoException | ProdutoException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (action.equals("new"))
                {
                    try
                    {
                        Produto produto = new Produto();
                        produto.setNome(request.getParameter("nome"));
                        produto.setDescricao(request.getParameter("descricao"));
                        produto.setPeso(Float.parseFloat(request.getParameter("peso")));
                        produto.setPreco(Float.parseFloat(request.getParameter("preco")));
                        CategoriaProduto categoria = CategoriaProdutoFacade.retornaCategoria(Integer.parseInt(request.getParameter("categoria")));
                        produto.setCategoria(categoria);
                        ProdutoFacade.adicionaProduto(produto);
                        response.sendRedirect(request.getContextPath() + "/ProdutoServlet?action=listarProdutos");
                    }
                    catch (CategoriaProdutoException | ProdutoException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (action.equals("update"))
                {
                    try
                    {
                        Produto produto = new Produto();
                        produto.setIdProduto(Integer.parseInt(request.getParameter("idProduto")));
                        produto.setNome(request.getParameter("nome"));
                        produto.setDescricao(request.getParameter("descricao"));
                        produto.setPeso(Float.parseFloat(request.getParameter("peso")));
                        produto.setPreco(Float.parseFloat(request.getParameter("preco")));
                        CategoriaProduto categoria = CategoriaProdutoFacade.retornaCategoria(Integer.parseInt(request.getParameter("categoria")));
                        produto.setCategoria(categoria);
                        ProdutoFacade.modificaProduto(produto);
                        response.sendRedirect(request.getContextPath() + "/ProdutoServlet?action=listarProdutos");
                    }
                    catch (CategoriaProdutoException | ProdutoException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (action.equals("delete"))
                {
                    try
                    {
                        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                        Produto produto = new Produto();
                        produto.setIdProduto(idProduto);
                        ProdutoFacade.removerProduto(produto);
                        response.sendRedirect(request.getContextPath() + "/ProdutoServlet?action=listarProdutos");
                    }
                    catch (ProdutoException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (action.equals("show")) {
                    try {
                        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                        Produto produto = ProdutoFacade.retornaProduto(idProduto);
                        request.setAttribute("produto", produto);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/funcionario/produto/produtoVisualizar.jsp");
                        rd.forward(request, response);
                    }
                    catch (ProdutoException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
            }
            else
            {
                RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
                request.setAttribute("msg", "Usuário deve se autentificar para acessar o sistema");
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
