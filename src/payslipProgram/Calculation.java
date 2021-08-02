package payslipProgram;

public class Calculation {
	
	static double taxRate1 = 0.19;
	static double taxRate2 = 0.325;
	static double taxRate3 = 0.37;
	static double taxRate4 = 0.45;
	static int taxBase = 0;
	
	public static int getGrossIncome(Double salary) {
		return (int) Math.round(salary/12);
	}
	
	public static int getIncomeTax(Double salary) {
		if(salary >= 180001) {
			taxBase = 3572 + 16250 + 34410;
			return (int) Math.round((taxBase+(salary-180001)*taxRate4)/12);
		} else if (salary>=87001 && salary<180000) {
			taxBase = 3572 + 16250;
			return (int) Math.round((taxBase+(salary-87001)*taxRate3)/12);
		} else if (salary>=37001 && salary<87000) {
			taxBase = 3572;
			return (int) Math.round((taxBase+(salary-37001)*taxRate2)/12);
		} else if (salary>=18201 && salary<37000 ) {
			return (int) Math.round((salary-18201)*taxRate1/12);
		} else {
			return 0;
		}
	}
	
	public static int getNetIncome(int grossIncome, int incomeTax) {
		return grossIncome - incomeTax;
	}
	
	public static int getSuperAmount(int grossIncome, double superRate) {
		return (int) Math.round(grossIncome * superRate / 100);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
