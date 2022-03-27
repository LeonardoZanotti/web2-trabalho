/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import database.DAOException;
import facade.ProdutoFacade;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Produto;

/**
 *
 * @author leonardozanotti
 */
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
        HttpSession session = (HttpSession) request.getSession();
        
        String action = (String) request.getParameter("action");
        RequestDispatcher rd;
        int id;
        Produto product;
        
        try {
            if (action == null) {
                List<Produto> products = ProdutoFacade.buscarTodos();
                request.setAttribute("products", products);
                rd = getServletContext().getRequestDispatcher("/jsp/ProdutoListar.jsp");
                rd.forward(request, response);
                return;
            }
            
            switch (action) {
                default:
                case "list":
                    List<Produto> products = ProdutoFacade.buscarTodos();
                    request.setAttribute("products", products);
                    rd = getServletContext().getRequestDispatcher("/jsp/ProdutoListar.jsp");
                    rd.forward(request, response);
                    break;
                case "show":
                    id = Integer.parseInt(request.getParameter("id"));
                    product = ProdutoFacade.buscar(id);
                    request.setAttribute("product", product);
                    rd = getServletContext().getRequestDispatcher("/jsp/ProdutoVisualizar.jsp");
                    rd.forward(request, response);
                    break;
                case "formUpdate":
                    id = Integer.parseInt(request.getParameter("id"));
                    product = ProdutoFacade.buscar(id);
                    request.setAttribute("product", product);
                    rd = getServletContext().getRequestDispatcher("/jsp/ProdutoAlterar.jsp");
                    rd.forward(request, response);
                    break;
                case "remove":
                    id = Integer.parseInt(request.getParameter("id"));
                    product = ProdutoFacade.buscar(id);
                    ProdutoFacade.remover(product);
                    rd = getServletContext().getRequestDispatcher("/ProdutoServlet?action=list");
                    rd.forward(request, response);
                    break;
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    Produto ProdutoBD = ProdutoFacade.buscar(id);
                    product = new Produto(
                        ProdutoBD.getId(),
                        Float.parseFloat(request.getParameter("peso")),
                        request.getParameter("nome"),
                        Integer.parseInt(request.getParameter("idCategoria")),
                        request.getParameter("descricao")
                    );
                    ProdutoFacade.alterar(product);
                    rd = getServletContext().getRequestDispatcher("/ProdutoServlet?action=list");
                    rd.forward(request, response);
                    break;
                case "formNew":
                    rd = getServletContext().getRequestDispatcher("/jsp/ProdutoNovo.jsp");
                    rd.forward(request, response);
                    break;
                case "new":
                    product = new Produto(
                        Float.parseFloat(request.getParameter("peso")),
                        request.getParameter("nome"),
                        Integer.parseInt(request.getParameter("idCategoria")),
                        request.getParameter("descricao")
                    );
                    ProdutoFacade.inserir(product);
                    rd = getServletContext().getRequestDispatcher("/ProdutoServlet?action=list");
                    rd.forward(request, response);
                    break;
            }
        } catch (DAOException | IOException | NumberFormatException | SQLException e) {
            request.setAttribute("jspException", e);
            request.setAttribute("status_code", 500);
            request.setAttribute("pageName", "Produto");
            request.setAttribute("redirect", "./ProdutoServlet?action=list");
            rd = getServletContext().getRequestDispatcher("/jsp/erro.jsp");
            rd.forward(request, response);
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
