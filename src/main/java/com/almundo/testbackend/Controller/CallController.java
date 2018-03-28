/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.testbackend.Controller;

import com.almundo.testbackend.Domain.Call;
import com.almundo.testbackend.Domain.Caller;
import com.almundo.testbackend.Domain.Director;
import com.almundo.testbackend.Domain.Operador;
import com.almundo.testbackend.Domain.Supervisor;
import com.almundo.testbackend.Service.DispacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author coreit
 */
@RestController
@RequestMapping(value = { "/CallCenter" }, produces = { "application/json" })
public class CallController {
    
    @Autowired
    DispacherService service;
    
    
    public void CallInvoke(){
        
        
    
    service = FillEmployee();
    
    Caller foo = new Caller("foo");
    
        try{
          
        service.dispatch(new Call()); // Asignado a O1
        service.dispatch(new Call()); // Asignado a O2
        service.dispatch(new Call()); // Asignado a O3
        service.dispatch(new Call()); // Asignado a M1
        service.dispatch(new Call()); // Asignado a M2
        service.dispatch(new Call()); // Asignado a D1
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    
    
    
    private DispacherService FillEmployee(){

        //DispacherService manager = new ();

        service.addEmployee(new Operador("O1", service));
        service.addEmployee(new Operador("O2", service));
        service.addEmployee(new Operador("O3", service));

        service.addEmployee(new Supervisor("S1", service));
        service.addEmployee(new Supervisor("S2", service));
        service.addEmployee(new Supervisor("S3", service));

        service.addEmployee(new Director("D1", service));
        service.addEmployee(new Director("D2", service));

        return service;

}

}


