Feature: Creating users


  Scenario: Create a user
    Given I have entered date of birth "19/03/1998"
    And I have entered first name "Filip"
    And I have entered last name "Lindqvist"
    And I have entered email "filiptest10@mail.com" and confirmed email "filiptest10@mail.com"
    And I have entered password "Password123" and confirmed password "Password123"
    And I have checked terms and condition
    And I have checked over 18 or person with parental responsibility
    And I have checked code of conduct
    When I press the join button
    Then I am registered and get the text "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND"

  Scenario: Create a user with no lastname
    Given I have entered date of birth "15/08/1988"
    And I have entered first name "Sven"
    And I have entered last name ""
    And I have entered email "sventest3@mail.com" and confirmed email "sventest3@mail.com"
    And I have entered password "Password123" and confirmed password "Password123"
    And I have checked terms and condition
    And I have checked over 18 or person with parental responsibility
    And I have checked code of conduct
    When I press the join button
    Then I am not registered and get the error text "Last Name is required"

  Scenario: Create a user with not matching passwords
    Given I have entered date of birth "23/12/1972"
    And I have entered first name "Benjamin"
    And I have entered last name "Haraldsson"
    And I have entered email "ben.har@mail.com" and confirmed email "ben.har@mail.com"
    And I have entered password "Password123" and confirmed password "Password1234"
    And I have checked terms and condition
    And I have checked over 18 or person with parental responsibility
    And I have checked code of conduct
    When I press the join button
    Then I am not registered and get the error text "Password did not match"

  Scenario: Create a user without checking in terms and condition
    Given I have entered date of birth "01/01/2001"
    And I have entered first name "Jessica"
    And I have entered last name "Adamsson"
    And I have entered email "Jes.ada@mail.com" and confirmed email "Jes.ada@mail.com"
    And I have entered password "Password123" and confirmed password "Password1234"
    And I have not checked terms and condition
    And I have checked over 18 or person with parental responsibility
    And I have checked code of conduct
    When I press the join button
    Then I am not registered and get the error text "You must confirm that you have read and accepted our Terms and Conditions"