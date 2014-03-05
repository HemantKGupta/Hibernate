package examples.client;

import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import examples.model.Employee;
import examples.model.EmployeeService;

public class EmployeeClient {

    public static void main(String[] args) {
    	
    	
        EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        EmployeeService service = new  EmployeeService(em);
        
        System.out.println("Service started");
        service.createEmployee(2, "Rajni",2000);
        service.createEmployee(3, "ABC", 3000);
        System.out.println("Employees created");
        
        Collection<Employee> emps = service.findAllEmployees();
        service.displayEmployee(emps);
        
        em.close();
        emf.close();
    }
}
