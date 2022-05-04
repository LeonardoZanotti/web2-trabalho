/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;


public class CategoriaProdutoException extends Exception{
    public CategoriaProdutoException() {}
    
    public CategoriaProdutoException(String string)
    {
        super(string);
    }
    
    public CategoriaProdutoException(String string, Throwable thrwbl)
    {
        super(string, thrwbl);
    }
}
