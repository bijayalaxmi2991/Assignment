Feature: Restful booker CRUD operations

#Scenario: Create Auth token
#	* def body = 
#	***
#	{
    #"username" : "admin",
    #"password" : "password123"
#	}
#	***
#
#Given url baseUrl
#And path 'auth'
#When method POST
#Then status 200
#* print response


#Scenario: GET BookingIDs
#Given url baseUrl
#And path 'booking'
#When method GET
#Then status 200
#* print response


Scenario: GET Booking for an ID
Given url baseUrl
And path 'booking/753'
When method GET
Then status 200
* print response
* def jsonResponse = response
* def actFirstName = jsonResponse.firstname
* defc actLastName = jsonResponse.lastname
* match actFirstName == 'Jane'
* match actFirstName == 'Doe'



