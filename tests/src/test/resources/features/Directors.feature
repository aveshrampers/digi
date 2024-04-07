@api
Feature: Verify directors and producers of the movies

  Background: The base url
    Given the url

  Scenario:Get the 3rd movie and check if the director of the movie is ‘Richard Marquand’
    Then assert the 3rd movie is directed by Richard Marquand

  Scenario: Get the 5th movie and assert that ’Producers’ are not ‘Gary Kurtz, George Lucas'
    Then assert the 5th movie is not producers Gary Kurts, George Lucase