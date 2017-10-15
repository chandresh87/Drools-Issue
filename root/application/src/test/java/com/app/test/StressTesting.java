/** */
package com.app.test;

import org.drools.domain.Employee;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/** @author chandresh.mishra */
public class StressTesting extends BaseTest {

 
  @Autowired private KieContainer kieContainer;

  @Test
  public void testReturnSpecificFact_whichIsPresent() {
  
   KieSession session= kieContainer.newKieSession();
   session.insert(populateData());
  
    int rulesFired= session.fireAllRules();
    
    Assert.assertEquals(rulesFired, 3);
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
