package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import payslipProgram.Calculation;

class mainTest {

	@Test
	void testGetGrossIncome() {
		int grossIncome = Calculation.getGrossIncome((double)60050);
		int grossIncome1 = Calculation.getGrossIncome((double)60050.4);
		int grossIncome2 = Calculation.getGrossIncome((double)60049.5);
		assertEquals(5004, grossIncome);
		assertEquals(5004, grossIncome1);
		assertEquals(5004, grossIncome2);
	}
	
	@Test
	void testGetIncomeTax() {
		int incomeTax = Calculation.getIncomeTax((double)10000);
		int incomeTax1 = Calculation.getIncomeTax((double)25000);
		int incomeTax2 = Calculation.getIncomeTax((double)60050);
		int incomeTax3 = Calculation.getIncomeTax((double)120000);
		int incomeTax4 = Calculation.getIncomeTax((double)300000);
		assertEquals(0, incomeTax);
		assertEquals(108, incomeTax1);
		assertEquals(922, incomeTax2);
		assertEquals(2669, incomeTax3);
		assertEquals(9019, incomeTax4);
	}
	
	@Test
	void testGetSuperAmount() {
		int superAmount = Calculation.getSuperAmount(5004, 10);
		int superAmount1 = Calculation.getSuperAmount(6020, 11);
		int superAmount2 = Calculation.getSuperAmount(7119, 9);
		int superAmount3 = Calculation.getSuperAmount(8332, 9.3);
		assertEquals(450, superAmount);
		assertEquals(662, superAmount1);
		assertEquals(641, superAmount2);
		assertEquals(775, superAmount3);
	}

}
