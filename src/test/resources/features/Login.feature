Feature: Login Feature

  Scenario: Login Success
    Given I open login page
    When I enter email "denise.estrada@testpro.io"
    And I enter password "te$t$tudent"
    And I click submit
    Then I am logged in