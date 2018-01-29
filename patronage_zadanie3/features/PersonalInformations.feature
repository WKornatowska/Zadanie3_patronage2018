Feature: Access to My Personal Information view
  As a user I want to have access to My Personal Informations view
  So that I can verify my account details


  Background:
    Given I am on the authentication form page
    When I enter valid email address "test@migmail.pl" and password "test1"
    And I press SignIn button
    Then My account page should be open

  @MyPersonalInformations
  Scenario: User's personal data in "My personal information" page is correct
   When I click MyPersonalInformation button
   Then I should see Your Personal Information form
   And First name filed should be filled with name "Ann"
   And Last name filed should be filled with name "Johnson"
   And E-mail address should be filled with email "test@migmail.pl"