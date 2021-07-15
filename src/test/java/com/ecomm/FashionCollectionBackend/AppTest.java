package com.ecomm.FashionCollectionBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest 
    
{
	public static void main(String arg[]) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		//Employee employee=(Employee)context.getBean("empBean");
		
		//System.out.println("Employee Id:"+employee.getEmployeeId());
		//System.out.println("Employee Name:"+employee.getEmployeeName());
	
	}
}
