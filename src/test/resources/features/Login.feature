Feature: Login

  Background:
    Given The app is loaded correctly

  @LogIn
  Scenario: The user logs in
    When The user logs in the application with email and password
    Then Home page is displayed

  @LogOut
  Scenario: The user logs out
    When The user logs in the application with email and password
    When The user taps on the three lines menu
    When The user taps on Log Out button
    Then The user logs out