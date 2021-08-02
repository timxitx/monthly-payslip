package payslipProgram;

public class Employee {
	
	
	String firstName;
	String lastName;
	Double salary;
	Double superRate;
	String startDate;

	public Employee (String firstname, String lastname, String salary, String superrate, String startdate) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.salary = Double.parseDouble(salary);
		this.superRate = Double.parseDouble(superrate);
		this.startDate = startdate ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
