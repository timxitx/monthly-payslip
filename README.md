# monthly-payslip

This is a monthly payslip application

It has been published to 18.188.234.249:8080


How to run it:
- Open postman, use POST method to "18.188.234.249:8080/input" and select application.json
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



About Deploy: 
- I used docker to create a docker image for this application and linked the image to aws ECS service for deploying.(https://hub.docker.com/r/timxii/monthlypayslip/tags?page=1&ordering=last_updated)

About Testing: 
- Already included the Junit Test.
