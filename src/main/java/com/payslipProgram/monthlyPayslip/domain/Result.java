package com.payslipProgram.monthlyPayslip.domain;

public class Result {

	private Employee emoployee;
	private PaySlip payslip;
	
	public Result(Employee emoployee, PaySlip payslip) {
		super();
		this.emoployee = emoployee;
		this.payslip = payslip;
	}
	
	public Employee getEmoployee() {
		return emoployee;
	}
	public void setEmoployee(Employee emoployee) {
		this.emoployee = emoployee;
	}
	public PaySlip getPayslip() {
		return payslip;
	}
	public void setPayslip(PaySlip payslip) {
		this.payslip = payslip;
	}
	
	
}
