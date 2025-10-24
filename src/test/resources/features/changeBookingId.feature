Feature: Change Booking id
Scenario Outline: Verify Change Booking id when user booked hotel without GST-Card(debit card)- Without special request
    Given User is on the OMR Branch hotel page
    When User enter "<userName>" and "<password>" and click login
    Then User should verify success message after login "Welcome Greens"
    When User search hotel "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<NoofRoom>","<NoofAdults>" and "<NoofChilds>"
    Then User should verify after search hotel success message "Select Hotel"
    When User scrolls down, save the first hotel name and hotel price
    And User select the first hotel and click ok to proceed to next page
    Then User should verify after select success message "Book Hotel"
    When User scroll down and  add Guest Details "<SelectSalutation>","<FirstName>","<LastName>","<MobileNo>" and "<Email>"
    When User click credit/Debit/ATM Card and click card type as debit card and enter the payment details
      | SelectCard | CardNo          | CardName | Month | Year | CVV |
      | Visa        | 5555555555552222 | Gowtham | July  | 2035 | 123 |

    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
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
