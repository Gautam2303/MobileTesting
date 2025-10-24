package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class SelectHotelPage extends BaseClass{
	AppiumDriver driver;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"select_hotel_text\"]")
	private WebElement selectHotelPageHeader;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"hotel_name\"]")
	private WebElement hotelName;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"hotel_price_with_tax\"]")
	private WebElement hotelPrice;
	
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"hotel_continue_button\"]")
	private WebElement HotelContinueBtn;
	
	public SelectHotelPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getSelectHotelPageHeaderName() {
		return selectHotelPageHeader.getText();
	}
	public String getHotelName() {
		String getHotelName = hotelName.getText();
		return getHotelName;
	}
	
	public String getHotelPrice() {
		String hotelPrice1 = hotelPrice.getText();
		return hotelPrice1;
	}
	public String clickHotelContinueBtn() {
		String popup = "";
		HotelContinueBtn.click();
		WebElement validatePopupText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]"));
		if (validatePopupText.isDisplayed()) {
			String popupTxt = validatePopupText.getText();
			popup =""+popupTxt;
			System.out.println(popupTxt);
			driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")).click();
		}
		return popup;
	}
}
