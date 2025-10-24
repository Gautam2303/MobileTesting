package com.qa;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;


public class BaseClass {
	protected static AppiumDriver driver;
	public static AndroidDriver adriver;
	
	public static void launchAppium() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium:deviceName", "15927997600005R");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "14");
		cap.setCapability("appium:automationName", "uiAutomator2");
		cap.setCapability("appium:appPackage", "com.omr_branch");
		cap.setCapability("appium:appActivity", "com.omr_branch.MainActivity type=1");
		driver = new AppiumDriver(cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void scrollDown() {
		//Swap Functions
				Dimension dimension = driver.manage().window().getSize();
				int height = dimension.getHeight();
				int width = dimension.getWidth();
				
				int startY = (int) (height*0.8);
				int endY = (int) (height*0.2);
				int centreX = (int) (width*0.5);
				int starty1 = (int) (height*0.7);
				int centreX1 = (int) (width*0.7);
				
				PointerInput input = new PointerInput(Kind.TOUCH, "finger1");
				Sequence seq = new Sequence(input, 1);
				
				seq.addAction(input.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centreX1, starty1));
				seq.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
				seq.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centreX1, endY));
				seq.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
				
				List<Sequence> asList = Arrays.asList(seq);
				
				RemoteWebDriver rDriver = (RemoteWebDriver) driver;
				rDriver.perform(asList);
	}
	
	public static void launchWebApp() throws InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium:deviceName", "15927997600005R");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:browserName", "chrome");
		cap.setCapability("appium:automationName", "uiAutomator2");
	//	cap.setCapability("uiAutomator2ServerLaunchTimeout", 90000);
//		cap.setCapability("appium:appPackage", "com.android.chrome");
//		cap.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main type=1");
//		driver = new AppiumDriver(cap);
		adriver = new AndroidDriver(cap);
		@Nullable
		String context = adriver.getContext();
		System.out.println(context);
		
		Set<String> contextHandles = adriver.getContextHandles();
		System.out.println(contextHandles);
		adriver.get("https://www.omrbranch.com/");
		
		adriver.context("NATIVE_APP");

		adriver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Allow while visiting the site\"]")).click();
		// Then switch back to webview
		adriver.context("CHROMIUM");
		Thread.sleep(3000);
		adriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	
	public void closeApp() {
		 System.out.println("🔹 Closing the App...");

	        try {
	            if (driver != null) {
	                ((InteractsWithApps) driver).terminateApp("com.omr_branch"); // fully close the app
	                driver.quit(); // end session
	            }
	        } catch (Exception e) {
	            System.out.println("⚠️ Error while closing app: " + e.getMessage());
	        }
	    }

	public void scrollDownInLoginField() {
		JavascriptExecutor js = (JavascriptExecutor) adriver;
		WebElement element = adriver.findElement(By.xpath("//a[@class='btn btn-whatsapp']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

}
