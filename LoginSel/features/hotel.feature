@HotelLogin
Feature: HotelBooking

Background: user wants to login so is navigated to the login page

Scenario: check the title of the page
Given user is on the login page
Then check the title of the page

Scenario: Failure in login because username is empty
Given user is on login page
When user leaves username blank
Then display error message showing empty username

Scenario: Failure in login because password is empty
Given user is on login page 
When user leaves password blank
Then display error message showing empty password

Scenario: Successfully entered correct login credentials
Given user is on login page
When user enters correct login credentials
Then display success page

Scenario: Failure in login on entring wrong username or password
Given user is on login page
When user enter wrong login credentials
Then display error message showing wrong credentials