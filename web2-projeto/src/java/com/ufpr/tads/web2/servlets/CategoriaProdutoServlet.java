/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

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

import com.ufpr.tads.web2.beans.CategoriaProduto;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.facade.CategoriaProdutoException;
import com.ufpr.tads.web2.facade.CategoriaProdutoFacade;

@WebServlet(name = "CategoriaProdutoServlet", urlPatterns = { "/CategoriaProdutoServlet" })
public class CategoriaProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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

            if (logado.getNome() != null) {
                if (action == null || action.equals("listarCategorias")) {
                    try {
                        List<CategoriaProduto> listaCategorias = CategoriaProdutoFacade.getLista();
                        if (listaCategorias.size() > 0) {
                            request.setAttribute("listaCategorias", listaCategorias);
                        }
                        RequestDispatcher rd = sc.getRequestDispatcher("/funcionario/listarCategoriasProduto.jsp");
                        rd.forward(request, response);
                    } catch (CategoriaProdutoException e) {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else if (action.equals("formCategoriaProduto")) {
                    // Se possuir idCategoria é novo cadastro
                    // Se não é alteração
                    try {
                        String idCategoriaProduto = request.getParameter("idCategoria");
                        if (idCategoriaProduto != null) {
                            CategoriaProduto categoria = CategoriaProdutoFacade
                                    .retornaCategoria(Integer.parseInt(idCategoriaProduto));
                            request.setAttribute("categoria", categoria);
                        }
                        RequestDispatcher rd = sc
                                .getRequestDispatcher("/funcionario/categoriaProduto/categoriaProdutoForm.jsp");
                        rd.forward(request, response);
                    } catch (CategoriaProdutoException e) {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else if (action.equals("new")) {
                    try {
                        CategoriaProduto categoria = new CategoriaProduto();
                        categoria.setNome(request.getParameter("nome"));
                        CategoriaProdutoFacade.adicionaCategoria(categoria);
                        response.sendRedirect(
                                request.getContextPath() + "/CategoriaProdutoServlet?action=listarCategorias");
                    } catch (CategoriaProdutoException e) {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else if (action.equals("update")) {
                    try {
                        CategoriaProduto categoria = new CategoriaProduto();
                        categoria.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
                        categoria.setNome(request.getParameter("nome"));
                        CategoriaProdutoFacade.modificaCategoria(categoria);
                        response.sendRedirect(
                                request.getContextPath() + "/CategoriaProdutoServlet?action=listarCategorias");
                    } catch (CategoriaProdutoException e) {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else if (action.equals("delete")) {
                    try {
                        int idCategoriaProduto = Integer.parseInt(request.getParameter("idCategoria"));
                        CategoriaProduto categoria = new CategoriaProduto();
                        categoria.setIdCategoria(idCategoriaProduto);
                        CategoriaProdutoFacade.removerCategoria(categoria);
                        response.sendRedirect(
                                request.getContextPath() + "/CategoriaProdutoServlet?action=listarCategorias");
                    } catch (CategoriaProdutoException e) {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else if (action.equals("show")) {
                    try {
                        int idCategoriaProduto = Integer.parseInt(request.getParameter("idCategoria"));
                        CategoriaProduto categoria = CategoriaProdutoFacade.retornaCategoria(idCategoriaProduto);
                        request.setAttribute("categoria", categoria);
                        RequestDispatcher rd = getServletContext()
                                .getRequestDispatcher("/funcionario/categoriaProduto/categoriaProdutoVisualizar.jsp");
                        rd.forward(request, response);
                    } catch (CategoriaProdutoException e) {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
            } else {
                RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
                request.setAttribute("msg", "Usuário deve se autentificar para acessar o sistema");
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
