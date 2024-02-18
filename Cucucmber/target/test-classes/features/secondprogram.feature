
Feature: Application Login

Background:
Given setup the entries in database
And launch the browser from config variables
And hit the home page url of banking site.

#Reusable
@Regression @MobileTest @NetBanking
Scenario: user page deault login

Given user is on NetBanking landing page
When user login into application with "user" and password "Nuser123"
Then Home page is displayed
And cards are displayed.

@Smoke @Regression @Mortgage
Scenario Outline: Mortgage user page deault login

Given user is on NetBanking landing page
When user login into application with <username> and password <password> combination
Then Home page is displayed
And cards are displayed.

Examples:
|username    |password|
|Debituser   |Duser12|
|Credituser  |Cruser12|
|Hackuser    |Hackusre12|


