package com.sample.NewAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sample.NewAPI.entity.Address;
import com.sample.NewAPI.entity.Employee;
import com.sample.NewAPI.entity.Users;
import com.sample.NewAPI.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/newapi")
	public String Hello() {
		return "New Project Started now.";
	}
	
	@GetMapping("/employees")
	public List<Employee> getListOfEmployees() {
		return service.getEmployeeList();
		}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {
		return service.getEmployeeById(id);
		}
	
	/*@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return service.saveEmployee(employee);		
	}*/
	
	@PostMapping("/employee")
	public String insert(@RequestBody Employee emp) {
		if (emp == null) {
			return "Failed to insert Student within the database";
		} else {
			String result = service.saveEmployee(emp);
			return result;
		}
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		return service.updateEmployee(emp, id);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable("id") int id) {
		service.deleteEmployeeById(id);
		return "Employee deleted successfully with Id:" + id ;
	}
	
	 /* @PutMapping("/posts/{postId}/comments/{commentId}")
	    public Address updateComment(@PathVariable (value = "postId") Long postId,
	                                 @PathVariable (value = "commentId") Long commentId,
	                                 @Valid @RequestBody Comment commentRequest) {
	        if(!postRepository.existsById(postId)) {
	            throw new Exception("PostId " + postId + " not found");
	        }

	        return commentRepository.findById(commentId).map(comment -> {
	            comment.setText(commentRequest.getText());
	            return commentRepository.save(comment);
	        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
	    }*/
	
	@PostMapping("/register")
	public Users regiserUser(@RequestBody Users user) {
		return service.saveUser(user);
	}

}
