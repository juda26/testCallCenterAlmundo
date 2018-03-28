/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.testbackend.Domain;

/**
 *
 * @author coreit
 */
public final class Call {
    
  private int rank;
  private Caller caller;
  private Employee employee;

  public Call() {
    this.rank = 0;
  }

  public Call(Caller caller) {
    super();
    this.caller = caller;
  }

   

  public int getRank() {
    return rank;
  }

  public void incrementRank() {
    this.rank += 1;
  }

  public void setCaller(Caller caller) {
    this.caller = caller;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
    
}
