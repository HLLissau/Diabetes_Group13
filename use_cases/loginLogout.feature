Feature: login logout management
Scenario: Patient successfully logs in
    Given there is a patient called "Hans Erik" in "hospital 1"
    When the patient login succeeds 
    Then the patient is logged in

Scenario: Patient unsuccesfully logs in
    Given there is a patient called "Hans Erik" in "hospital 1"
    When the patient login fails 
    Then the patient is NOT logged in
    And the error message "Patient Login error" is given

Scenario: admin successfully logs in
	Given that the administrator is not logged in
	And the password is "adminadmin"
	When the administrator login succeeds
	Then the adminstrator is logged in
	

Scenario: admin unsuccessfully logs in
	Given that the administrator is not logged in
	And the password is "wrong password"
	When the administrator login fails
	Then the administrator is not logged in
	Then the error message "Admin login error" is given
