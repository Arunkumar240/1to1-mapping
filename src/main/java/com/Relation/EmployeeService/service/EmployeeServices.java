package com.Relation.EmployeeService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Relation.EmployeeService.entity.Address;
import com.Relation.EmployeeService.entity.Employee;
import com.Relation.EmployeeService.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServices {
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);

	}

	public Optional<Employee> getEmployee(int id) {
		return employeeRepository.findById(id);
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return "deleted sucessfully";
	}


public Employee addEmployee(int id, Employee employee) {
		employee.setId(id);
		Optional<Employee> empOpt = employeeRepository.findById(id);

		if (!empOpt.isPresent()) {
			throw new EntityNotFoundException("Employee with id" + id + "not found");
		}
		Employee existingEmployee = empOpt.get();

		if (employee.getName() == null) {
			employee.setName(existingEmployee.getName());

			if (employee.getAddress() == null) {
				employee.setAddress(existingEmployee.getAddress());
			} else {
				Address newAddress = employee.getAddress();
				newAddress.setId(existingEmployee.getAddress().getId());
				employee.setAddress(newAddress);
			}
		}
		return employeeRepository.save(employee);
	}

}
