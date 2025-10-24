package com.qa;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class LoginPage extends BaseClass {

	AppiumDriver driver;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"login_joining_automation_text\"]")
	private WebElement homePageHeader;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"login_contact\"]")
	private WebElement contactNameAndNumber;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Email Address\"]")
	private WebElement txtUserName;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Password\"]")
	private WebElement txtPassword;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"login_button\"]")
	private WebElement btnLogin;

	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Login')]")
	private WebElement welcomeMessage;

	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterCredentialsAndClickLogin(String userName, String password) {
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}

	public String getWelcomeMessageText() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return welcomeMessage.getText();
	}

	public String getHomePageHeaderName() {
		return homePageHeader.getText();
	}

	public String contactNameAndNumber() {
		return contactNameAndNumber.getText();

	}

}
