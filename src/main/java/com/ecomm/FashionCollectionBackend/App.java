package com.ecomm.FashionCollectionBackend;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class App 
{
     @Bean(name="empBean")
     public Employee getEmpBean()
     {
    	 Employee emp=new Employee();
    	 emp.setEmployeeId(1001);
    	 emp.setEmployeeName("Gireesh");
    	 
    	 return emp; 
     }
}
