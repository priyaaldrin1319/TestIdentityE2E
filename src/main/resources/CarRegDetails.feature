Feature: Car Registration Details

  Scenario Outline: Car Registration
    Given User launch carreg and read the input file "<fileName>"
    Then User get the car details from the output file "car_output - V6"
    And User verify car details matching

    Examples:
    |fileName|
    |car_input - V6|