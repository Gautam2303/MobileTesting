package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.qa.BaseClass;
import com.qa.BookHotel;
import com.qa.BookingsPage;
import com.qa.BookingsPageInWebView;
import com.qa.EditBookingPageInWebView;
import com.qa.ExploreHotelPage;
import com.qa.HomePageInWebView;
import com.qa.LoginPage;
import com.qa.LoginPageInWebView;
import com.qa.PaymentPage;
import com.qa.SelectHotelPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangeBookingHotelDate extends BaseClass{
	LoginPage loginPage;
	ExploreHotelPage exploreHotel = new ExploreHotelPage(driver);
	SelectHotelPage selectHotelPage= new SelectHotelPage(driver);
	BookHotel bookHotel = new BookHotel(driver);
	PaymentPage payment = new PaymentPage(driver);
	BookingsPage bookingPage = new BookingsPage(driver);
	LoginPageInWebView loginWebPage;
	HomePageInWebView homePageWeb;
	BookingsPageInWebView bookingpageWeb;
	EditBookingPageInWebView editBookingPageWeb;
	
	//get Booking Hotel Id
	String bookingIdWithOutSpecialChar = "";
	String bookingId ="";
	String hotelName = "";

	@Given("User is on the OMR Branch hotel page")
	public void user_is_on_the_omr_branch_hotel_page() {
		
		loginPage = new LoginPage(driver);
		
		String pageHeaderName = loginPage.getHomePageHeaderName();
		System.out.println("Home Page Header:" + pageHeaderName);
		String nameAndNumber = loginPage.contactNameAndNumber();
		System.out.println("Contact Number & Name:" + nameAndNumber);
	}

	@When("User enter {string} and {string} and click login")
	public void user_enter_and_and_click_login(String userName, String password) {
		loginPage.enterCredentialsAndClickLogin(userName, password);

	}

	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String string) {
//		String welcomeMessageText = loginPage.getWelcomeMessageText();
		exploreHotel.getExploreHotelPageHeaderName();
		
	}
	
	@When("User search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_search_hotel_and(String state, String city, String roomType, String checkIn, String checkOut, String NoofRoom, String NoofAdults, String NoofChilds) {
		exploreHotel.searchHotel(state, city, roomType, checkIn, checkOut, NoofRoom, NoofAdults, NoofChilds);
	}

	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String string) {
		String headerName = selectHotelPage.getSelectHotelPageHeaderName();    
	    System.out.println(headerName);
	}

	@When("User scrolls down, save the first hotel name and hotel price")
	public void user_scrolls_down_save_the_first_hotel_name_and_hotel_price() {
	  scrollDown();
	  String hotelName = selectHotelPage.getHotelName();
	  System.out.println(hotelName);
	  String hotelPrice = selectHotelPage.getHotelPrice();
	  System.out.println(hotelPrice);

	}

	@When("User select the first hotel and click ok to proceed to next page")
	public void user_select_the_first_hotel_and_click_ok_to_proceed_to_next_page() {
		  String popupTxt = selectHotelPage.clickHotelContinueBtn();
		  System.out.println(popupTxt);
	}

	@Then("User should verify after select success message {string}")
	public void user_should_verify_after_select_success_message(String string) {
		String bookHotelPageHeadername = bookHotel.bookHotelPageHeadername();
		System.out.println(bookHotelPageHeadername);
	}

	@When("User scroll down and  add Guest Details {string},{string},{string},{string} and {string}")
	public void user_scroll_down_and_add_guest_details_and(String SelectSalutation, String FirstName, String LastName, String MobileNo, String Email) {
		bookHotel.guestDetails(SelectSalutation, FirstName, LastName, MobileNo, Email);
	}

	@When("User click credit\\/Debit\\/ATM Card and click card type as debit card and enter the payment details")
	public void user_click_credit_debit_atm_card_and_click_card_type_as_debit_card_and_enter_the_payment_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> paymentDetails = dataTable.asMaps(String.class, String.class);
		 Map<String, String> details = paymentDetails.get(0); 
		 payment.Payment(details.get("SelectCard"), details.get("CardNo"), details.get("CardName"), details.get("Month"), details.get("Year"), details.get("CVV"));
		 
	}

	@When("User should verify after hotel booking success message {string} and save the order ID")
	public void user_should_verify_after_hotel_booking_success_message_and_save_the_order_id(String string) {
		String getbookingIDHotel = payment.getbookingIDHotel();
		System.out.println(getbookingIDHotel);
		String getbookingHotelName = payment.getbookingHotelName();
		bookingId = ""+getbookingHotelName;
		System.out.println(getbookingHotelName);
		hotelName = ""+ getbookingHotelName;
		payment.clickBookingBtn();
		String replace = getbookingIDHotel.replace("#", "");
		bookingIdWithOutSpecialChar ="" +replace;
		System.out.println(bookingIdWithOutSpecialChar);
	}

	@Then("User should verify same selected Hotel is booked or not")
	public void user_should_verify_same_selected_hotel_is_booked_or_not() {
		String hotelID = bookingPage.getHotelID();
		System.out.println(hotelID);
		String hotelName = bookingPage.getHotelName();
		System.out.println(hotelName);
		String hotelPrice = bookingPage.getHotelPrice();
		System.out.println(hotelPrice);

	}
	@Given("User quit native app")
	public void user_quit_native_app() {
		closeApp();
	}

	@Given("User is on the OMR Branch hotel web application")
	public void user_is_on_the_omr_branch_hotel_web_application() throws InterruptedException {
		launchWebApp();
		
	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String userName, String password) throws InterruptedException {
	scrollDownInLoginField();
	loginWebPage = new LoginPageInWebView(BaseClass.adriver);
//	String contactName = loginWebPage.contactName();
//	System.out.println("Contact Name:" + contactName);
//	String contactNumber = loginWebPage.contactNumber();
//	System.out.println("Contact Number:"+ contactNumber);
	loginWebPage.enterCredentialsAndClickLogin(userName, password);
	}

	@When("User go to my account page")
	public void user_go_to_my_account_page() {
		homePageWeb  =	new HomePageInWebView(BaseClass.adriver);
//		String homePageHeaderName = homePageWeb.homePageHeaderName();
//		System.out.println("Home Page Header:"+ homePageHeaderName);
		homePageWeb.navigateToMyBookingPage();
	}

	@When("User search the Order ID")
	public void user_search_the_order_id() {
		bookingpageWeb =	new BookingsPageInWebView(BaseClass.adriver);
		bookingpageWeb.searchHotelUsingBookingId(bookingIdWithOutSpecialChar);
		
		
		
	}

	@Then("User should verify same booked Order ID is present or not")
	public void user_should_verify_same_booked_order_id_is_present_or_not() {
		String bookingId2 = bookingpageWeb.getBookingId(bookingId);
		System.out.println(bookingId2);
	}

	@Then("User should verify same booked Hotel Name is present or not")
	public void user_should_verify_same_booked_hotel_name_is_present_or_not() {
		String hotelName2 = bookingpageWeb.getHotelName(hotelName);
		System.out.println(hotelName2);
	}

	@Then("User should verify same booked Hotel Price is present or not")
	public void user_should_verify_same_booked_hotel_price_is_present_or_not() {
		String hotelTotalPrice = bookingpageWeb.getHotelTotalPrice();
		System.out.println(hotelTotalPrice);
		String checkInDate = bookingpageWeb.getCheckInDate();
		System.out.println("Before change the Check in Date:"+ checkInDate);
		String checkOutDate = bookingpageWeb.getCheckOutDate();
		System.out.println("Before change the Check Out Date:"+ checkOutDate);
	}

	@When("User edit the Check-in Date {string} and Check-out Date {string}")
	public void user_edit_the_check_in_date_and_check_out_date(String ModifyDate, String ChangeCheckoutDate) {
		bookingpageWeb.clickEditBtn();
		editBookingPageWeb =new EditBookingPageInWebView(BaseClass.adriver);
		editBookingPageWeb.changeCheckInAndCheckOutDate(ModifyDate, ChangeCheckoutDate);

	}

	@Then("User should verify after modify check-in date success message {string}")
	public void user_should_verify_after_modify_check_in_date_success_message(String string) {
		String successfullyTxt = editBookingPageWeb.getSuccessfullyTxt();
		System.out.println("successfully Message:"+ successfullyTxt);
		bookingpageWeb.searchHotelUsingBookingId(bookingIdWithOutSpecialChar);
		scrollDown();
		String bookingId3 = bookingpageWeb.getBookingId(bookingId);
		System.out.println(bookingId3);
		String hotelName3 = bookingpageWeb.getHotelName(hotelName);
		System.out.println(hotelName3);
		String hotelTotalPrice1 = bookingpageWeb.getHotelTotalPrice();
		System.out.println(hotelTotalPrice1);
		String afterCheckInDate = bookingpageWeb.getCheckInDate();
		System.out.println("After change the Check in Date:"+ afterCheckInDate);
		String AfterCheckOutDate = bookingpageWeb.getCheckOutDate();
		System.out.println("After change the Check Out Date:"+ AfterCheckOutDate);
	}


}
