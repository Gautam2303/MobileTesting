package com.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HomePageInWebView extends BaseClass {
	
	AndroidDriver adriver;

	@FindBy(xpath = "//h5[contains(@class, 'welcome-heading')]")
	private WebElement homePageHeader;
	
	@FindBy(xpath = "//a[@class='icoTwitter mr-2 dropdown-toggle']")
	private WebElement clickUserName;
	
	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement clickMyAccountOption;
	
	@FindBy(xpath = "//a[text()='My Bookings']")
	private WebElement clickMyBookingsOption;
	
	public HomePageInWebView(AndroidDriver adriver) {
		this.adriver = adriver;
		PageFactory.initElements(adriver, this);
	}

	
	public String homePageHeaderName() {
		return homePageHeader.getText();

	}
	
	public void navigateToMyBookingPage() {
		clickUserName.click();
		clickMyAccountOption.click();
		clickMyBookingsOption.click();

	}

}
