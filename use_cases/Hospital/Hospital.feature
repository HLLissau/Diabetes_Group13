Feature: Hospital
    Desciption: Features for managing the hospital structure
    Actors: Administrator
    
Scenario: Add a hospital to the database when logged in as admin
    Given that the administrator is logged in
    And a hospital called "hospital 1" exists
    When the hospital is added to the database
    Then the hospital with name "hospital 1" is in the database
    
Scenario: trying to add a hospital when NOT logged in as admin
    Given that the administrator is not logged in
    And a hospital called "hospital 1" exists
    When the hospital is added to the database
    Then the hospital with name "hospital 1" is NOT in the database
    Then the error message "Not logged in as admin. Cannot add hospital." is given


Scenario: Remove a hospital from the database when logged in as admin
    Given that the administrator is logged in
    And a hospital called "hospital 1" exists in the database
    When the hospital is removed to the database
    Then the hospital with name "hospital 1" is NOT in the database

Scenario: Remove a hospital from the database when NOT logged in as admin
    Given that the administrator is logged in
    And a hospital called "hospital 1" exists in the database
    When the hospital is removed to the database
    Then the hospital with name "hospital 1" is in the database
    And the error message "Not logged in as admin. Cannot remove hospital." is given

Scenario: Trying to remove a hospital, that still have patients
    Given that the administrator is logged in
    And there is a patient called "Hans Erik" in "hospital 1"
    When the hospital is removed to the database
    Then the hospital with name "hospital 1" is NOT in the database
    And the error message "Hospital still have patients. Cannot remove hospital." is given


Scenario: Change the name of a hospital when logged in as admin
    Given that the administrator is logged in
    And a hospital called "hospital 1" exists in the database
    When the hospital name is changed to "hospital newname"
    Then the hospital name is changed to "hospital newname" %check on id of the hospital


Scenario: Trying to change the name of a hospital when NOT logged in as admin
    Given that the administrator is NOT logged in
    And a hospital called "hospital 1" exists in the database
    When the hospital name is changed to "hospital newname"
    Then the hospital name is NOT changed to "hospital newname" %check on id of the hospital
    And the error message "Not logged in as admin. Cannot change the name of the hospital." is given
