package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class EditBookingPageInWebView extends BaseClass{
	AndroidDriver adriver;

	@FindBy(xpath = "//h2[contains(text(),'Edit Booking')]")
	private WebElement editBookingPageHeader;
	
	@FindBy(xpath = "//input[@name='check_in']")
	private WebElement clickCheckInOption;
	
	@FindBy(xpath = "//input[@name='check_out']")
	private WebElement clickCheckOutOption;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirmBtn;
	
	@FindBy(xpath = "//li[@class='alertMsg']")
	private WebElement bookingSuccessfullyTxt;
	
	public EditBookingPageInWebView(AndroidDriver adriver) {
		this.adriver = adriver;
		PageFactory.initElements(adriver, this);
	}
	
	public void changeCheckInAndCheckOutDate(String ModifyDate, String ChangeCheckoutDate) {
		clickCheckInOption.click();
		adriver.findElement(By.xpath("//a[text()='"+ModifyDate+"']")).click();
		clickCheckOutOption.click();
		adriver.findElement(By.xpath("//a[text()='"+ChangeCheckoutDate+"']")).click();
	}
	
	public String getSuccessfullyTxt() {
		String text = bookingSuccessfullyTxt.getText();
		return text;
	}

}
