Feature: Read data from CGM
Scenario: Data is successfully read from CGM
    Given there is a patient called "Hans Erik" in "hospital 1"
    And the patient is logged in
    And the patient has registered a CGM sensor
    When 10 minutes has passed
    And the data has been received
    Given the data has the correct format
    And the data has no missing values
    Then the data is accepted

Scenario: Data read from CGM is not formatted as specified by the standard
    Given there is a patient called "Hans Erik" in "hospital 1"
    And the patient is logged in
    And the patient has registered a CGM sensor
    When 10 minutes has passed
    And the data has been received
    Given the data does not have the correct format
    Then the data is not accepted
    And the error message "CGM data is not delivered in correct format" is given
    

Scenario: Data read from CGM is formatted as specified by the standard, but is missing values
    Given there is a patient called "Hans Erik" in "hospital 1"
    And the patient is logged in
    And the patient has registered a CGM sensor
    When 10 minutes has passed
    And the data has been received
    Given the data has the correct format
    And the data has missing values
    Then the data is not accepted
    And the error message "CGM data is missing values" is given

Scenario: Accepted data is successfully saved in Database
    Given there is a patient called "Hans Erik" in "hospital 1"
    And the patient is logged in
    And the patient has registered a CGM sensor
    When 10 minutes has passed
    Given the data has been received
    And the data is accepted
    When the data is saved in the database
    And the data exists in the database
    Then the data is successfully saved
    
Scenario: Rejected data is attempted saved in database
    Given there is a patient called "Hans Erik" in "hospital 1"
    And the patient is logged in
    And the patient has registered a CGM sensor
    When 10 minutes has passed
    Given the data has been received
    And the data is not accepted
    When the data is saved in the database
    And the error message "Rejected CGM data cannot be saved in the database" is given

Scenario: Accepted data is attempted saved in Database, but is not saved
    Given there is a patient called "Hans Erik" in "hospital 1"
    And the patient is logged in
    And the patient has registered a CGM sensor
    When 10 minutes has passed
    Given the data has been received
    And the data is accepted
    When the data is saved in the database
    And the data does not exist in the database
    Then the data is not saved
    And the error message "CGM data failed saving in Database" is given
