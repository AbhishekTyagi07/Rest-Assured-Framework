Feature: Verify CoinDesk API functionality

  Scenario: Fetch current Bitcoin price successfully
    Given the CoinDesk API is available
    When I fetch the current Bitcoin price
    Then the API should return status code 200
    And the response should include a valid time updated field
    And the response should include valid chart name
    And verify USD details
    And verify GBP details
    And verify EUR details