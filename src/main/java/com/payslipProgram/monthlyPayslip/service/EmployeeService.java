package com.payslipProgram.monthlyPayslip.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payslipProgram.monthlyPayslip.domain.Employee;
import com.payslipProgram.monthlyPayslip.domain.PaySlip;
import com.payslipProgram.monthlyPayslip.domain.Result;

@Service
public class EmployeeService {
	
	List<Result> results = new ArrayList<Result>();

	public List<Result> output(List<Employee> employees) {
		for(Employee e: employees) {
			PaySlip payslip = new PaySlip();
			payslip.setGrossIncome(e.getAnnualSalary());
			payslip.setIncomeTax(e.getAnnualSalary());
			payslip.setNetIncome();
			payslip.setSuperannuation(e.getSuperRate());
			payslip.setFromDate(e.getPaymentMonth());
			payslip.setToDate(e.getPaymentMonth());
			Result r = new Result(e, payslip);
			results.add(r);
		}
	
		return results;
	}
}
