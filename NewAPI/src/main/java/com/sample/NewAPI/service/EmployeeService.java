package com.sample.NewAPI.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.sample.NewAPI.entity.Address;
import com.sample.NewAPI.entity.Employee;
import com.sample.NewAPI.entity.Users;
import com.sample.NewAPI.repository.*;


@Service
public class EmployeeService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRepository userRepository;
	
	/*@Transactional
	public Employee saveEmployee(Employee employee) {		
		
		return employeeRepository.save(employee);
	}*/
	
	@Transactional
	public String saveEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		if(emp.getId()==15) {
			int a = 1/0;
			System.out.println("The Value of A is:" + a);
		}
		if(emp!=null) {
			return "The Student is successfully inserted within the database.";
		}
		return "Failed to insert Student within the database";
		
	}
	
	@Transactional
	public List<Employee> getEmployeeList(){
		return employeeRepository.findAll();
		
	}
	
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	
	@Transactional
	public Employee updateEmployee(Employee emp, int id) {			
		Employee existingEmp = employeeRepository.findById(id).orElseThrow();
		existingEmp.setEmpname(emp.getEmpname());
		existingEmp.setEmail(emp.getEmail());
		
		existingEmp.setAddress(emp.getAddress());
		employeeRepository.save(existingEmp);
		
		return existingEmp;					
	}
	
	public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "Record deleted successfully";
	}	
	
	public Users saveUser(Users user) {
		user.setUsername(user.getUsername());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(user.getRole());
		
		return userRepository.save(user);
		
	}

}
