@api
Feature: Get the list of movies.

  Background: The base url
    Given the url

  Scenario: Get the list of movies and check if the movies count is 6
    Then assert response count is 6