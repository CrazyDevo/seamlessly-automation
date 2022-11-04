@SEAMLES-460
Feature: User Folder view functionality

  Background:the user is logged in

    Given the user is logged in
  @SEAMLES-473
  Scenario: User can change the folder view



    When the user clicks on toggle view
    Then the order of the folders should change by view
  @SEAMLES-458
  Scenario:

    When the user clicks on size
    Then the order of the folders should change by size


  @SEAMLES-457
  Scenario:

    And the user clicks on name
    Then the view of folders should change by name


  @SEAMLES-459
  Scenario:

    When the user clicks on modified
    Then the order of the folders should change by date


