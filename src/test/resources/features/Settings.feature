Feature: Settings

  Background:
    Given The app is loaded correctly

  @DarkMode @TPFinal
  Scenario: The user enables dark mode
    When The user logs in the application with email and password
    When The user taps on the three lines menu
    When The user taps on settings button
    When The user enable dark mode
    Then Dark mode is enabled

