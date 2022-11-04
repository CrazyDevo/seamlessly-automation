Feature: Login With Different Scenarios


  @PositiveLogin @smoke
  Scenario Outline: : Login with valid credentials
    Given the user on the login page
    Given the user is logged in with "<submitType>"
    Then the user should see the url "http://qa.seamlessly.net/index.php/apps/files/"
    And the user should see the username as "Employee61"
    Examples:
      | submitType   |
      | submitButton |
      | enterKey     |


  @NegativeLogin
  Scenario Outline: Login with invalid credentials
    Given the user on the login page
    And the user is logged in "<username>" and "<password>" with "<submitType>"
    Then the user should see the message "Wrong username or password."
    And the user should see the url "http://qa.seamlessly.net/index.php/login?user=<username>"
  @withsubmitbutton
    Examples:with submit button test without empty textboxes
      | username   | password    | submitType   |
      | 1234       | Employee123 | submitButton |
      | 1234       | 1234        | submitButton |
      | Employee61 | 1234        | submitButton |
  @withenterbutton
    Examples:with enter button test without empty textboxes
      | username   | password    | submitType   |
      | 1234       | Employee123 | enterKey     |
      | 1234       | 1234        | enterKey     |
      | Employee61 | 1234        | enterKey     |
  @NegativeLogin
  Scenario Outline: Login with invalid with empty credentials
    Given the user on the login page
    And the user is logged in "<username>" and "<password>" with "<submitType>"
    Then the user should see the message "Please fill out this field."
    And the user should see the url "http://qa.seamlessly.net/index.php/login"
    @withenterbutton
    Examples: with enter button test with empty textboxes
      | username   | password   | submitType   |
      |            | Emploee123 | enterKey     |
      | Employee61 |            | enterKey     |
      |            |            | enterKey     |

    @withsubmitbutton
    Examples: with submit button test with empty textboxes
      | username   | password   | submitType   |
      |            | Emploee123 | submitButton |
      | Employee61 |            | submitButton |
      |            |            | submitButton |


  Scenario: User can see the password form of dots
    Given the user on the login page
    And the user enters the password
    Then the user should see the password form of dots

  Scenario: User can see the password explicitly if needed
    Given the user on the login page
    And the user enters the password
    And the user clicks the toggle button
    Then the user  should see the password explicitly


  Scenario: User can see an option link like 'forgot password' on the login page to be able to reset the password
    Given the user on the login page
    Then the user should see the forgot password link
    When the user clicks the forgot password link
    Then the user should see the "Reset password" button


  Scenario Outline: : User can see valid placeholders on Username and Password fields
    Given the user on the login page
    Then the user should see the "<value>" as placeholder for "<textBoxType>" textbox


    Examples:
      | value             | textBoxType |
      | Password          | password    |
      | Username or email | username    |
