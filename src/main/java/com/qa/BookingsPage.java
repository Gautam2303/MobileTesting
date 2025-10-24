package com.qa;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class BookingsPage extends BaseClass{
	AppiumDriver driver;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"hotel_booking_id\"]")
	private WebElement hotelBookingID;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"hotel_name\"]")
	private WebElement hotelName;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"hotel_price_with_tax\"]")
	private WebElement hotelPrice;
	
	public BookingsPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHotelID() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		String bookedID = hotelBookingID.getText();
		return bookedID;
	}
	
	public String getHotelName() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		String hotelName1 = hotelName.getText();
		return hotelName1;
	}
	
	public String getHotelPrice() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		String price = hotelPrice.getText();
		return price;
	}
	
	

}
