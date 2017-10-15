/** */
package com.rules.application.service;

import com.drools.service.EmployeeService;
import com.drools.service.EmployeeServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.drools.domain.Employee;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/** @author chandresh.mishra */
@Service
public class RulesService {

  @Autowired private KieContainer kieContainer;

  public int fireAppRules() {
  
   KieSession session= kieContainer.newKieSession();
   session.insert(populateData());
   
    return session.fireAllRules();
  }

  private Employee populateData() {

    Employee employee = new Employee();
    employee.setEmpID(1);
    employee.setEmpName("John");
    employee.setRating(1);
    employee.setSalary(50000);

    
    return employee;
  }
}
