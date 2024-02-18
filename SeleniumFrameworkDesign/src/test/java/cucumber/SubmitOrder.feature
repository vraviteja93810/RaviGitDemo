@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background:
Given I landed on Ecommerce page

  @tag2
  Scenario Outline: positive test of submitting the order
    Given logged in with username <username> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation.

    Examples: 
      | username              | password        |productName|
      | raviteja@gmail.com    | Vraviteja@12345 |ZARA COAT 3|
