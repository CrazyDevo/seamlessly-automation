@SEAMLES_496
Feature: Search Functionalities Dashboard Photos

  Background:
      Given the user is logged in

@SEAMLES_440 @smoke

    Scenario:User can search file typing its name through the magnifying glass icon and
             see the details side page of the file when clicked on it.

      When User can click the magnifying glass icon
      And  User can write "Readme" into the text box
      And  User can click on the file name
      Then User can see the details side page of the "Readme"
@SEAMLES_474
  Scenario:User can search contacts by clicking on the contacts icon and typing its name

    When User can click contacts icon
    And  User can write "Ali" into the contact text box
    Then User can see the contact name related to keyword "Ali"
  @SEAMLES_490 @wip
  Scenario:User can see only the images files with the extension of .jpeg/.jpg under the Photos module
           when uploaded them

    When User can click photos icon
    And  User should be on the "http://qa.seamlessly.net/index.php/apps/photos/"
    Then User can see only the images files with the extension of "jpeg" or "jpg"
@SEAMLES_491
  Scenario:User can navigate to files page as home page whenever clicking the seamlessly icon on Dashboard

    When User can click photos icon
    And User can click seamlessly icon on dashboard
    Then User should be on the files page as home page "http://qa.seamlessly.net/index.php/apps/files/?dir=/&fileid"



