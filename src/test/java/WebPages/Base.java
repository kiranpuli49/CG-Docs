package WebPages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Baseclass.Driver;

public class Base extends Driver{	
	
	//Click Functionality
	public void click(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else {

			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
	}
   //Text Box
	public void type(String locator, String Value) {
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(Value);

	}

	static WebElement dropdown;
    //Select the Element by Index
	public void select(String locator, int value) {
		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
			Select select = new Select(dropdown);
			select.selectByIndex(value);
		} else {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
			Select select = new Select(dropdown);
			select.selectByIndex(value);
		}


	}
    //GETTEXT
	public String getText(String locator) {
		return driver.findElement(By.xpath(OR.getProperty(locator))).getText();
	}
    //Screenshot
	public static void screenshot(String Scfilename) {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C://Users//kipuli//eclipse//XYZBank_dec//Screenshots//" + Scfilename + ".png"));
		} catch (IOException e) {
			System.out.println("Screenshot not found");
		}
	}
	//ExplicitWait-AlertPresent
	public static void explicitwait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
   //ExplicitWait-Visibility
	public static void ExplicitwaitVis(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty(locator))));
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(locator))));
		}

	}
   //Element Present
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	//FluentWait
	public void FluentWait(By element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(6));
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}
