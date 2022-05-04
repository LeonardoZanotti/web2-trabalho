/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.CategoriaProduto;
import com.ufpr.tads.web2.dao.CategoriaProdutoDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;


public class CategoriaProdutoFacade {
    public static ArrayList<CategoriaProduto> getLista() throws CategoriaProdutoException
    {
        try
        {
            CategoriaProdutoDao categoriaProdutoDao = new CategoriaProdutoDao();
            ArrayList<CategoriaProduto> listaCategorias = categoriaProdutoDao.retornaListaCategorias();
            return listaCategorias;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new CategoriaProdutoException("Erro ao retornar lista de categorias", e);
        }
    }
    
    public static CategoriaProduto adicionaCategoria(CategoriaProduto categoriaProduto) throws CategoriaProdutoException
    {
        try
        {
            CategoriaProdutoDao categoriaProdutoDao = new CategoriaProdutoDao();
            CategoriaProduto categoriaProdutoNovo = categoriaProdutoDao.adicionaCategoria(categoriaProduto);
            return categoriaProdutoNovo;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new CategoriaProdutoException("Erro ao adicionar categoria", e);
        }
    }
    
    public static CategoriaProduto retornaCategoria(int id) throws CategoriaProdutoException
    {
        try
        {
            CategoriaProdutoDao categoriaProdutoDao = new CategoriaProdutoDao();
            CategoriaProduto categoriaProduto = categoriaProdutoDao.retornaCategoriaPorId(id);
            return categoriaProduto;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new CategoriaProdutoException("Erro ao buscar categoria de id: " + id, e);
        }
    }
    
    public static boolean modificaCategoria(CategoriaProduto categoriaProduto) throws CategoriaProdutoException
    {
        try
        {
            CategoriaProdutoDao categoriaProdutoDao = new CategoriaProdutoDao();
            boolean confereModificacao = categoriaProdutoDao.modificaCategoria(categoriaProduto);
            
            return confereModificacao;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new CategoriaProdutoException("Erro ao modificar categoria", e);
        }
    }
    
    public static boolean removerCategoria(CategoriaProduto categoriaProduto) throws CategoriaProdutoException
    {
        try
        {
            CategoriaProdutoDao categoriaProdutoDao = new CategoriaProdutoDao();
            boolean confereRemocao = categoriaProdutoDao.removeCategoria(categoriaProduto);
            
            return confereRemocao;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new CategoriaProdutoException("Erro ao remover categoria", e);
        }
    }
}
