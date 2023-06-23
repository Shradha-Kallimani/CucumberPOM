Feature: Account Page feature

Background:
Given user has already logged in to the application
|username|password|
|shradhakallimani@gmail.com|Techy12345!| 

Scenario: Accounts page title 
Given user is on Accounts page 
When user gets the title of the page 
Then page title should be "My Account | New Look UK"

Scenario: Accounts section count 
Given user is on Accounts page 
Then user gets Accounts section
|MY ORDERS|
|MY ADDRESSES|
|MY PAYMENT CARDS|
|PERSONAL DETAILS|
|SAVED COLLECTION POINTS|
|MY SAVED ITEMS|
|DELIVERY PASS|
|MY CONTACT PREFERENCES|
And count section count should be 8

