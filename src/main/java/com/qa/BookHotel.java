package com.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class BookHotel extends BaseClass{
	AppiumDriver driver;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"book_hotel_text\"]")
	private WebElement bookHotelPageHeader;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Select Salutation\"]")
	private WebElement clickSelectSalutation;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"book_hotel_first_name\"]")
	private WebElement firstName;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"book_hotel_last_name\"]")
	private WebElement lastName;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"book_hotel_mobile_no\"]")
	private WebElement mobileNo;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"book_hotel_email\"]")
	private WebElement eMail;
	
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"book_hotel_next_button\"]")
	private WebElement nxtBtn;
	
	public BookHotel(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String bookHotelPageHeadername() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String bookHotelHeader = bookHotelPageHeader.getText();
		return bookHotelHeader;
	}
	public void guestDetails(String SelectSalutation, String FirstName, String LastName, String MobileNo, String Email) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		scrollDown();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Myself\"]")).click();
		clickSelectSalutation.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+ SelectSalutation +"']")).click();
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		mobileNo.sendKeys(MobileNo);
		eMail.sendKeys(Email);
		nxtBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		nxtBtn.click();
	}

}
