Feature: Project

  @Projectos
  Scenario: As admin user
  I want to create, update and delete an item
  So that i am able to manipulate them

    Given I have access to Todo.ly
    When I send a POST request to the url http://todo.ly/api/items.json with json
    """
    {
      "Content":"New Item",
    }
    """
    Then Wait for the response code to be 200
    And Wait for the response body to be
    """
    {
      "Id": "1033",
      "Content": "New Item",
      "ItemType": "1",
      "Checked": "false",
      "ProjectId": "192",
      "ParentId": "0",
      "Path": {
        "-self-closing": "true"
      },
      "Collapsed": "false",
      "DateString": {
        "-self-closing": "true"
      },
      "DateStringPriority": "0",
      "DueDate": {
        "-self-closing": "true"
      },
      "ItemOrder": "0",
      "Priority": "4",
      "Children": {
        "-self-closing": "true"
    }
  }
    """
    And I get the Id and I save it in ID_PROJECT
    When I send a PUT petition to the url http://todo.ly/api/projects/ID_PROJECT.json with json
    """
    {
      "Content":"EXTERNAL FILE",
      "Icon":"4"
    }
    """
    Then Wait for the response code to be 200
    And Wait for the response body to be
    """
    {
        "Id": ID_PROJECT,
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
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """
    When yo envio una peticion GET al url http://todo.ly/api/projects/ID_PROJECT.json con json
    """
    """
    Then Wait for the response code to be 200
    And Wait for the response body to be
    """
   {
        "Id": ID_PROJECT,
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
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """
    When yo envio una peticion DELETE al url http://todo.ly/api/projects/ID_PROJECT.json con json
    """
    """
    Then Wait for the response code to be 200
    And Wait for the response body to be
    """
    {
        "Id": ID_PROJECT,
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
