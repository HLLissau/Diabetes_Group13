Feature: Add Patient
	Description: A Patient to a hospital
	Actors: Administrator

Scenario: Add a Patient successfully
# 	Given that the administrator is logged in
 	Given there is a patient called "Hans Erik"
 	And a hospital called "test Hospital 1"
 	And the Patient is not in the hospital list
 	When the patient is added to the hospital
 	Then the patient called "Hans Erik" is added to the hospital
 	
#Scenario: Add a Patient when the administrator is not logged in
#	Given that the administrator is not logged in
# 	And there is a book with title "Extreme Programming", author "Kent Beck", and signature "Beck99"
#	When the book is added to the library
#	Then the error message "Administrator login required" is given
#	
