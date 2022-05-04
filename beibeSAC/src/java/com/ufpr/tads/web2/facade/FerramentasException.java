/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;


public class FerramentasException extends Exception {
    public FerramentasException() {}
    
    public FerramentasException(String string)
    {
        super(string);
    }
    
    public FerramentasException(String string, Throwable thrwbl)
    {
        super(string, thrwbl);
    }    
}
