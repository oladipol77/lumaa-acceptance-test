
@AccountManagement
Feature: Account Management


  @CreateAccount
  Scenario Outline: Create account with valid email
    Given user is on create an account page
    When user enters "<FirstName>" "<LastName>" "<Email>" "<Password>" "<ConfirmPassword>"
    And user clicks on create account button
    Then my account page should be displayed


    Examples:
   |FirstName|LastName|Email|Password|ConfirmPassword|
   |Tom      |Adams   |Tomad41@gmail.com|Tom1234567|Tom1234567|

   @DuplicateCustomer
  Scenario Outline: Create account with valid email
    Given user is on create an account page
    When user enters "<FirstName>" "<LastName>" "<Email>" "<Password>" "<ConfirmPassword>"
    And user clicks on create account button
    Then an error message should be displayed


    Examples:
      |FirstName|LastName|Email|Password|ConfirmPassword|
      |Tom      |Adams   |Tomad41@gmail.com|Tom1234567|Tom1234567|


     @SignIn
    Scenario Outline:Sign in with valid email
       Given user is on Sign in page
       When user enters "<Email>" "<Password>"
       And user clicks on sign in link button
       Then my account page is displayed



       Examples:
       |Email|Password|
       |Tomad41@gmail.com|Tom1234567|