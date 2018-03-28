/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coreit
 */


import com.almundo.testbackend.Domain.Call;
import com.almundo.testbackend.Domain.Director;
import com.almundo.testbackend.Domain.Operador;
import com.almundo.testbackend.Domain.Supervisor;
import com.almundo.testbackend.Service.DispacherService;
import org.junit.Test; 
import org.junit.runner.RunWith; 
import org.springframework.boot.test.context.SpringBootTest; 
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) 
@SpringBootTest 
public class CallTest {
    
    DispacherService service;
    
    void CallTest() throws Exception {
        for(int i = 0 ; i < 10 ; i++) {
            service.dispatch(new Call());
        }
    }
    
    private DispacherService FillEmployee(){


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
