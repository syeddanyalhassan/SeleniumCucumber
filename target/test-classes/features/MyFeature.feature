Feature: Heroku App
  As a user
  I want to perform basic add record for agency
  Just after login so that I can validate it.

Scenario: Login on Heroku app with invalid credentials
  Given I open the heroku app
  When  I login with invalid credentials
  Then  I should see an invalid error message

Scenario: Login with valid credentials and add record
    Given I visit the heroku app
    When  I login with valid credentials
    And   I add a record
    Then  Success Message is validated

