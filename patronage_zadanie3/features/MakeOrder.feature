Feature: Making order
  As a user I want to be able to make order
  So that I can by some products

  Background:
    Given I am on the authentication form page
    When I enter valid email address "test@migmail.pl" and password "test1"
    And I press SignIn button
    Then My account page should be open

    @MakeOrder
    Scenario:
      When I press Home page button
      And I choose product
      And I press AddToCart button
      And I open Shopping Cart
      And I am on  Shopping Cart Summary page
      And I press ProceedToCheckout button
      And I am on Addresses page
      And I press ProceedToCheckout button
      And I am on Shipping page
      And I accept terms of service
      And I press ProceedToCheckout button
      And I am on Payment page
      And I press Pay by check button
      And I confirm my order
      Then I should see confirmation message