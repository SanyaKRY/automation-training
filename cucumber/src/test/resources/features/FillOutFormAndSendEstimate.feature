@MyTest
Feature: Calculating customer's cloud saving
  Description: Customer calculates cloud saving use the Google Cloud Platform Pricing Calculator 
      and receives an estimate letter in the email    
Background: Customer goes to link
  Given customer is on cloudgooglecom page
  When customer presses on products and pricing dropdown boxes
  And customer chooses calculators link
  Then Google Cloud Platform Pricing Calculator will open  
Scenario Outline: Customer fills out the form and sends the estimate letter in the email
  When "<customer>" fills out the form 
  And customer opens a second window and receives temporary mail  
  And customer switches to the main window  
  And customer fills in a email and sends email  
  And customer switches to the temporary mail window and opens the letter
  Then compares cost from letter and estimate
  Examples:
 |customer|
 |qa|
 |dev|