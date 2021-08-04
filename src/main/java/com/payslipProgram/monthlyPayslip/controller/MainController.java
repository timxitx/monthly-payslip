package com.payslipProgram.monthlyPayslip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payslipProgram.monthlyPayslip.domain.Employee;
import com.payslipProgram.monthlyPayslip.domain.Result;
import com.payslipProgram.monthlyPayslip.service.EmployeeService;

@RestController
public class MainController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public MainController(EmployeeService es) {
		this.employeeService = es;
	}

	@PostMapping("/input")
	public List<Result> input(@RequestBody List<Employee> e) {
		return employeeService.output(e);
	}
	
	
}
