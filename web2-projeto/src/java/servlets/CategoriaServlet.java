/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import database.DAOException;
import facade.CategoriaFacade;
import javax.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categoria;

/**
 *
 * @author leonardozanotti
 */
@WebServlet(name = "CategoriaServlet", urlPatterns = {"/CategoriaServlet"})
public class CategoriaServlet extends HttpServlet {

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
        Categoria category;
        
        try {
            if (action == null) {
                List<Categoria> categories = CategoriaFacade.buscarTodos();
                request.setAttribute("categories", categories);
                rd = getServletContext().getRequestDispatcher("/jsp/CategoriaListar.jsp");
                rd.forward(request, response);
                return;
            }
            
            switch (action) {
                default:
                case "list":
                    List<Categoria> categories = CategoriaFacade.buscarTodos();
                    request.setAttribute("categories", categories);
                    rd = getServletContext().getRequestDispatcher("/jsp/CategoriaListar.jsp");
                    rd.forward(request, response);
                    break;
                case "show":
                    id = Integer.parseInt(request.getParameter("id"));
                    category = CategoriaFacade.buscar(id);
                    request.setAttribute("category", category);
                    rd = getServletContext().getRequestDispatcher("/jsp/CategoriaVisualizar.jsp");
                    rd.forward(request, response);
                    break;
                case "formUpdate":
                    id = Integer.parseInt(request.getParameter("id"));
                    category = CategoriaFacade.buscar(id);
                    request.setAttribute("category", category);
                    rd = getServletContext().getRequestDispatcher("/jsp/CategoriaAlterar.jsp");
                    rd.forward(request, response);
                    break;
                case "remove":
                    id = Integer.parseInt(request.getParameter("id"));
                    category = CategoriaFacade.buscar(id);
                    CategoriaFacade.remover(category);
                    rd = getServletContext().getRequestDispatcher("/CategoriaServlet?action=list");
                    rd.forward(request, response);
                    break;
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    Categoria categoriaBD = CategoriaFacade.buscar(id);
                    category = new Categoria(
                        categoriaBD.getId(),
                        request.getParameter("nome")
                    );
                    CategoriaFacade.alterar(category);
                    rd = getServletContext().getRequestDispatcher("/CategoriaServlet?action=list");
                    rd.forward(request, response);
                    break;
                case "formNew":
                    rd = getServletContext().getRequestDispatcher("/jsp/CategoriaNovo.jsp");
                    rd.forward(request, response);
                    break;
                case "new":
                    category = new Categoria(
                        request.getParameter("nome")
                    );
                    CategoriaFacade.inserir(category);
                    rd = getServletContext().getRequestDispatcher("/CategoriaServlet?action=list");
                    rd.forward(request, response);
                    break;
            }
        } catch (DAOException | IOException | NumberFormatException | SQLException e) {
            request.setAttribute("jspException", e);
            request.setAttribute("status_code", 500);
            request.setAttribute("pageName", "Categoria");
            request.setAttribute("redirect", "./CategoriaServlet?action=list");
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
