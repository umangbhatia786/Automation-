#Author: your.email@your.domain.com
@Test2
Feature: Price of Xperia on list and product page must be same

  Scenario: Verify that price of Xperia on List and Product Page is same
    When Get price of Xperia on List Page
    Then Get price of Xperia on Product Page
    Then Comapre the two prices
