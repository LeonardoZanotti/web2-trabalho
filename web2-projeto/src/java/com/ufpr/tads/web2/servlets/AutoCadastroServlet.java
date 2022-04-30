/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.Endereco;
import com.ufpr.tads.web2.beans.Estado;
import com.ufpr.tads.web2.facade.CidadeException;
import com.ufpr.tads.web2.facade.CidadeFacade;
import com.ufpr.tads.web2.facade.ClienteException;
import com.ufpr.tads.web2.facade.ClienteFacade;
import com.ufpr.tads.web2.facade.EstadoException;
import com.ufpr.tads.web2.facade.EstadoFacade;
import com.ufpr.tads.web2.facade.Ferramentas;
import com.ufpr.tads.web2.facade.FerramentasException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "AutoCadastroServlet", urlPatterns = {"/AutoCadastroServlet"})
public class AutoCadastroServlet extends HttpServlet {

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

            ServletContext sc = request.getServletContext();
            request.setCharacterEncoding("UTF-8");

            try
            {
                Endereco endereco = new Endereco();

                Estado estado = EstadoFacade.retornaEstado(Integer.parseInt(request.getParameter("idEstado")));
                Cidade cidade = CidadeFacade.retornaCidade(Integer.parseInt(request.getParameter("idCidade")));
                cidade.setEstado(estado);
                endereco.setCidade(cidade);
                endereco.setRua(request.getParameter("rua"));
                endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
                endereco.setBairro(request.getParameter("bairro"));
                endereco.setCep(Integer.parseInt(request.getParameter("cep")));
                endereco.setComplemento(request.getParameter("complemento"));

                Cliente cliente = new Cliente();
                cliente.setEndereco(endereco);

                cliente.setPrimeiroNome(request.getParameter("primeiroNome"));
                cliente.setSobreNome(request.getParameter("sobreNome"));
                cliente.setTelefone(request.getParameter("telefone"));
                cliente.setSenha(request.getParameter("senha"));
                cliente.setCpf(Long.parseLong(request.getParameter("cpf")));

                boolean confereEmail = Ferramentas.confereEmail(request.getParameter("email"));
                if (confereEmail)
                {
                    request.setAttribute("msg", "Email ja cadastrado na base de dados");
                    RequestDispatcher rd = request.getRequestDispatcher("/cliente/autoCadastro.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    cliente.setEmail(request.getParameter("email"));
                    Cliente novoCliente = ClienteFacade.adicionaCliente(cliente);

                    if (novoCliente != null)
                    {
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
                    }
                    else
                    {
                        request.setAttribute("msg", "Erro ao adicionar novo cliente");
                        RequestDispatcher rd = sc.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
            }
            catch(ClienteException | NumberFormatException | EstadoException | CidadeException | FerramentasException e)
            {
                request.setAttribute("msg", "ERRO: " + e.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
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
