/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;


public class AtendimentoException extends Exception {
    public AtendimentoException() {}
    
    public AtendimentoException(String string)
    {
        super(string);
    }
    
    public AtendimentoException(String string, Throwable thrwbl)
    {
        super(string, thrwbl);
    }
}
