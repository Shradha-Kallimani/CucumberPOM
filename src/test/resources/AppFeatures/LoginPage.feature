Feature: Login page fetaure 

Scenario: Login page title 
Given user is on login page 
When user gets the title of the page 
Then page title should be "Login Page | New Look UK"

Scenario: Forgot password link
Given user is on login page 
Then Forgot your password link should be displayed 

Scenario: Login with correct credentials 
Given user is on login page 
When user enters username "shradhakallimani@gmail.com"
And user enters password "Techy12345!"
And user clicks on login button
Then user gets the title of the page
And page title should be "My Account | New Look UK"


