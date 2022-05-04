/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;


public class ClienteException extends Exception {
    public ClienteException() {}
    
    public ClienteException(String string)
    {
        super(string);
    }
    
    public ClienteException(String string, Throwable thrwbl)
    {
        super(string, thrwbl);
    }
}
