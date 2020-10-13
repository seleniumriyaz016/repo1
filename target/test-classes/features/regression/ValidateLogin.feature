@tag
Feature: To validate login fucntionaliy of Adactinapp

	Background:
	 Given I launch bowser and naviagte to application using url "http://adactinhotelapp.com/"
   	
  @tag1
  Scenario: to validate login
    Then I enter text "reyaz009" in textbox using xpath "//input[@name='username']"
    Then I enter text "reyaz123" in textbox using xpath "//input[@name='password']"
    Then I click on button using xpath for "//input[@name='login']"
    Then I verify the title of the page to be "Adactin.com - Search Hotel"
    Then I close the browser
   
   @tag2
   Scenario Outline: to validate login with different data sets
    Then I enter text "<username>" in textbox using xpath "//input[@name='username']"
    Then I enter text "<password>" in textbox using xpath "//input[@name='password']"
    Then I click on button using xpath for "//input[@name='login']"
    Then I verify the title of the page to be "Adactin.com - Search Hotel"
    Then I close the browser
    
    Examples:
    | username | password |
    | reyaz009 | reyaz123 |
    | reyaz009 | reyaz112 |
    | reyaz089 | reyaz162 |
    
    

