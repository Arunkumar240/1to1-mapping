package com.Relation.EmployeeService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Relation.EmployeeService.entity.Employee;
import com.Relation.EmployeeService.service.EmployeeServices;

@RequestMapping("/api")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeServices employeeServices;

	@PostMapping("/add")
	private Employee addEmployee(@RequestBody Employee employee) {
		employeeServices.addEmployee(employee);
		return employee;
	}

	@GetMapping("/get/{id}")
	private Optional<Employee> getEmployee(@RequestParam int id) {
		return employeeServices.getEmployee(id);
	}

	@GetMapping("/getAll")
	private List<Employee> getAllEmployee() {
		return employeeServices.getAllEmployee();
	}

	@DeleteMapping("/delete")
	private String deleteEmployee(@RequestParam int id) {
		return employeeServices.deleteEmployee(id);
	}

	@PutMapping("/update/{id}")
	private Employee addEmployee(@PathVariable int id,@RequestBody Employee employee) {
		return employeeServices.addEmployee(id, employee);
	}
}
