#Feature: To validate the rahul shetty endpoints with the given request
 
 
#Scenario: To validate the post request
#Given Enter the baseuri and postrequest
#When Validate the response
#Then Log the results

#Scenario: To validate the get request
#Given Post request should be called
#When Enter the baseuri and get request
#Then Validate the response
#And Log the results

#Scenario: To validate the put request
#Given Call the post request
#When Enter the baseuri and put request
#Then Validate response
#And Log results

#Scenarios: To validate the delete request
#Given Call the post request
#When Enter the baseuri and delete request
#Then Validate the response
#And Log results

Feature: To validate the rahul sheety endpoints with the given request


Scenario: To validate the post request
Given Enter the baseuri and postrequest
When validate the response
Then log the results

Scenario: to validate the get request
Given Post request should be called 
When Enter the baseuri and get request
Then Validate the response
And log the results


Scenario: to validate the put request
Given Call the post request 
When Enter the baseuri and put request
Then Validate  response
And log  results

Scenario: to validate the put request
Given Call  post request 
When Enter the baseuri and delete request
Then Validate  response
And log  the result


 
