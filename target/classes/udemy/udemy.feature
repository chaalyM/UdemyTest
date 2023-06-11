@udemy 
  Feature: Search Courses on Udemy
		@search_course
  	Scenario: Search for Python course
    	Given I am on the Udemy homepage
    	When Je clique sur se connecter
    	And Je saisie  l'Email "mohamed.chaaly@gmail.com"
    	And Je saisie le MDP "test+udemy123"
    	And Je clique sur s'identifier
    	And I search for the course "/udemy/src/test/resources/configs/testdata.json"
    	Then I should see relevant courses for "Python" in the search results
    @Enroll_course	
    Scenario: Enroll in a course
    	Given I am on the Udemy homepage
    	When I search for the course "Java"
    	And I select a course at random from the search results
    	And I click on the Enroll Now button
    	Then I should see the enrollment success message