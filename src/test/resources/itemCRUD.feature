Feature: Items

  @Items
  Scenario: As admin user
  I want to create, update and delete an item
  So that i am able to manipulate the items

    Given I have access to Todo.ly
    When I send a POST request to http://todo.ly/api/items.json with json
    """
    {
      "Content":"New Item"
    }
    """
    Then I wait for the response code to be 200
    And I wait for the response body to be
    """
    {
        "Id": 10843004,
        "Content": "New Item",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "/Date(1614836020883)/",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "/Date(1614834203077)/",
        "LastCheckedDate": null,
        "LastUpdatedDate": "/Date(1614835299043)/",
        "Deleted": true,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": 676959
    }
    """

    And I have the Id and I save it in ID_ITEM
    When I send a PUT request to http://todo.ly/api/items/10843003.json with json
    """
    {
      "Checked":true
    }
    """
    Then I wait for the response code to be 200
    And I wait for the response body to be
    """
    {
        "Id": 10843003,
        "Content": "New Item",
        "ItemType": 1,
        "Checked": true,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "/Date(1614834506784)/",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "/Date(1614834193077)/",
        "LastCheckedDate": "/Date(1614834506753)/",
        "LastUpdatedDate": "/Date(1614834506753)/",
        "Deleted": false,
        "Notes": "",
        "InHistory": true,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": 676959
    }
    """
    When I send a GET request to http://todo.ly/api/items/10843003.json with json
    """
    """
    Then I wait for the response code to be 200
    And I wait for the response body to be
    """
    {
    "Id": 10843003,
    "Content": "New Item",
    "ItemType": 1,
    "Checked": true,
    "ProjectId": null,
    "ParentId": null,
    "Path": "",
    "Collapsed": false,
    "DateString": null,
    "DateStringPriority": 0,
    "DueDate": "",
    "Recurrence": null,
    "ItemOrder": null,
    "Priority": 4,
    "LastSyncedDateTime": "/Date(1614834649458)/",
    "Children": [],
    "DueDateTime": null,
    "CreatedDate": "/Date(1614834193077)/",
    "LastCheckedDate": "/Date(1614834506753)/",
    "LastUpdatedDate": "/Date(1614834506753)/",
    "Deleted": false,
    "Notes": "",
    "InHistory": true,
    "SyncClientCreationId": null,
    "DueTimeSpecified": true,
    "OwnerId": 676959
    }
    """
    When I send a DELETE request to http://todo.ly/api/items/10843004.json with json

    """
    """
    Then I wait for the response code to be 200
    And I wait for the response body to be
    """
    {
        "Id": 10843004,
        "Content": "EXTERNAL FILE",
        "ItemsCount": 0,
        "Icon": 4,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "IGNORE",
        "Children": [

        ],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "IGNORE",
        "LastUpdatedDate": "IGNORE",
        "Deleted": true,
        "SyncClientCreationId": null
    }
    """