
@tag
Feature: Error validation
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When logged in with username <username> and password <password> 
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username              | password        |
      | raviteja@gmail.com    | Vraviteja@12    |
