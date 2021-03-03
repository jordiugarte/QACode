Feature: Project

  @Items
  Scenario: As a common user
            I want to create, update and delete an item
            so that i am able to manipulate the it

    Given I have access to Todo.ly
    When I send a POST request to the url https://todo.ly/api/items.json with json
    """
    {
      "Content":"New Item"
    }
    """
    Then Wait for the response code to be 200
    And Wait for the item name to be "New Item"
