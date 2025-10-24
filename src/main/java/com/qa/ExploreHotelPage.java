package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class ExploreHotelPage extends BaseClass{
	
	AppiumDriver driver;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"search_explore_hotel\"]")
	private WebElement exploreHotelPageHeader;
	
	@FindBy(xpath= "//android.widget.TextView[@text=\"Select State\"]")
	private WebElement clickSelectStateDropdown;
	

	@FindBy(xpath= "//android.widget.TextView[@text=\"Select City\"]")
	private WebElement clickSelectCityDropdown;
	
	@FindBy(xpath= "//android.widget.TextView[@text=\"Select Room Type\"]")
	private WebElement clickSelectedRoomDropdown;
	
	@FindBy(xpath= "//android.widget.EditText[@content-desc=\"search_select_checkin\"]")
	private WebElement clickCheckInOption;
	
	@FindBy(xpath= "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement clickOkBtnInCalendar;
	
	@FindBy(xpath= "//android.widget.EditText[@content-desc=\"search_select_checkout\"]")
	private WebElement clickCheckOutOption;
	
	@FindBy(xpath= "//android.widget.TextView[@text=\"No. Of Room\"]")
	private WebElement clickNoOfRoomsDropdown;
	
	@FindBy(xpath= "//android.widget.TextView[@text=\"No. Of Adults\"]")
	private WebElement clickNoOfAdultsDropdown;
	
	@FindBy(xpath= "//android.widget.EditText[@content-desc=\"search_no_of_children\"]")
	private WebElement enterNoOfChilds;
	
	@FindBy(xpath= "//android.view.ViewGroup[@resource-id=\"search_button\"]")
	private WebElement clickSearchBtn;
	
	public ExploreHotelPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void getExploreHotelPageHeaderName() {
		 String text = exploreHotelPageHeader.getText();
		 System.out.println(text);
	}
	
	public void searchHotel(String state, String city, String roomType, String checkIn, String checkOut, String NoofRoom, String NoofAdults, String NoofChilds) {
		clickSelectStateDropdown.click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='"
		+state+"']")).click();
		clickSelectCityDropdown.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+ city +"']")).click();
		clickSelectedRoomDropdown.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\""+roomType+"\"]")).click();
		clickCheckInOption.click();
		driver.findElement(By.xpath("//android.view.View[@content-desc=\""+checkIn+"\"]")).click();
		clickOkBtnInCalendar.click();
		clickCheckOutOption.click();
		driver.findElement(By.xpath("//android.view.View[@content-desc=\""+checkOut+"\"]")).click();
		clickOkBtnInCalendar.click();
		clickNoOfRoomsDropdown.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\""+NoofRoom+"\"]")).click();
		clickNoOfAdultsDropdown.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\""+NoofAdults+"\"]")).click();
		enterNoOfChilds.sendKeys(NoofChilds);
		clickSearchBtn.click();
		
	}
}
