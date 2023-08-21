Feature: Ecom Application

@Homepage
Scenario: Homepage
Given user Launch The Application URL
When user Select The Dropdown "Music"
Then user Search The Product "cd"

#Scenario Outline:
#Scenario: Homepage
#Given user Launch The Application URL "https://www.amazon.in/"
#When user Select The Dropdown "<expected>"
#Then user Search The Product "<searchvalue>"

#Examples:
#|expected|searchvalue|
#|Books|Fossil|
#|Music|cd|

Scenario: Resultspage
When user Extract The FirstProduct Title
And Clicks The Product

Scenario: Productpage
When switch The Browser
And fetch The Selected Product Title

Scenario: AddToCart
Then click AddToCart
And user Takes Screenshot
And user Compares The Title

Scenario:
Then user Close The Page