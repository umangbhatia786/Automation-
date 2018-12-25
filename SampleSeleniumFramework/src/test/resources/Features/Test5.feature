#Author: your.email@your.domain.com
@Test5
Feature: Create Account and Share WishLiist

  Scenario: User is able to create an account and then share his wishlist
    Given click on MyAccount Link
    Then Click Create Account and fill the required details
      | Umang | Bhatia | bhatia788@gmail.com | abcd1234 | abcd1234 |
    Then Click Register
    Then Verify that the registration is done
    Then Goto TV and add LG LCD to your wishlist
    Then Click SHARE WISHLIST
    Then Enter email, message and then click on share wishlist
      | umangbhatia786@gmail.com | Hi do you think I shoud buy this T.V |
    Then Verify that wishlist has been shared
