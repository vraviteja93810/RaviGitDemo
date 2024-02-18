Feature: place the order for products
@PlaceOrder
Scenario Outline: serach experience for product search in both home and offers page.
Given user is on Greenkart landing page.
When user search with shortname <Vegetable> and extract actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <vegetable> items in checkout page
And verify user has ability to enter promo code and place the order
Examples:
|Vegetable|
|Tom  |
