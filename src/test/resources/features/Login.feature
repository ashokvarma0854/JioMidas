Feature: Login Feature
Scenario: Valid login
Given the user is on the login page
When the user enters "valid_user" and "valid_pass"
Then the user should be logged in successfully