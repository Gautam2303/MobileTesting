package com.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LoginPageInWebView extends BaseClass {
	AndroidDriver adriver;

//	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"login_joining_automation_text\"]")
//	private WebElement homePageHeader;

	@FindBy(xpath = "//a[@class='btn btn-contact']")
	private WebElement contactName;
	
	@FindBy(xpath = "//i[@class='fa-solid fa-phone text-dark']")
	private WebElement contactNumber;

	@FindBy(id ="email")
	private WebElement txtUserNameWebView;

	@FindBy(id ="pass")
	private WebElement txtPasswordWebView;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLoginWebView;
	
	@FindBy(xpath = "//span[contains(text(), 'Welcome to our site, if you')]")
	private WebElement aiPopup;

//	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Login')]")
//	private WebElement welcomeMessage;

//	 public LoginPageInWebView(AndroidDriver adriver) {
//	        this.adriver = adriver;
//	        PageFactory.initElements(adriver, this);
//	    }
	
	public LoginPageInWebView(AndroidDriver adriver) {
		 this.adriver = adriver;
	        PageFactory.initElements(adriver, this);
	}

	public void enterCredentialsAndClickLogin(String userName, String password) {
		txtUserNameWebView.sendKeys(userName);
		txtPasswordWebView.sendKeys(password);
		btnLoginWebView.click();
//		if (aiPopup.isDisplayed()) {
//			adriver.findElement(By.xpath("//i[contains(@class, 'tawk-icon tawk-icon-x')]")).click();
//			btnLoginWebView.click();
//		}else {
//			btnLoginWebView.click();
//		}
		
	}

//	public String getWelcomeMessageText() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		return welcomeMessage.getText();
//	}
//
//	public String getHomePageHeaderName() {
//		return homePageHeader.getText();
//	}

	public String contactName() throws InterruptedException {
		
		return contactName.getText();

	}
	public String contactNumber() {
		String text = contactNumber.getText();
		return text;
	}


}
