Feature:
@excel
  Scenario: Login with excel
    Given the user on the login page
    When the user enters the home page by using valid credentials "src/test/resources/users.xlsx"
