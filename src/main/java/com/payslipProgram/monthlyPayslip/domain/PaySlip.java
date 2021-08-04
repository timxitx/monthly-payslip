package com.payslipProgram.monthlyPayslip.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PaySlip {
	
	private Integer grossIncome;
	private Integer incomeTax;
	private Integer netIncome;
	private Integer superannuation;
	private String fromDate;
	private String toDate;
	
	double taxRate1 = 0.19;
	double taxRate2 = 0.325;
	double taxRate3 = 0.37;
	double taxRate4 = 0.45;
	double taxBase = 0;
	
	int taxThreshold1 = 18200;
	int taxThreshold2 = 37000;
	int taxThreshold3 = 87000;
	int taxThreshold4 = 180000;

	public Integer getGrossIncome() {
		return grossIncome;
	}

	public void setGrossIncome(double salary) {
		this.grossIncome = (int) Math.round(salary/12);
	}

	public Integer getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(double salary) {
		if(salary >= taxThreshold4 + 1) {
			taxBase = ((taxThreshold2 - taxThreshold1 - 1)*taxRate1) + ((taxThreshold3 - taxThreshold2 - 1)*taxRate2) + ((taxThreshold4 - taxThreshold3 - 1)*taxRate3);
			this.incomeTax = (int) Math.round((taxBase+(salary - taxThreshold4 - 1)*taxRate4)/12);
		} else if (salary >= taxThreshold3 + 1 && salary < taxThreshold4) {
			taxBase = ((taxThreshold2 - taxThreshold1 - 1)*taxRate1) + ((taxThreshold3 - taxThreshold2 - 1)*taxRate2);
			this.incomeTax = (int) Math.round((taxBase+(salary - taxThreshold3 - 1)*taxRate3)/12);
		} else if (salary >= taxThreshold2 + 1 && salary < taxThreshold3) {
			taxBase = (taxThreshold2 - taxThreshold1 - 1)*taxRate1;
			this.incomeTax = (int) Math.round((taxBase+(salary - taxThreshold2 - 1)*taxRate2)/12);
		} else if (salary >= taxThreshold1 + 1 && salary < taxThreshold2 ) {
			this.incomeTax = (int) Math.round((salary- taxThreshold1 - 1)*taxRate1/12);
		} else {
			this.incomeTax = 0;
		}
	}

	public Integer getNetIncome() {
		return netIncome;
	}

	public void setNetIncome() {
		this.netIncome = this.grossIncome - this.incomeTax;
	}

	public Integer getSuperannuation() {
		return superannuation;
	}

	public void setSuperannuation(double superRate) {
		this.superannuation = (int) Math.round(this.grossIncome * superRate);
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(int paymentMonth) {
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.MONTH, paymentMonth);
	    int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
	    cal.set(Calendar.DAY_OF_MONTH, firstDay);
	    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
	    String firstDayOfMonth = sdf.format(cal.getTime());
		this.fromDate = firstDayOfMonth;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(int paymentMonth) {
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.MONTH, paymentMonth);
	    int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    cal.set(Calendar.DAY_OF_MONTH, lastDay);
	    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
	    String lastDayOfMonth = sdf.format(cal.getTime());
		this.toDate = lastDayOfMonth;
	}
	
	

}
