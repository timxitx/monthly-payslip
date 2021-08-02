package payslipProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IO {
	
	String line = "";
	String splitBy = ",";
	int grossIncome = 0;
	int incomeTax = 0;
	int netIncome = 0;
	int superAmount = 0;
	
	List<Employee> allEmployee = new ArrayList<Employee>();
	
	public void FileReader(String inputFile) {
		try
		{
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
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean FileWriter(String outputFile) {
		try {
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
				grossIncome = Calculation.getGrossIncome(e.salary);
				incomeTax = Calculation.getIncomeTax(e.salary);
				netIncome = Calculation.getNetIncome(grossIncome, incomeTax);
				superAmount = Calculation.getSuperAmount(grossIncome, e.superRate);
				
				bw.write(e.firstName + " " + e.lastName);
				bw.write(",");
				bw.write(e.startDate);
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
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
