package payslipProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	static class Employee {
		String firstName;
		String lastName;
		Double salary;
		Double superRate;
		LocalDate startDate;

		Employee (String firstname, String lastname, String salary, String superrate, String startdate) {
			this.firstName = firstname;
			this.lastName = lastname;
			this.salary = Double.parseDouble(salary);
			this.superRate = Double.parseDouble(superrate);
			DateTimeFormatter df = DateTimeFormatter.ofPattern( "dd/MM/uuuu" ) ;
			this.startDate = LocalDate.parse( startdate , df ) ;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inputFile = "src/payslip-input.csv";
		String outputFile = "src/payslip-output.csv";
		String line = "";
		String splitBy = ",";
		
		int grossIncome = 0;
		int incomeTax = 0;
		int netIncome = 0;
		int superAmount = 0;
		double taxRate1 = 0.19;
		double taxRate2 = 0.325;
		double taxRate3 = 0.37;
		double taxRate4 = 0.45;
		int taxBase = 0;
		
		
		List<Employee> allEmployee = new ArrayList<Employee>();

		try
		{
			//read input file
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			Boolean firstLine = true;
			while ((line = br.readLine()) != null)
			{
				if(firstLine) {
					firstLine = false;
					continue;
				}
				String[] temp = line.split(splitBy);    // use comma as separator
				Employee employee = new Employee(temp[0], temp[1], temp[2], temp[3], temp[4]);
				allEmployee.add(employee);
			}
			br.close();
			//output
			FileWriter fw = new FileWriter(outputFile);
			BufferedWriter bw = new BufferedWriter(fw);
			String[] headings = {"Name", "Pay Period", "Gross Income", "Income Tax", "Net Income", "Super"};
			for(int i=0; i<headings.length; i++) {
				bw.write(headings[i]);
				if(i!=headings.length-1) {
					bw.write(",");
				}
			}
			bw.newLine();
			for(Employee e: allEmployee) {		
				//calculation
				grossIncome = (int) Math.round(e.salary/12);
				if(e.salary >= 180001) {
					taxBase = 3572 + 16250 + 34410;
					incomeTax = (int) Math.round((taxBase+(e.salary-180001)*taxRate4)/12);
				} else if (e.salary>=87001 && e.salary<180000) {
					taxBase = 3572 + 16250;
					incomeTax = (int) Math.round((taxBase+(e.salary-87001)*taxRate3)/12);
				} else if (e.salary>=37001 && e.salary<87000) {
					taxBase = 3572;
					incomeTax = (int) Math.round((taxBase+(e.salary-37001)*taxRate2)/12);
				} else if (e.salary>=18201 && e.salary<37000 ) {
					incomeTax = (int) Math.round((e.salary-18201)*taxRate1/12);
				} else {
					incomeTax = 0;
				}
				netIncome = grossIncome - incomeTax;
				superAmount = (int) Math.round(grossIncome * e.superRate / 100);
				
				bw.write(e.firstName + " " + e.lastName);
				bw.write(",");
				bw.write(e.startDate.getMonth().toString());
				bw.write(",");
				bw.write(Integer.toString(grossIncome));
				bw.write(",");
				bw.write(Integer.toString(incomeTax));
				bw.write(",");
				bw.write(Integer.toString(netIncome));
				bw.write(",");
				bw.write(Integer.toString(superAmount));
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
