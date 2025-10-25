 Feature: Navigate to Change Booking page
Scenario Outline: Verify Page
 
 	Given User quit native app
    And User is on the OMR Branch hotel web application
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Greens"
    When User go to my account page
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    Then User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<ModifyDate>" and Check-out Date "<ChangeCheckoutDate>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | userName | password | state | city | roomType | checkIn | checkOut | NoofRoom | NoofAdults | NoofChilds | SelectSalutation | FirstName | LastName | MobileNo | Email | ModifyDate |ChangeCheckoutDate|
      | gowtham6306@gmail.com | Gow@2303 | Kerala | Kochi | Deluxe | 25 October 2025 | 26 October 2025 | 4-Four | 4-Four | 1 | Mr. | Gowtham | Murugan | 8508054760 | gowtham@gmail.com | 28 | 29|
