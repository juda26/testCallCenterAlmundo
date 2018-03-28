
package com.almundo.testbackend.Service;

import com.almundo.testbackend.Domain.Call;
import com.almundo.testbackend.Domain.Employee;

/**
 *
 * @author coreit
 */
public interface DispacherService {
    
     public void dispatch(Call call);
     
     public void putCallInWaitQueue(Call call);
     
     public void addEmployee(Employee emp);
    
}
