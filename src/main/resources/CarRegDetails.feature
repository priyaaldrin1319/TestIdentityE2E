Feature: Car Registration Details

  Scenario: Car Registration
    Given User launch carregno in "carchecking"
    Then User get the car details
    And User verify car details matching