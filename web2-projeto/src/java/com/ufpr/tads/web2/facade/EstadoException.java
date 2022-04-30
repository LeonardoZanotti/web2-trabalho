/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;


public class EstadoException extends Exception{
    public EstadoException() {}
    
    public EstadoException(String string)
    {
        super(string);
    }
    
    public EstadoException(String string, Throwable thrwbl)
    {
        super(string, thrwbl);
    }
}
