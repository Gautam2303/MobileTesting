package stepDefinitions;

import java.util.List;
import java.util.Map;

import com.qa.BaseClass;
import com.qa.BookHotel;
import com.qa.BookingsPage;
import com.qa.ExploreHotelPage;
import com.qa.LoginPage;
import com.qa.PaymentPage;
import com.qa.SelectHotelPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookHotelWithoutGST extends BaseClass {
//	LoginPage loginPage;
//	ExploreHotelPage exploreHotel = new ExploreHotelPage(driver);
//	SelectHotelPage selectHotelPage= new SelectHotelPage(driver);
//	BookHotel bookHotel = new BookHotel(driver);
//	PaymentPage payment = new PaymentPage(driver);
//	BookingsPage bookingPage = new BookingsPage(driver);
//	
//	
//
//	@Given("User is on the OMR Branch hotel page")
//	public void user_is_on_the_omr_branch_hotel_page() {
//		
//		loginPage = new LoginPage(driver);
//		
//		String pageHeaderName = loginPage.getHomePageHeaderName();
//		System.out.println("Home Page Header:" + pageHeaderName);
//		String nameAndNumber = loginPage.contactNameAndNumber();
//		System.out.println("Contact Number & Name:" + nameAndNumber);
//	}
//
//	@When("User enter {string} and {string} and click login")
//	public void user_enter_and_and_click_login(String userName, String password) {
//		loginPage.enterCredentialsAndClickLogin(userName, password);
//
//	}
//
//	@Then("User should verify success message after login {string}")
//	public void user_should_verify_success_message_after_login(String string) {
////		String welcomeMessageText = loginPage.getWelcomeMessageText();
//		exploreHotel.getExploreHotelPageHeaderName();
//		
//	}
//	
//	@When("User search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
//	public void user_search_hotel_and(String state, String city, String roomType, String checkIn, String checkOut, String NoofRoom, String NoofAdults, String NoofChilds) {
//		exploreHotel.searchHotel(state, city, roomType, checkIn, checkOut, NoofRoom, NoofAdults, NoofChilds);
//	}
//
//	@Then("User should verify after search hotel success message {string}")
//	public void user_should_verify_after_search_hotel_success_message(String string) {
//		String headerName = selectHotelPage.getSelectHotelPageHeaderName();    
//	    System.out.println(headerName);
//	}
//
//	@When("User scrolls down, save the first hotel name and hotel price")
//	public void user_scrolls_down_save_the_first_hotel_name_and_hotel_price() {
//	  scrollDown();
//	  String hotelName = selectHotelPage.getHotelName();
//	  System.out.println(hotelName);
//	  String hotelPrice = selectHotelPage.getHotelPrice();
//	  System.out.println(hotelPrice);
//
//	}
//
//	@When("User select the first hotel and click ok to proceed to next page")
//	public void user_select_the_first_hotel_and_click_ok_to_proceed_to_next_page() {
//		  String popupTxt = selectHotelPage.clickHotelContinueBtn();
//		  System.out.println(popupTxt);
//	}
//
//	@Then("User should verify after select success message {string}")
//	public void user_should_verify_after_select_success_message(String string) {
//		String bookHotelPageHeadername = bookHotel.bookHotelPageHeadername();
//		System.out.println(bookHotelPageHeadername);
//	}
//
//	@When("User scroll down and  add Guest Details {string},{string},{string},{string} and {string}")
//	public void user_scroll_down_and_add_guest_details_and(String SelectSalutation, String FirstName, String LastName, String MobileNo, String Email) {
//		bookHotel.guestDetails(SelectSalutation, FirstName, LastName, MobileNo, Email);
//	}
//
//	@When("User click credit\\/Debit\\/ATM Card and click card type as debit card and enter the payment details")
//	public void user_click_credit_debit_atm_card_and_click_card_type_as_debit_card_and_enter_the_payment_details(io.cucumber.datatable.DataTable dataTable) {
//		List<Map<String, String>> paymentDetails = dataTable.asMaps(String.class, String.class);
//		 Map<String, String> details = paymentDetails.get(0); 
//		 payment.Payment(details.get("SelectCard"), details.get("CardNo"), details.get("CardName"), details.get("Month"), details.get("Year"), details.get("CVV"));
//		 
//	}
//
//	@When("User should verify after hotel booking success message {string} and save the order ID")
//	public void user_should_verify_after_hotel_booking_success_message_and_save_the_order_id(String string) {
//		String getbookingIDHotel = payment.getbookingIDHotel();
//		System.out.println(getbookingIDHotel);
//		String getbookingHotelName = payment.getbookingHotelName();
//		System.out.println(getbookingHotelName);
//		payment.clickBookingBtn();
//	}
//
//	@Then("User should verify same selected Hotel is booked or not")
//	public void user_should_verify_same_selected_hotel_is_booked_or_not() {
//		String hotelID = bookingPage.getHotelID();
//		System.out.println(hotelID);
//		String hotelName = bookingPage.getHotelName();
//		System.out.println(hotelName);
//		String hotelPrice = bookingPage.getHotelPrice();
//		System.out.println(hotelPrice);
//
//	}

}
