Feature: Login to Pet Store

Scenario: Valid Login
  Given I am on the login page
  When I enter valid username "<username>" and password "<password>"
  #When I enter valid username "ank123" and password "12345"
  And I click the login button
  Then I should be logged in successfully

 #Examples:   
  #|username |password |
#	|ank123   |12345    |
#	|test2    |abc      | 
#		
		
		
		
		
		
		