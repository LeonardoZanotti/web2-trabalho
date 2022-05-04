/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ufpr.tads.web2.dao.DAOException;
import com.ufpr.tads.web2.dao.relConnectionFactory;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@WebServlet(name = "GeradorRelatorioServlet", urlPatterns = { "/GeradorRelatorioServlet" })
public class GeradorRelatorioServlet extends HttpServlet {

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

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        try (relConnectionFactory factory = new relConnectionFactory()) {
            String host = "http://" + request.getServerName() + ":" + request.getServerPort();

            if (action.equals("relatorioFuncionarios")) {
                String relatorioFuncionarios = request.getContextPath() + "/relListaFuncionarios.jasper";
                URL relatorioFuncionariosURL = new URL(host + relatorioFuncionarios);
                HashMap params = new HashMap();
                byte[] bytes = JasperRunManager.runReportToPdf(relatorioFuncionariosURL.openStream(), params,
                        factory.getConnection());
                if (bytes != null) {
                    response.setContentType("application/pdf");
                    OutputStream ops = response.getOutputStream();
                    ops.write(bytes);
                }
            } else if (action.equals("relatorioMaisReclamados")) {
                String relatorioMaisReclamados = request.getContextPath() + "/relProdutosMaisReclamados.jasper";
                URL relatorioMaisReclamadosURL = new URL(host + relatorioMaisReclamados);
                HashMap params = new HashMap();
                byte[] bytes = JasperRunManager.runReportToPdf(relatorioMaisReclamadosURL.openStream(), params,
                        factory.getConnection());
                if (bytes != null) {
                    response.setContentType("application/pdf");
                    OutputStream ops = response.getOutputStream();
                    ops.write(bytes);
                }
            } else if (action.equals("relatorioAtendimentosAbertos")) {
                String relatorioAtendimentosAbertos = request.getContextPath() + "/relAtendimentosPorData.jasper";
                URL relatorioAtendimentosAbertosURL = new URL(host + relatorioAtendimentosAbertos);
                HashMap params = new HashMap();
                byte[] bytes = JasperRunManager.runReportToPdf(relatorioAtendimentosAbertosURL.openStream(), params,
                        factory.getConnection());
                if (bytes != null) {
                    response.setContentType("application/pdf");
                    OutputStream ops = response.getOutputStream();
                    ops.write(bytes);
                }
            } else if (action.equals("relatorioReclamacoes")) {
                String relatorioReclamacoes = request.getContextPath() + "/relReclamacoes.jasper";
                URL relatorioReclamacoesURL = new URL(host + relatorioReclamacoes);
                HashMap params = new HashMap();
                byte[] bytes = JasperRunManager.runReportToPdf(relatorioReclamacoesURL.openStream(), params,
                        factory.getConnection());
                if (bytes != null) {
                    response.setContentType("application/pdf");
                    OutputStream ops = response.getOutputStream();
                    ops.write(bytes);
                }
            }
        } catch (DAOException e) {
            request.setAttribute("msg", "Erro de DAO: " + e.getMessage());
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        } catch (JRException e) {
            request.setAttribute("msg", "Erro no Jasper: " + e.getMessage());
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
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
