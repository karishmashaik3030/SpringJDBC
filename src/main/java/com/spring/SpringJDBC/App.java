package com.spring.SpringJDBC;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Dao.EmployeeDao;
import com.spring.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
         EmployeeDao dao=(EmployeeDao)context.getBean("employeedao");
         Scanner sc=new Scanner(System.in);
         while(true) {
        	 System.out.println("*****************MENU OPTIONS OF AN EMPLOYEE");
        	 System.out.println("0.exit");
        	 System.out.println("1.Insert an Employee in DB");
        	 System.out.println("2.Update an Employee in DB");
        	 System.out.println("3.Delete an Employee from DB");
        	 System.out.println("4.Read an Employee on id");
        	 System.out.println("_______All Employees_______");
         	//list of all employees
            List<Employee> employee=dao.allEmployee();
            System.out.println(employee);
        	 int input=sc.nextInt();
        	 if(input==0) {
        		 System.out.println("Exiting from the menu");
        		 break;
        	 }
        	 switch(input) {
        	 case 1:
        		 System.out.println("Enter employee details");
        		 System.out.println("Enter employee id");
        		 int id=sc.nextInt();
        		 sc.nextLine();
        		 System.out.println("Enter employee first name");
        		 String fname=sc.nextLine();
        		 System.out.println("Enter employee last name");
        		 String lname=sc.nextLine();
        		 Employee empl=new Employee();
                 empl.setId(id);
                 empl.setFirstName(fname);
                 empl.setLastName(lname);
                 int result=dao.create(empl);
                 if(result>0) {
                	 System.out.println("inserted sucessfully");
                 }
                 else {
                	 System.out.println("not inserted successfully");
                 }
                 break;
        	 case 2:
        		 System.out.println("Enter an id");
        		 id=sc.nextInt();
        		 Employee emp=dao.read(id);
        		 id=sc.nextInt();
        		 sc.nextLine();
        		 System.out.println("Enter employee first name");
        		 fname=sc.nextLine();
        		 System.out.println("Enter employee last name");
        		 lname=sc.nextLine();
        		 String first=emp.getFirstName();
        		 String last=emp.getLastName();
        		 emp.setId(id);
        		 emp.setFirstName((fname != "") ? fname : first);
        		 emp.setLastName((lname != "") ? lname : last);
        		 result=dao.update(emp);
        		 if(result>0) {
                	 System.out.println("Employee updated succesfully");
                 }
                 else {
                	 System.out.println("Employee is not updated");
                 }
        		 break;
        	 case 3:
        		 System.out.println("Enter an id");
        		 id=sc.nextInt();
        		 result=dao.delete(id);
                 if(result>0) {
                	 System.out.println("Employee deleted succesfully");
                 }
                 else {
                	 System.out.println("Employee is not deleted");
                 }
        		 break;
        	 case 4:
        		 System.out.println("Enter an id");
        		 id=sc.nextInt();
        		 emp=dao.read(id);
        		 System.out.println(emp);
        		 break;
        	 default:{
        		 System.out.println("Enter an valid option");
        	 }
        	 }
        	 
         }
         
         
         
         
         
//         Employee empl=new Employee();
//         empl.setId(9000);
//         empl.setFirstName("karishma");
//         empl.setLastName("shaik");
//         int result=dao.create(empl);
//         if(result>0) {
//        	 System.out.println("inserted sucessfully");
//         }
//         else {
//        	 System.out.println("not inserted successfully");
//         }
//         
//         System.out.println(dao.read(9000));
//         //list of all employees
//         List<Employee> employee=dao.allEmployee();
//         System.out.println("All employees are shown"+employee);
//         Employee emp=dao.read(9000);
//         emp.setId(9988);
//         result=dao.update(emp);
//         System.out.println("updated result"+result);
//         
//         result=dao.delete(9988);
//         System.out.println("deleted results"+result);
         
    }
}
