package com.chika.microservices.hrservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chika.microservices.admissionservice.models.Employee;
import com.chika.microservices.admissionservice.models.EmployeesList;

@RestController
@RequestMapping("/hr")
public class HrResource {
	
	List<Employee> employees =Arrays.asList(
			new Employee("E1", "Chika", "Star", "MedicalTech"),
			new Employee("E2", "LiLa", "Anselm", "Surgery"),
			new Employee("E3", "James", "Trump", "Dentistry")
			);
	
    @RequestMapping("/employees")
//	public List<Employee> getEmployees(){ //we used this before we tried to call across services
//    to test our codes
    
    public EmployeesList getEmployees(){
    	EmployeesList employeesList = new EmployeesList();
    	employeesList.setEmployees(employees);
		return employeesList;
	}
    
    @RequestMapping("/employees/{Id}")
    public Employee getEmployeeById(@PathVariable("Id") String Id) {
    	Employee e = employees.stream()
					.filter(employee -> Id.equals(employee.getId()))
					.findAny()
					.orElse(null);
		return e;
					    }
}
