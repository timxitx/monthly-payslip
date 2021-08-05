package com.payslipProgram.monthlyPayslip.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payslipProgram.monthlyPayslip.domain.Employee;
import com.payslipProgram.monthlyPayslip.domain.PaySlip;

@Service
public class EmployeeService {

	public List<PaySlip> output(List<Employee> employees) {
		List<PaySlip> payslips = new ArrayList<PaySlip>();
		for(Employee e: employees) {
			PaySlip payslip = new PaySlip();
			payslip.setEmployee(e);
			payslip.setGrossIncome(e.getAnnualSalary());
			payslip.setIncomeTax(e.getAnnualSalary());
			payslip.setNetIncome();
			payslip.setSuperannuation(e.getSuperRate());
			payslip.setFromDate(e.getPaymentMonth());
			payslip.setToDate(e.getPaymentMonth());
			payslips.add(payslip);
		}
	
		return payslips;
	}
}
