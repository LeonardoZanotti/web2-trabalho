/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;


public class TipoAtendimentoException extends Exception {
    public TipoAtendimentoException() {}
    
    public TipoAtendimentoException(String string)
    {
        super(string);
    }
    
    public TipoAtendimentoException(String string, Throwable thrwbl)
    {
        super(string, thrwbl);
    }
}
