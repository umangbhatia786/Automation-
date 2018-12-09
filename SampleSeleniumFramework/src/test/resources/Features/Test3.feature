#Author: your.email@your.domain.com

@Test3
Feature: User is not able to add more than available quantity

  Scenario: Verify user is not able to buy than the available quantity.
		When Click on ADD TO CART for Xperia
		Then Update quantity to '1000'
		Then Verify the error message displayed
		Then Click on Empty Cart link
		Then Verify the message displayed
