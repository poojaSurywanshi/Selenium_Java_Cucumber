Feature: Login

  @smoke
  @skip
   Scenario Outline: Verify login with Empty field
    Given the user is on the login page
    When user enters username "<username>" and password "<password>"
    And click on the next button
    Then a validation message should be shown
    
     Examples:
      | username                          | password   |
      |                                   |            | 
      
    @smoke
   Scenario: Verify login with Multiple users
    Given the user is on the login page1
    When user enters username "<usernme>" and password1 "<pasword>"
    And click on next button
    Then Enter password "<pasword>" and click on login
    Examples: 
      | usernme                          | pasword   |
      | poojashivaji                     | wrongpass  | 
      | poojasuryawanshi92@gmail.com     | gogo@162  | 
    