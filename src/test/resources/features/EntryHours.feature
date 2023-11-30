Feature: Entry Hours

  Background:
    Given The app is loaded correctly

  @LogHours
  Scenario: The user logs hours
    Given The user is logged in
    When The user taps on + button
    When The user taps on star hours
    When The user set start hours to 09:05hs
    When The user set end hours to 11:30hs
    When The user taps on save button
    When The user choose Project 1
    When The user taps on save button
    Then a card is displayed with the hours logged

  @LogHoursSpecificDay
  Scenario: The user logs hours on specific day
    Given The user is logged in
    When The user taps on + button
    When The user taps on today's date
    When The user taps on November 27th
    When The user taps on save button
    When The user sets the hours to 08:00hs
    When The user choose Project 1
    When The user taps on save button
    Then a card is displayed with the hours logged on specific day

  @DiscardEntry
  Scenario: The user enters hours then discard it
    Given The user is logged in
    When The user taps on + button
    When The user sets the hours to 02:00hs
    When The user taps on Go back button
    When The user taps on Discard button
    Then Home page is displayed