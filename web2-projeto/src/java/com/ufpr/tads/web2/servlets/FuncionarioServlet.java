/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.Funcionario;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.beans.Situacao;
import com.ufpr.tads.web2.facade.AtendimentoException;
import com.ufpr.tads.web2.facade.AtendimentoFacade;
import com.ufpr.tads.web2.facade.FuncionarioException;
import com.ufpr.tads.web2.facade.FuncionarioFacade;
import com.ufpr.tads.web2.facade.SituacaoException;
import com.ufpr.tads.web2.facade.SituacaoFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

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
                if (action == null || action.equals("portal"))
                {
                    try
                    {
                        Funcionario funcionario = FuncionarioFacade.retornaFuncionario(logado.getId());
                        Situacao emAberto = SituacaoFacade.retornaSituacao(1);
                        List<Atendimento> listaAtendimentosAbertos = AtendimentoFacade.getListaPorSituacao(emAberto);
                        if (listaAtendimentosAbertos.size() > 0)
                        {
                            Collections.sort(listaAtendimentosAbertos, (Atendimento a1, Atendimento a2) -> a1.getDataHoraInicio().compareTo(a2.getDataHoraInicio()));
                            request.setAttribute("listaAtendimentosAbertos", listaAtendimentosAbertos);
                        }
                        request.setAttribute("funcionario", funcionario);

                        RequestDispatcher rd = sc.getRequestDispatcher("/funcionario/portalFuncionario.jsp");
                        rd.forward(request, response);
                    }
                    catch(FuncionarioException | SituacaoException | AtendimentoException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (action.equals("todosAtendimentos"))
                {
                    try
                    {
                        Funcionario funcionario = FuncionarioFacade.retornaFuncionario(logado.getId());
                        List<Atendimento> listaAtendimentos = AtendimentoFacade.getLista();
                        if (listaAtendimentos.size() > 0)
                        {
                            Collections.sort(listaAtendimentos, (Atendimento a1, Atendimento a2) -> a1.getDataHoraInicio().compareTo(a2.getDataHoraInicio()));
                            request.setAttribute("listaAtendimentos", listaAtendimentos);
                        }
                        request.setAttribute("funcionario", funcionario);

                        RequestDispatcher rd = sc.getRequestDispatcher("/funcionario/todosAtendimentos.jsp");
                        rd.forward(request, response);
                    }
                    catch(FuncionarioException | AtendimentoException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (action.equals("formResolverAtendimento"))
                {
                    try
                    {
                        String sId = request.getParameter("idAtendimento");
                        int idAtendimento = Integer.parseInt(sId);
                        Atendimento atendimento = AtendimentoFacade.retornaAtendimento(idAtendimento);

                        RequestDispatcher rd = sc.getRequestDispatcher("/funcionario/resolucaoAtendimento.jsp");
                        request.setAttribute("atendimento", atendimento);
                        rd.forward(request, response);
                    }
                    catch(AtendimentoException | NumberFormatException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
                else if (action.equals("resolverAtendimento"))
                {
                    try
                    {
                        Atendimento atendimento = AtendimentoFacade.retornaAtendimento(Integer.parseInt(request.getParameter("idAtendimento")));
                        Funcionario funcionario = FuncionarioFacade.retornaFuncionario(logado.getId());

                        atendimento.setFuncionario(funcionario);
                        atendimento.setSolucao(request.getParameter("solucao"));
                        atendimento.setDataHoraFim(Calendar.getInstance());

                        boolean modificou = AtendimentoFacade.modificaAtendimento(atendimento);
                        if(modificou)
                        {
                            response.sendRedirect(request.getContextPath() + "/FuncionarioServlet?action=portal");
                        }
                        else
                        {
                            request.setAttribute("msg", "Erro ao modificar atendimento de id: " + atendimento.getIdAtendimento());
                            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        }
                    }
                    catch(AtendimentoException | NumberFormatException | FuncionarioException e)
                    {
                        request.setAttribute("msg", "ERRO: " + e.getMessage());
                        RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
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
