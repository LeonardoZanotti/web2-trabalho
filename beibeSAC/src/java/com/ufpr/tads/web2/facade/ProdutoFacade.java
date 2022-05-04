/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.dao.ProdutoDao;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutoFacade {
    public static ArrayList<Produto> getLista() throws ProdutoException
    {
        try
        {
            ProdutoDao produtoDao = new ProdutoDao();
            ArrayList<Produto> listaProdutos = produtoDao.retornaListaProdutos();
            return listaProdutos;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new ProdutoException("Erro ao retornar lista de produtos", e);
        }
    }
    
    public static Produto adicionaProduto(Produto produto) throws ProdutoException
    {
        try
        {
            ProdutoDao produtoDao = new ProdutoDao();
            Produto produtoNovo = produtoDao.adicionaProduto(produto);
            return produtoNovo;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new ProdutoException("Erro ao adicionar produto", e);
        }
    }
    
    public static Produto retornaProduto(int id) throws ProdutoException
    {
        try
        {
            ProdutoDao produtoDao = new ProdutoDao();
            Produto produto = produtoDao.retornaProdutoPorId(id);
            return produto;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new ProdutoException("Erro ao buscar produtos de id: " + id, e);
        }
    }
    
    public static boolean modificaProduto(Produto produto) throws ProdutoException
    {
        try
        {
            ProdutoDao produtoDao = new ProdutoDao();
            boolean confereModificacao = produtoDao.modificaProduto(produto);
            
            return confereModificacao;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new ProdutoException("Erro ao modificar produto", e);
        }
    }
    
    public static boolean removerProduto(Produto produto) throws ProdutoException
    {
        try
        {
            ProdutoDao produtoDao = new ProdutoDao();
            boolean confereRemocao = produtoDao.removeProduto(produto);
            
            return confereRemocao;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new ProdutoException("Erro ao remover produto", e);
        }
    }
}
