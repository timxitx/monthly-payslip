# monthly-payslip

This is a monthly payslip application


How to run it:
- Open Eclipse, select "MonthlyPayslipApplication.java" and click run
- Open postman, use POST method to "http://localhost:8080/input" and select application.json
- it will return the response when it is given the input like the following
- [
  {
  	"firstName":"David",
    "lastName":"Rudd",
    "annualSalary":60050,
	"superRate":0.09,
	"paymentMonth":1
  },
  {
    "firstName":"Ryan",
    "lastName":"Chen",
    "annualSalary":120000,
    "superRate":0.1,
    "paymentMonth":2
  }
]
