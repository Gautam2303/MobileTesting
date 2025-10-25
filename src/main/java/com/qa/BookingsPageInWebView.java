package com.qa;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BookingsPageInWebView extends BaseClass{
	AndroidDriver driver;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchByBookingField;
	
	@FindBy(xpath = "//strong[@class='total-prize']")
	private WebElement getTotalPrice;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Check-In')]")
	private WebElement getCheckInDate;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Check-Out')]")
	private WebElement getCheckOutDate;
	
	@FindBy(xpath = "//button[@class='edit btn filter_btn']")
	private WebElement editBtn;
	
	public BookingsPageInWebView(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchHotelUsingBookingId(String myBookingId) throws InterruptedException {
		Thread.sleep(3500);
		searchByBookingField.sendKeys(myBookingId);

	}
	
	public String getBookingId(String bookingId) {
		JavascriptExecutor js = (JavascriptExecutor) adriver;
		WebElement element = adriver.findElement(By.xpath("//h5[text()='Evoma Deluxe']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		WebElement getBookingId = adriver.findElement(By.xpath("//span[text()='"+bookingId+"']"));
		String bookId = getBookingId.getText();
		return bookId;
	}
	public String getHotelName(String hotelName) {
		WebElement getHotel = adriver.findElement(By.xpath("//h5[text()='"+hotelName+"']"));
		String Name = getHotel.getText();
		return Name;
	}
	
	public String getHotelTotalPrice() {
		JavascriptExecutor js = (JavascriptExecutor) adriver;
		WebElement element = adriver.findElement(By.xpath("//input[contains(@placeholder,'Check-In')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		String totalPrice = getTotalPrice.getText();
		return totalPrice;
	}
	
	public String getCheckInDate() {
		@Nullable
		String checkinDate = getCheckInDate.getAttribute("placeholder");
		return checkinDate;
	}
	public String getCheckOutDate() {
		@Nullable
		String checkOut = getCheckOutDate.getAttribute("placeholder");
		return checkOut;
	}
	public void clickEditBtn() {
	editBtn.click();

	}
	
	
}
