@TP9
Feature: As a potential client i want to interact with the mobile application

  Background:
    Given The app is loaded correctly

    @LogIn
  Scenario: The user logs in
    When The user logs in the application with email and password
    Then Home page is displayed

@LogHours
  Scenario: The user logs hours
    Given The user is logged in
    When The user taps on + button
    When The user sets the hours to 08:00hs
    When The user taps on save button
    Then a card is displayed with the hours logged

@LogOnProject
  Scenario: The user logs hours on project1
    Given The user is logged in
    When The user taps on + button
    When The user sets the hours to 02:05hs
    When The user choose Project 1
    When The user taps on save button
    Then a card is displayed with the hours logged
    And project1 is displayed