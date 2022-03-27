/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import database.DAOException;
import facade.AtendimentoFacade;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Atendimento;

/**
 *
 * @author leonardozanotti
 */
@WebServlet(name = "AtendimentoServlet", urlPatterns = {"/AtendimentoServlet"})
public class AtendimentoServlet extends HttpServlet {

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
        
        String action = (String) request.getParameter("action");
        RequestDispatcher rd;
        int id;
        Atendimento atendimento;
        List<Atendimento> atendimentos;
        
        try {
            if (action == null) {
                atendimentos = AtendimentoFacade.buscarTodos();
                request.setAttribute("atendimentos", atendimentos);
                rd = getServletContext().getRequestDispatcher("/jsp/AtendimentoListar.jsp");
                rd.forward(request, response);
                return;
            }
            
            switch (action) {
                default:
                case "list":
                    atendimentos = AtendimentoFacade.buscarTodos();
                    request.setAttribute("atendimentos", atendimentos);
                    rd = getServletContext().getRequestDispatcher("/jsp/AtendimentoListar.jsp");
                    rd.forward(request, response);
                    break;
                case "list-cliente":
                    id = Integer.parseInt(request.getParameter("id"));
                    atendimentos = AtendimentoFacade.buscarPorCliente(id);
                    request.setAttribute("atendimentos", atendimentos);
                    rd = getServletContext().getRequestDispatcher("/jsp/AtendimentoListar.jsp");
                    rd.forward(request, response);
                    break;
                case "list-open":
                    atendimentos = AtendimentoFacade.buscarAbertos();
                    request.setAttribute("atendimentos", atendimentos);
                    rd = getServletContext().getRequestDispatcher("/jsp/AtendimentoListar.jsp");
                    rd.forward(request, response);
                    break;
                case "show":
                    id = Integer.parseInt(request.getParameter("id"));
                    atendimento = AtendimentoFacade.buscar(id);
                    request.setAttribute("atendimento", atendimento);
                    rd = getServletContext().getRequestDispatcher("/jsp/AtendimentoVisualizar.jsp");
                    rd.forward(request, response);
                    break;
                case "formUpdate":
                    id = Integer.parseInt(request.getParameter("id"));
                    atendimento = AtendimentoFacade.buscar(id);
                    request.setAttribute("atendimento", atendimento);
                    rd = getServletContext().getRequestDispatcher("/jsp/AtendimentoAlterar.jsp");
                    rd.forward(request, response);
                    break;
                case "remove":
                    id = Integer.parseInt(request.getParameter("id"));
                    atendimento = AtendimentoFacade.buscar(id);
                    AtendimentoFacade.remover(atendimento);
                    rd = getServletContext().getRequestDispatcher("/AtendimentoServlet?action=list");
                    rd.forward(request, response);
                    break;
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    Atendimento AtendimentoBD = AtendimentoFacade.buscar(id);
                    atendimento = new Atendimento(
                        AtendimentoBD.getId(),
                        Integer.parseInt(request.getParameter("idProduto")),
                        Integer.parseInt(request.getParameter("idCliente")),
                        new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataInicio")),
                        new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataFim")),
                        request.getParameter("reclamacao"),
                        request.getParameter("solucao"),
                        request.getParameter("tipoAtendimento"),
                        request.getParameter("situacao")
                    );
                    AtendimentoFacade.alterar(atendimento);
                    rd = getServletContext().getRequestDispatcher("/AtendimentoServlet?action=list");
                    rd.forward(request, response);
                    break;
                case "formNew":
                    rd = getServletContext().getRequestDispatcher("/jsp/AtendimentoNovo.jsp");
                    rd.forward(request, response);
                    break;
                case "new":
                    atendimento = new Atendimento(
                        Integer.parseInt(request.getParameter("idProduto")),
                        Integer.parseInt(request.getParameter("idCliente")),
                        new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataInicio")),
                        new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataFim")),
                        request.getParameter("reclamacao"),
                        request.getParameter("solucao"),
                        request.getParameter("tipoAtendimento"),
                        request.getParameter("situacao")
                    );
                    AtendimentoFacade.inserir(atendimento);
                    rd = getServletContext().getRequestDispatcher("/AtendimentoServlet?action=list");
                    rd.forward(request, response);
                    break;
            }
        } catch (DAOException | IOException | NumberFormatException | SQLException | ParseException e) {
            request.setAttribute("jspException", e);
            request.setAttribute("status_code", 500);
            request.setAttribute("pageName", "Atendimento");
            request.setAttribute("redirect", "./AtendimentoServlet?action=list");
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
