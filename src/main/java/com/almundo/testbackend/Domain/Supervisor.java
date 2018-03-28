/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.testbackend.Domain;

import com.almundo.testbackend.Service.DispacherService;

/**
 *
 * @author coreit
 */
public class Supervisor extends Employee{
    
    private int priority;
    
     public Supervisor(String name, DispacherService callManager) {
        super(name, callManager);
        this.priority = 1;
    }
     
     
}
