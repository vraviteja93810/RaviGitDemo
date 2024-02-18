Feature: Validating place API's.

@Addplace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI.
Given Add place payload with "<name>" "<address>" "<language>"
When user calls "AddPlaceAPI" with "POST" http request
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
|name   |address        | language|
|Prasad |2-100, Sadum   | Telugu	|

@Deleteplace
Scenario: verify if delete place functionality is working

Given DeletePlace payload
When user calls "deletePlaceAPI" with "POST" http request
Then the API call is success with status code 200
And "status" in response body is "OK"

