/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.testbackend.Service;

import com.almundo.testbackend.Domain.Call;
import com.almundo.testbackend.Domain.Caller;
import com.almundo.testbackend.Domain.Employee;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author coreit
 */
public class DispacherServiceImpl implements DispacherService{
    
  List<Employee> employees;
  List<List<Employee>> employeeLevels;
  List<List<Call>> waitQueue;

  public DispacherServiceImpl() {
    this.employeeLevels = new ArrayList<>();
    this.employeeLevels.add(new ArrayList<>());
    this.employeeLevels.add(new ArrayList<>());
    this.employeeLevels.add(new ArrayList<>());
    this.waitQueue = new ArrayList<List<Call>>();
  }

  private Employee getCallHandler(Call call) {
    /* check all operador */
    for (Employee operador: employeeLevels.get(0)) {
      if (operador.isFree()) return operador;
    }

    /* check all managers */
    for (Employee supervisor: employeeLevels.get(1)) {
      if (supervisor.isFree()) return supervisor;
    }

    /* check all directors */
    for (Employee director: employeeLevels.get(2)) {
      if (director.isFree()) return director;
    }
    
    
     List<Employee> activeEmployees = employees.stream()
                .filter((employee) -> employee.isFree())
                .sorted(Comparator.comparingInt(Employee::getPriority))
                .collect(Collectors.toList());

        if(!activeEmployees.isEmpty()){
            //return Optional.of(activeEmployees.get(0)); 
        }
    
   
    return null; //
  }

  public void addOperador(Employee emp) {
    employeeLevels.get(0).add(emp);
  }

  public void addSupervisor(Employee emp) {
    employeeLevels.get(1).add(emp);
  }

  public void addDirector(Employee emp) {
    employeeLevels.get(2).add(emp);
  }

 

  public void dispatch(Call call) {
    /* check if any respondant is free */
    Employee handler = getCallHandler(call);
    if (handler == null) {
      System.out.println("Lo siento, la línea está ocupada, su llamada está en cola de espera");
      putCallInWaitQueue(call);
      return;
    }
    handler.assignCall(call);
    call.setEmployee(handler);
  }

  public void putCallInWaitQueue(Call call) {
    waitQueue.get(call.getRank()).add(call);
  }
    
  public void addEmployee(Employee emp) {
    employees.add(emp);
}
}
