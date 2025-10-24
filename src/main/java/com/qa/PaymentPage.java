package com.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PaymentPage extends BaseClass {
	AppiumDriver driver;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Credit/Debit/ATM Card\"]")
	private WebElement selectCreditAndDebitCardOption;
	
	@FindBy(xpath = "//android.view.View[@resource-id=\"payment_type\"]")
	private WebElement clickSelectCardTypeDropdown;
	
	@FindBy(xpath = "//android.view.View[@resource-id=\"card_type\"]")
	private WebElement clickSelectCardDropdown;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"card_no\"]")
	private WebElement cardNo;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"card_name\"]")
	private WebElement cardName;
	
	@FindBy(xpath = "//android.view.View[@resource-id=\"card_month\"]")
	private WebElement clickCardValidMonthDropdown;
	
	@FindBy(xpath = "//android.view.View[@resource-id=\"card_year\"]")
	private WebElement clickCardValidYearDropdown;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"cvv\"]")
	private WebElement cvvNumber;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"submitBtn\"]")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Booking is Confirmed')]")
	private WebElement bookingID;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'is booked!')]")
	private WebElement bookingHotelName;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"My Booking\"]")
	private WebElement clickMyBookingBtn;
	
	public PaymentPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getbookingIDHotel() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		String bookedID = bookingID.getText();
		return bookedID;
	}
	
	public String getbookingHotelName() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		String hotelName = bookingHotelName.getText();
		return hotelName;
	}
	
	public void Payment(String SelectCard, String CardNo,String CardName, String Month, String Year,String CVV) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		selectCreditAndDebitCardOption.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		scrollDown();
		clickSelectCardTypeDropdown.click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Debit Card\"]")).click();
		clickSelectCardDropdown.click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text='"+SelectCard+"']")).click();
		cardNo.sendKeys(CardNo);
		cardName.sendKeys(CardName);
		clickCardValidMonthDropdown.click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text='"+Month+"']")).click();
		clickCardValidYearDropdown.click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text='"+Year+"']")).click();
		cvvNumber.sendKeys(CVV);
		submitBtn.click();
	
	}
	public void clickBookingBtn() {
		clickMyBookingBtn.click();

	}

}
