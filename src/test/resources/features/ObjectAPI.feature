Feature: Object Validations

  Background: Objects API is available
    Given object api is available

  Scenario Outline: Add Object
    When user adds the object in the list "<name>" <year> <price> "<model>" "<disk>"
    Then object gets added and status code displayed as 200
    And object id gets created
    And response should display createdAt time

    Examples:
    | name | year | price | model | disk |
    | Apple MacBook Pro 16 | 2019 | 1849.99 | Intel Core i9 | 1 TB |

  @WithoutAddObject
  Scenario: Get Object
    When user check the object added in the list
    Then added object should be displayed with status code as 200
    And id should match when user added the object

  @WithoutAddObject
  Scenario Outline: Update Object
    When user update the object details "<name>" <year> <price> "<model>" "<disk>" "<color>"
    Then object gets updated with status code as 200
    And response should display updatedAt time

    Examples:
      | name | year | price | model | disk | color |
      | Apple MacBook Pro 16 | 2019 | 2049.99 | Intel Core i9 | 1 TB | silver |

  @WithoutAddObject
  Scenario: Delete Object
    When user delete the existing object
    Then object gets deleted with status code as 200
    And response message should contain deleted content