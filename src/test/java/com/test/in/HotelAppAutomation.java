package com.test.in;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

public class HotelAppAutomation {
	public static void main(String[] args) {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium:deviceName", "15927997600005R");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "14");
		cap.setCapability("appium:automationName", "uiAutomator2");
		cap.setCapability("appium:appPackage", "com.omr_branch");
		cap.setCapability("appium:appActivity", "com.omr_branch.MainActivity type=1");
		//cap.setCapability("appWaitActivity", "*");
		//cap.setCapability("newCommandTimeout", 120);
		AppiumDriver driver = new AppiumDriver(cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Print the Login Page Header Name & Contact Name and Number
		WebElement headerName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"login_joining_automation_text\"]"));
		String loginPageHeaderName = headerName.getText();
		System.out.println("Application Header Name =>" +loginPageHeaderName);
		
		WebElement contact = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"login_contact\"]"));
		String contactNameAndNumber = contact.getText();
		System.out.println("Contact =>" +contactNameAndNumber);
		 
		//Login the Application Using Validate credentials
		WebElement txtEmail = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Email Address\"]"));
		txtEmail.sendKeys("gowtham6306@gmail.com");
		
		WebElement txtPass = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password\"]"));
		txtPass.sendKeys("Gow@2303");
		
		WebElement loginButton = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"login_button\"]"));
		loginButton.click();   
		
		System.out.println("User Logged in successfully");
		
		//Print the "Explore Hotel page" header
		WebElement exploreViewPageHeader = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"search_explore_hotel\"]"));
		String explorePageHeader = exploreViewPageHeader.getText();
		System.out.println("Explore Hotel Page Header =>" + explorePageHeader);
		
		//select the state and print state name 
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select State\"]")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Kerala\"]")).click();
		WebElement getTextInSelectedState = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Kerala\"]"));
		String selectedState = getTextInSelectedState.getText(); 	
		System.out.println("Selected State =>" + selectedState);
		
		//Select the city and print City Name
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select City\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Kochi\"]")).click();
		WebElement getTextInSelectedCity = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Kochi\"]"));
		String selectedCity = getTextInSelectedCity.getText();
		System.out.println("Selected City =>"+ selectedCity);
		
		//Select the Room type and print type name
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select Room Type\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Deluxe\"]")).click();
		WebElement getTextInSelectedRoomType = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"room_type_Deluxe\"]"));
		String roomType = getTextInSelectedRoomType.getText();
		System.out.println("Selected Room Type =>"+ roomType);
		
		//select the Check In date and print the date
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search_select_checkin\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		WebElement getTextInSelectedCheckIn = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search_select_checkin\"]"));
		String checkInDate = getTextInSelectedCheckIn.getText();
		System.out.println("Check In Data =>"+ checkInDate);
		
		//select the Check out date and print the date
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search_select_checkout\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		WebElement getTextInSelectedCheckOut = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search_select_checkout\"]"));
		String checkOutDate = getTextInSelectedCheckOut.getText();
		System.out.println("Check Out Date =>"+ checkOutDate);
		
		//Select No of Rooms and print that
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"No. Of Room\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"1-One\"]")).click();
		WebElement getTxtinSelectedRoomDropDown = driver.findElement(By.xpath("//android.widget.TextView[@text=\"1-One\"]"));
		String selectedRooms = getTxtinSelectedRoomDropDown.getText();
		System.out.println("Selected Room =>"+ selectedRooms);
		
		//Select the Adults and Print Adults count
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"No. Of Adults\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"2-Two\"]")).click();
		WebElement getTextInAdultsDropDown = driver.findElement(By.xpath("//android.widget.TextView[@text=\"2-Two\"]"));
		String noOfAdult = getTextInAdultsDropDown.getText();
		System.out.println("No of Adults =>"+ noOfAdult);
	
		//select the children and print children 
		WebElement noOfChildren = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search_no_of_children\"]"));
		noOfChildren.sendKeys("2");
		
		//Click Search Button
		driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"search_button\"]")).click();
		
		//Print Select Hotel page Header
		WebElement getSelectHotelPageHeader = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"select_hotel_text\"]"));
		String hotelPageHeader = getSelectHotelPageHeader.getText();
		System.out.println("Hotel Page Header =>"+ hotelPageHeader);
	
		//Select the Hotel
		//Swap Functions
		Dimension dimension = driver.manage().window().getSize();
		int height = dimension.getHeight();
		int width = dimension.getWidth();
		
		int startY = (int) (height*0.8);
		int endY = (int) (height*0.2);
		int centreX = (int) (width*0.5);
		int starty1 = (int) (height*0.7);
		int centreX1 = (int) (width*0.7);
		
		PointerInput input = new PointerInput(Kind.TOUCH, "finger1");
		Sequence seq = new Sequence(input, 1);
		
		seq.addAction(input.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centreX1, starty1));
		seq.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centreX1, endY));
		seq.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		List<Sequence> asList = Arrays.asList(seq);
		
		RemoteWebDriver rDriver = (RemoteWebDriver) driver;
		rDriver.perform(asList);
		
		
		WebElement getHotelName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"hotel_name\"]"));
		String HotelName = getHotelName.getText();
		System.out.println("Selected Hotel Name :"+ HotelName);
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"hotel_continue_button\"]")).click();
		WebElement validatePopupText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]"));
		if (validatePopupText.isDisplayed()) {
			String popupTxt = validatePopupText.getText();
			System.out.println(popupTxt);
			
			driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")).click();
		}
		
		//Book Hotel Page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
//		WebElement getBookHotelPageHeader = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"book_hotel_text\"]"));
//		String bookHotelPageHeader = getBookHotelPageHeader.getText();
//		System.out.println("Book Hotel Page:"+ bookHotelPageHeader);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		rDriver.perform(asList);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		rDriver.perform(asList);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Myself\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select Salutation\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Mr.\"]")).click();
		WebElement getTxtInSelectedSalutationDropDown = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Mr.\"]"));
		String seletedSalutation = getTxtInSelectedSalutationDropDown.getText();
		System.out.println("Select Salutation: "+ seletedSalutation);
		
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"book_hotel_first_name\"]")).sendKeys("Gowtham");
		WebElement getTxtInFirstNameField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"book_hotel_first_name\"]"));
		String firstName = getTxtInFirstNameField.getText();
		System.out.println("First Name :"+ firstName);
		
		WebElement secondNameField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"book_hotel_last_name\"]"));
		secondNameField.sendKeys("Murugan");
		String getTxtSecondName = secondNameField.getText();
		System.out.println("Second Name: "+ getTxtSecondName);
		
		WebElement mobNumField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"book_hotel_mobile_no\"]"));
		mobNumField.sendKeys("8508054760");
		String mobNum = mobNumField.getText();
		System.out.println("mobile Number :"+ mobNum);
		
		WebElement eMailTxtBox = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"book_hotel_email\"]"));
		eMailTxtBox.sendKeys("gowtham@gmail.com");
		String eMail = eMailTxtBox.getText();
		System.out.println("E-mail :"+ eMail);
		
		WebElement nextbtn = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"book_hotel_next_button\"]"));
		nextbtn.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		nextbtn.click();
		
		//payment page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Credit/Debit/ATM Card\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		rDriver.perform(asList);
		
		WebElement getSelectedCard = driver.findElement(By.xpath("//android.view.View[@resource-id=\"payment_type\"]"));
		getSelectedCard.click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Debit Card\"]")).click();
		String selectedCard = getSelectedCard.getText();
		System.out.println("Select Card :"+ selectedCard);
		
		WebElement getCardType = driver.findElement(By.xpath("//android.view.View[@resource-id=\"card_type\"]"));
		getCardType.click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Visa\"]")).click();
		String cardType = getCardType.getText();
		System.out.println("Card Type : "+ cardType);
		
		WebElement cardNumTxt = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"card_no\"]"));
		cardNumTxt.sendKeys("5555555555552222");
		String cardNum = cardNumTxt.getText();
		System.out.println("Card Number :"+ cardNum);
		
		WebElement cardName = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"card_name\"]"));
		cardName.sendKeys("Gowtham");
		String getCardName = cardName.getText();
		System.out.println("Card Holder Name :"+ getCardName);
		
	    WebElement cardValidMonth = driver.findElement(By.xpath("//android.view.View[@resource-id=\"card_month\"]"));
	    cardValidMonth.click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"March\"]")).click();
	    String getCardValidMonth = cardValidMonth.getText();
	    System.out.println("Card Valid Month : "+ getCardValidMonth);
	    
	    WebElement cardValidYear = driver.findElement(By.xpath("//android.view.View[@resource-id=\"card_year\"]"));
	    cardValidYear.click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"2028\"]")).click();
	    String cardYear = cardValidYear.getText();
	    System.out.println(cardYear);
	    
	    WebElement cvvNum = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"cvv\"]"));
	    cvvNum.sendKeys("023");
	    String getCvvNum = cvvNum.getText();
	    System.out.println("CVV Number :"+ getCvvNum);
	    
	    //submit button
	    driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"submitBtn\"]")).click();
	    
	    //Booking Number Page
//	    WebElement getBookingNum = driver.findElement(By.xpath("//android.widget.TextView[@text=\"#NSJNT76646 Booking is Confirmed\"]"));
//	    String bookingNum = getBookingNum.getText();
//	    System.out.println("Booking Number:"+ bookingNum);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	    driver.findElement(By.xpath("//android.widget.TextView[@text=\"My Booking\"]")).click();
	    
	    WebElement getBookingId = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"hotel_booking_id\"]"));
	    String bookingId = getBookingId.getText();
	    System.out.println("Booking ID :"+ bookingId);
	}
	

}
