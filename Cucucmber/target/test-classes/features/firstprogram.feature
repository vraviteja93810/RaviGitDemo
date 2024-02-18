
Feature: Application Login

Background:
Given setup the entries in database
And launch the browser from config variables
And hit the home page url of banking site.

@Regression
Scenario: Admin page deault login
Given user is on NetBanking landing page
When user login into application with "admin" and password "Aduser123"
Then Home page is displayed
And cards are displayed.

#Reusable
@Smoke
Scenario: user page deault login
Given user is on NetBanking landing page
When user login into application with "user" and password "Nuser123"
Then Home page is displayed
And cards are displayed.

@Smoke @Regression
Scenario Outline: user page deault login
Given user is on NetBanking landing page
When user login into application with <username> and password <password> combination
Then Home page is displayed
And cards are displayed.

Examples:
|username    |password|
|Debituser   |Duser12|
|Credituser  |Cruser12|
|Hackuser    |Hackusre12|

@MobileTest
Scenario: user page default Sign up
Given user is on  practise landing page
When user signup into application
|Teja|
|v|
|teja@gmail.com|
|93810514879|
|student|
|male|
|teja@12345|
|teja@12345|
Then Home page is displayed
And cards are displayed.



