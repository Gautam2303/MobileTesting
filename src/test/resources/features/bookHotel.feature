Feature: Book Hotel
  Scenario Outline: Book hotel without GST-Card(debit card)- Without special request
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
      | Visa        | 5555555555552222 | Gowtham | July  | 2030 | 123 |

    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not

    Examples: 
      | userName | password | state | city | roomType | checkIn | checkOut | NoofRoom | NoofAdults | NoofChilds | SelectSalutation | FirstName | LastName | MobileNo | Email |
      | gowtham6306@gmail.com | Gow@2303| Andhra Pradesh | Tirupati | Standard | 25 October 2025 | 26 October 2025 | 1-One | 1-One | 1 | Mr. | Gowtham | Murugan | 8508054760 | gowtham@gmail.com |