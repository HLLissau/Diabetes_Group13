Feature: Managing Patients 
	Description: A Patient to a hospital
	Actors: Administrator

Scenario: Add a Patient successfully
# 	Given that the administrator is logged in
 	Given there is a patient called "Hans Erik"
 	And a hospital called "hospital 1"
 	And the Patient is not in the hospital list
 	When the patient is added to the hospital
 	Then the patient called "Hans Erik" is added to the hospital
 	
 	
Scenario: Change a patient's name
    Given there is a patient called "Hans Erik" in "hospital 1"
    And the patient is logged in
    And a hospital called "hospital 1"
    When the patient changes their name to "Poul"
    Then the patients name is "Poul"

Scenario: Remove Patient successfully as Patient
    Given there is a patient called "Hans Erik" in "hospital 1"
    And the patient is logged in
    When the patient is attempted to be removed
    Then the patient is removed
    
Scenario: Remove Patient successfully as administrator
    Given that the administrator is logged in
    And there is a patient called "Hans Erik" in "hospital 1"
    When the patient is attempted to be  removed 
    Then the patient is removed
    
Scenario: Remove Patient when no administrator
    Given that the administrator is logged in
    And there is a patient called "Hans Erik" in "hospital 1"
    When the patient is attempted to be  removed 
    Then the patient is removed
    Then the error message "Insufficient permission to remove patient" is given
   

Scenario: Change a patient to a different hospital as administrator
    Given that the administrator is logged in
    And there is a patient called "Hans Erik" in "hospital 1"
    When the patient is attempted to be moved to a second hospital called "Hospital 2"
    Then the patient is removed from hospital

Scenario: Change a patient to a different hospital when no administrator
    Given there is a patient called "Hans Erik" in "hospital 1"
    When the patient is attempted to be moved to a second hospital called "Hospital 2"
    Then the patient is NOT removed from hospital
    Then the error message "Insufficient permission to move patient to another hospital" is given
