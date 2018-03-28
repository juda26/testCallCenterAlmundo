/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.testbackend.Model;

import com.almundo.testbackend.Domain.Call;
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
public class Dispacher {
    
    List<Employee> employees = new ArrayList();
    
    public void dispatchCall(Call call) {
/* check if any respondant is free */
    Optional<Employee> handler = getCallHandler();
    if (!handler.isPresent()) {
        System.out.println("Sorry, the line is busy, your call is going in wait queue");
        putCallInWaitQueue(call);
        return;
    }
    handler.get().assignCall(call);
    call.setEmployee(handler.get());
}
    
    private Optional<Employee> getCallHandler() {
    
        List<Employee> activeEmployees = employees.stream()
                .filter((employee) -> employee.isFree())
                .sorted(Comparator.comparingInt(Employee::getPriority))
                .collect(Collectors.toList());

        if(!activeEmployees.isEmpty()){
            return Optional.of(activeEmployees.get(0)); // the sorted list, putting the top priority at position 0.
        }
        return Optional.empty(); // returning null is not a good idea
    }

    private void putCallInWaitQueue(Call call) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
