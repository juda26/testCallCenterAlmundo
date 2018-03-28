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
public class Employee {
    
    
    
    
    protected int priority;
    
  private String name;
  private Call currentCall;
  private DispacherService Service;

    public int getPriority() {
        return priority;
    }
  
  Employee(String name, DispacherService callManager) {
    this.name = name;
    this.Service = callManager; // esta es la dependencia requerida por lo tanto debe estar allí en el constructor
  }

  public boolean isFree() {
    return this.currentCall == null;
  }

  private void escalateCall() {
    if (!isFree()) {
      currentCall.incrementRank();
      Service.putCallInWaitQueue(currentCall);
    }
  }

  public void assignCall(Call call) {
    System.out.println(name + " Llamada recibida!");
    currentCall = call;
  }
    
}
