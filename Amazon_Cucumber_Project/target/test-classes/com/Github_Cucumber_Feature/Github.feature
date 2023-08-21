Feature: Cloud Application

Feature: Ecom Application

@Homepage
Scenario: Homepage
Given user Launch The Application URL 
When user Opting To SignIn
And user Provides LoginID & Password
Then user Clicks The Login Icon

@Resultspage
Scenario: Resultspage
When user Extract The List Of Repositories
And user Gets The Name Of Repositories

@Creationpage
Scenario: Creationpage
When user Creates New The New Repository
And user Fetch The Name Of created Repository

@Screenshot
Scenario: Screenshot
Then user Takes The Screenshot

@Comparisonpage
Scenario: Comparisonpage
Then user Comparing New Repository

@DeletionPage
Scenario: DeletionPage
Then user Deleting The Created Repository
And user Signing Out
