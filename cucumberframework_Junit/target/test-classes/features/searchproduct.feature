Feature: search and place the order for products
@Offerspage
Scenario Outline: serach experience for product search in both home and offers page.
Given user is on Greenkart landing page.
When user search with shortname <Vegetable> and extract actual name of product
Then user search for <Vegetable> shortname in offers page
And validate productname in offerspage with homepage productname

Examples:
|Vegetable|
|Tom  |
|Beet |